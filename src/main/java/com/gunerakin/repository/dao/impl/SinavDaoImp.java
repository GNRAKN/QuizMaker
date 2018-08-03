package com.gunerakin.repository.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.gunerakin.model.Sinav;
import com.gunerakin.repository.dao.SinavDao;

@Repository
public class SinavDaoImp implements SinavDao {

	@Inject
	SessionFactory sessionFactory;

	@Override
	public void sinavKaydet(Sinav sinav) {

		sessionFactory.getCurrentSession().save(sinav);

	}

	@Override
	public void sinavGuncelle(Sinav sinav) {

		sessionFactory.getCurrentSession().update(sinav);

	}

	@Override
	public Sinav sinavListeleById(long sinav_id) {

		return sessionFactory.getCurrentSession().get(Sinav.class, sinav_id);
	}

	@Override
	public List<Sinav> sinavListele() {

		return sessionFactory.getCurrentSession().createQuery("From Sinav").list();
	}

}
