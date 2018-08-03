package com.gunerakin.repository.service.impl;

import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gunerakin.model.Kategori;
import com.gunerakin.model.Klasik;
import com.gunerakin.repository.dao.KlasikDao;
import com.gunerakin.repository.service.KlasikService;

@Service
@Transactional
public class KlasikServiceImpl implements KlasikService {

	@Inject
	KlasikDao klasikDao;

	@Override
	public void ekleKlasikSoru(Klasik klasik) {

		klasikDao.ekleKlasikSoru(klasik);

	}

	@Override
	public List<Klasik> listeleKlasikSorular() {

		return klasikDao.listeleKlasikSorular();
	}

	@Override
	public Klasik listeleKlasikById(long k_id) {

		return klasikDao.listeleKlasikById(k_id);
	}

	@Override
	public void guncelleKlasikSoru(Klasik klasik) {

		klasikDao.guncelleKlasikSoru(klasik);

	}

	@Override
	public void silKlasikSoru(long k_id) {

		klasikDao.silKlasikSoru(k_id);
	}

	@Override
	public List<Klasik> listeleKlasikByKategoriZorluk(long kategori_id, String zorluk) {

		return klasikDao.listeleKlasikByKategoriZorluk(kategori_id, zorluk);
	}

	@Override
	public List<Klasik> listeleKlasikByZorluk(String zorluk) {

		return klasikDao.listeleKlasikByZorluk(zorluk);
	}

	@Override
	public List<Klasik> listeleKlasikByKategori(long kategori_id) {

		return klasikDao.listeleKlasikByKategori(kategori_id);
	}

	@Override
	public long count() {

		return klasikDao.count();
	}

	@Override
	public List<Kategori> listeleKategoriBySoru() {

		return klasikDao.listeleKategoriBySoru();
	}

}
