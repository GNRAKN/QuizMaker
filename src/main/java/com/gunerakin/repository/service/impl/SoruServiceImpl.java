package com.gunerakin.repository.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gunerakin.model.Kategori;
import com.gunerakin.model.Soru;
import com.gunerakin.repository.dao.SoruDao;
import com.gunerakin.repository.service.SoruService;

@Service
@Transactional
public class SoruServiceImpl implements SoruService {

	@Inject
	SoruDao soru_DAO;

	@Override
	public void ekleSoru(Soru soru) {
		
		soru_DAO.ekleSoru(soru);
	}

	@Override
	public List<Soru> listeleSorular() {
		return soru_DAO.listeleSorular();
	}

	@Override
	public Soru getirSoruById(long soru_id) {
		return soru_DAO.getirSoruById(soru_id);
	}

	@Override
	public void guncelleSoru(Soru soru) {

		soru_DAO.guncelleSoru(soru);
		
	}

	@Override
	public void silSoru(long soru_id) {

		soru_DAO.silSoru(soru_id);
		
	}

	@Override
	public List<Soru> listeleSoruByKategoriZorluk(long kategori_id, String zorluk) {

			return soru_DAO.listeleSoruByKategoriZorluk(kategori_id, zorluk);
	}

	@Override
	public List<Soru> listeleSoruByZorluk(String zorluk) {

		return soru_DAO.listeleSoruByZorluk(zorluk);
	}

	@Override
	public List<Soru> listeleSoruByKategori(long kategori_id) {
		
		return soru_DAO.listeleSoruByKategori(kategori_id);
	}

	@Override
	public List<Kategori> listeleKategoriBySoru() {
		
		return soru_DAO.listeleKategoriBySoru();
	}

	@Override
	public long count() {

		return soru_DAO.count();
	}

	@Override
	public List<Soru> readQuestion10(int number) {

		return soru_DAO.readQuestion10(number);
	}

	

}
