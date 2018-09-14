package com.gunerakin.repository.dao;

import java.util.List;

import com.gunerakin.model.Kategori;

public interface KategoriDao {

	public List<Kategori> kategoriListele();
	public Kategori kategoriGetirById(long kategori_id);

}
