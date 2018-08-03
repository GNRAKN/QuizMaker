package com.gunerakin.repository.service;

import java.util.List;

import com.gunerakin.model.CoktanSecmeli;

public interface CoktanSecmeliService {

	public List<CoktanSecmeli> listele_CS(long kategoriId, String zorluk);

}
