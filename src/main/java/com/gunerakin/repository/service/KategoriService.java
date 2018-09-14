package com.gunerakin.repository.service;

import java.util.List;

import com.gunerakin.model.Kategori;

public interface KategoriService {

	public List<Kategori> kategoriListele();
	public Kategori kategoriGetirById(long kategori_id);
}
