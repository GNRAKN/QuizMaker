package com.gunerakin.repository.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.gunerakin.model.CoktanSecmeli;
import com.gunerakin.repository.dao.CoktanSecmeliDao;

@Repository
public class CoktanSecmeliDaoImpl implements CoktanSecmeliDao {

	@Inject
	SessionFactory sessionFactory;

	@Override
	public List<CoktanSecmeli> listele_CS(long kategoriId, String zorluk) {

		return sessionFactory.getCurrentSession()
				.createQuery("From CoktanSecmeli Where kategoriId=" + kategoriId + " and zorluk=" + zorluk).list();
	}

}
