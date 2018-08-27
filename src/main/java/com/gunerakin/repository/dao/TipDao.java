package com.gunerakin.repository.dao;

import java.util.List;

import com.gunerakin.model.Tip;

public interface TipDao {

	
	public List<Tip> tipleriGetir();
	public Tip tipGetirById(int id);
}
