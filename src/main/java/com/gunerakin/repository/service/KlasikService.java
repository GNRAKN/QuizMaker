package com.gunerakin.repository.service;

import java.util.HashSet;
import java.util.List;

import com.gunerakin.model.Kategori;
import com.gunerakin.model.Klasik;

public interface KlasikService {

	public void ekleKlasikSoru(Klasik klasik);

	public List<Klasik> listeleKlasikSorular();

	public Klasik listeleKlasikById(long k_id);

	public void guncelleKlasikSoru(Klasik klasik);

	public void silKlasikSoru(long k_id);

	public List<Klasik> listeleKlasikByKategoriZorluk(long kategori_id, String zorluk);

	public List<Klasik> listeleKlasikByZorluk(String zorluk);

	public List<Klasik> listeleKlasikByKategori(long kategori_id);

	public List<Kategori> listeleKategoriBySoru();

	public long count();

}
