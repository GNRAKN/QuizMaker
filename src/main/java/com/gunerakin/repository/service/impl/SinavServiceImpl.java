package com.gunerakin.repository.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gunerakin.model.Sinav;
import com.gunerakin.repository.dao.SinavDao;
import com.gunerakin.repository.service.SinavService;

@Service
@Transactional
public class SinavServiceImpl implements SinavDao, SinavService {

	@Inject
	SinavDao sinavDao;

	@Override
	public void sinavKaydet(Sinav sinav) {

		sinavDao.sinavKaydet(sinav);

	}

	@Override
	public void sinavGuncelle(Sinav sinav) {

		sinavDao.sinavGuncelle(sinav);

	}

	@Override
	public Sinav sinavListeleById(long sinav_id) {

		return sinavDao.sinavListeleById(sinav_id);
	}

	@Override
	public List<Sinav> sinavListele() {
		
		return sinavDao.sinavListele();
	}

}
