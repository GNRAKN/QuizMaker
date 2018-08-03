package com.gunerakin.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KATEGORI")
public class Kategori implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long kategori_id;

	private String kategori_ad;

	public Kategori() {

	}

	public Kategori(String kategori_ad) {

		this.kategori_ad = kategori_ad;
	}

	public long getKategori_id() {
		return kategori_id;
	}

	public String getKategori_ad() {
		return kategori_ad;
	}

	public void setKategori_id(long kategori_id) {
		this.kategori_id = kategori_id;
	}

	public void setKategori_ad(String kategori_ad) {
		this.kategori_ad = kategori_ad;
	}

}
