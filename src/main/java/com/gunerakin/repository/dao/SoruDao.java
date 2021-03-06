package com.gunerakin.repository.dao;

import java.util.List;
import com.gunerakin.model.Kategori;
import com.gunerakin.model.Soru;

public interface SoruDao {

	public void ekleSoru(Soru soru);

	public List<Soru> listeleSorular();

	public Soru getirSoruById(long soru_id);

	public void guncelleSoru(Soru soru);

	public void silSoru(long soru_id);

	public List<Soru> listeleSoruByKategoriZorluk(long kategori_id, String zorluk);

	public List<Soru> listeleSoruByZorluk(String zorluk);

	public List<Soru> listeleSoruByKategori(long kategori_id);

	public List<Kategori> listeleKategoriBySoru();

	public long count();
	
	public List<Soru> readQuestion10(int number);

}
