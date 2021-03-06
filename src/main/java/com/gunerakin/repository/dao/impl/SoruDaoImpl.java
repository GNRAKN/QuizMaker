package com.gunerakin.repository.dao.impl;

import java.util.List;
import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;
import com.gunerakin.model.Kategori;
import com.gunerakin.model.Soru;
import com.gunerakin.repository.dao.SoruDao;

@Repository
public class SoruDaoImpl implements SoruDao {

	@Inject
	SessionFactory sessionFactory;
	
	
	@Override
	public void ekleSoru(Soru soru) {
		
		sessionFactory.getCurrentSession().save(soru);
		
	}

	@Override
	public List<Soru> listeleSorular() {

		return sessionFactory.getCurrentSession().createQuery("FROM Soru").list();
		
	}

	@Override
	public Soru getirSoruById(long soru_id) {


		return sessionFactory.getCurrentSession().get(Soru.class, soru_id);
	}

	@Override
	public void guncelleSoru(Soru soru) {
		
		sessionFactory.getCurrentSession().update(soru);
		
	}

	@Override
	public void silSoru(long soru_id) {
		
		Soru soru=new Soru();
		soru.setSoru_id(soru_id);
		sessionFactory.getCurrentSession().delete(soru);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Soru> listeleSoruByKategoriZorluk(long kategori_id, String zorluk) {
		return sessionFactory.getCurrentSession().createQuery("from Soru as soru where soru.kategori='"
				+ kategori_id + "' and soru.zorluk='" + zorluk + "'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Soru> listeleSoruByZorluk(String zorluk) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Soru as soru where soru.zorluk='" + zorluk + "'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Soru> listeleSoruByKategori(long kategori_id) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Soru as soru where soru.kategori='" + kategori_id + "'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Kategori> listeleKategoriBySoru() {
		return sessionFactory.getCurrentSession().createQuery("SELECT s.kategori FROM Soru s GROUP BY s.kategori").list();
	}

	@SuppressWarnings("deprecation")
	@Override
	public long count() {
		return (Long) sessionFactory.getCurrentSession().createCriteria("Soru").setProjection(Projections.rowCount())
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Soru> readQuestion10(int number) {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Soru s where s.soru_id > "+number+"").list();//bu sekilde olmaz veritabanında id ler 1 den baslamıyor olabilir !	}

	

}
