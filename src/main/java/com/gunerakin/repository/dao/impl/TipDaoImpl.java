package com.gunerakin.repository.dao.impl;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.gunerakin.model.Tip;
import com.gunerakin.repository.dao.TipDao;

@Repository
public class TipDaoImpl implements TipDao {

	@Inject
	SessionFactory sessionFactory;
	
	@Override
	public List<Tip> tipleriGetir() {
		
		return  sessionFactory.getCurrentSession().createQuery("FROM Tip").list();
		
	}

	@Override
	public Tip tipGetirById(int id) {

		return sessionFactory.getCurrentSession().get(Tip.class, id);
	}

}
