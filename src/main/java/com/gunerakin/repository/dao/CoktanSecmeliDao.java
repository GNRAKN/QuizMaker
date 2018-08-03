package com.gunerakin.repository.dao;

import java.util.List;

import com.gunerakin.model.CoktanSecmeli;

public interface CoktanSecmeliDao {

	public List<CoktanSecmeli> listele_CS(long kategoriId, String zorluk);

}
