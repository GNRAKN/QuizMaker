package com.gunerakin.repository.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.gunerakin.model.Kategori;
import com.gunerakin.repository.dao.KategoriDao;

@Repository
public class KategoriDaoImpl implements KategoriDao {

	@Inject
	SessionFactory sessionFactory;

	@Override
	public List<Kategori> kategoriListele() {
		return sessionFactory.getCurrentSession().createQuery("From Kategori").list();
	}

	@Override
	public Kategori kategoriGetirById(long kategori_id) {
		
		return sessionFactory.getCurrentSession().get(Kategori.class, kategori_id);
	}

}
