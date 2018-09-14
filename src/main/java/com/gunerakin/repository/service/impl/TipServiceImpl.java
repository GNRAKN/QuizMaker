package com.gunerakin.repository.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gunerakin.model.Tip;
import com.gunerakin.repository.dao.TipDao;
import com.gunerakin.repository.service.TipService;

@Service
@Transactional
public class TipServiceImpl implements TipService {

	@Inject
	TipDao tipDao;
	
	
	@Override
	public List<Tip> tipleriGetir() {
		
		return tipDao.tipleriGetir();
	}

	@Override
	public Tip tipGetirById(int id) {

		return tipDao.tipGetirById(id);
	}

}
