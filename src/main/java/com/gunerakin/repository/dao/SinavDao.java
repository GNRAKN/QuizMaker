package com.gunerakin.repository.dao;

import java.util.List;

import com.gunerakin.model.Sinav;

public interface SinavDao {

	public void sinavKaydet(Sinav sinav);

	public void sinavGuncelle(Sinav sinav);

	public Sinav sinavListeleById(long sinav_id);
	
	public List<Sinav> sinavListele();
	
	public void sinavSil(long sinav_id);
}
