package com.gunerakin.repository.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gunerakin.model.CoktanSecmeli;
import com.gunerakin.repository.dao.CoktanSecmeliDao;
import com.gunerakin.repository.service.CoktanSecmeliService;

@Service
@Transactional
public class CoktanSecmeliServiceImpl implements CoktanSecmeliService {

	@Inject
	CoktanSecmeliDao cs_DAO;

	@Override
	public List<CoktanSecmeli> listele_CS(long kategoriId, String zorluk) {

		return cs_DAO.listele_CS(kategoriId, zorluk);
	}

}
