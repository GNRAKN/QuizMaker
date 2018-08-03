package com.gunerakin.repository.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.gunerakin.model.Kategori;
import com.gunerakin.model.Klasik;
import com.gunerakin.repository.dao.KlasikDao;

@Repository
public class KlasikDaoImpl implements KlasikDao {

	@Inject
	SessionFactory sessionFactory;

	@Override
	public void ekleKlasikSoru(Klasik klasik) {

		sessionFactory.getCurrentSession().save(klasik);
	}

	@Override
	public List<Klasik> listeleKlasikSorular() {

		return sessionFactory.getCurrentSession().createQuery("FROM Klasik").list();
	}

	@Override
	public Klasik listeleKlasikById(long k_id) {

		return sessionFactory.getCurrentSession().get(Klasik.class, k_id);

	}

	@Override
	public void guncelleKlasikSoru(Klasik klasik) {

		sessionFactory.getCurrentSession().update(klasik);

	}

	@Override
	public void silKlasikSoru(long k_id) {

		Klasik klasik = new Klasik();
		klasik.setK_id(k_id);
		sessionFactory.getCurrentSession().delete(klasik);
	}

	@Override
	public List<Klasik> listeleKlasikByKategoriZorluk(long kategori_id, String zorluk) {

		return sessionFactory.getCurrentSession().createQuery("from Klasik as klasik where klasik.kategori='"
				+ kategori_id + "' and klasik.k_zorluk='" + zorluk + "'").list();
	}

	@Override
	public List<Klasik> listeleKlasikByZorluk(String zorluk) {

		return sessionFactory.getCurrentSession()
				.createQuery("from Klasik as klasik where klasik.k_zorluk='" + zorluk + "'").list();
	}

	@Override
	public List<Klasik> listeleKlasikByKategori(long kategori_id) {

		return sessionFactory.getCurrentSession()
				.createQuery("from Klasik as klasik where klasik.kategori='" + kategori_id + "'").list();
	}

	@Override
	public long count() {

		return (Long) sessionFactory.getCurrentSession().createCriteria("Klasik").setProjection(Projections.rowCount())
				.uniqueResult();
	}

	@Override
	public List<Kategori> listeleKategoriBySoru() {
		return sessionFactory.getCurrentSession().createQuery("SELECT kategori FROM Klasik").list();
	}

}
