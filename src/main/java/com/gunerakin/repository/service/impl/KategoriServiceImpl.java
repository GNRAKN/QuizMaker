package com.gunerakin.repository.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gunerakin.model.Kategori;
import com.gunerakin.repository.dao.KategoriDao;
import com.gunerakin.repository.service.KategoriService;

@Service
@Transactional
public class KategoriServiceImpl implements KategoriService {

	@Inject
	KategoriDao kategoriDao;

	@Override
	public List<Kategori> kategoriListele() {

		return kategoriDao.kategoriListele();
	}

	@Override
	public Kategori kategoriGetirById(long kategori_id) {

		return kategoriDao.kategoriGetirById(kategori_id);
	}

}
