package com.gunerakin.repository.service;

import java.util.HashMap;
import java.util.List;

import com.gunerakin.model.Tip;

public interface TipService {

	public List<Tip> tipleriGetir();
	public Tip tipGetirById(int id);
	
}
