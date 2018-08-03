package com.gunerakin.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jboss.logging.Logger;

@Entity
@Table(name = "COKTAN_SECMELI")
public class CoktanSecmeli implements Serializable {

	private static final Logger logger = Logger.getLogger(CoktanSecmeli.class);

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cs_id;

	private String cs_soru;
	private String cs_A;
	private String cs_B;
	private String cs_C;
	private String cs_D;
	private String cs_dogru;
	private int cs_puan;

	private String zorluk;

	private Kategori kategori;

	public CoktanSecmeli() {

		logger.info("CoktanSecmeli Model Sınıfı");
	}

	public CoktanSecmeli(String cs_soru, String cs_A, String cs_B, String cs_C, String cs_D, String cs_dogru,
			int cs_puan, String zorluk, Kategori kategori) {

		this.cs_soru = cs_soru;
		this.cs_A = cs_A;
		this.cs_B = cs_B;
		this.cs_C = cs_C;
		this.cs_D = cs_D;
		this.cs_dogru = cs_dogru;
		this.cs_puan = cs_puan;
		this.zorluk = zorluk;
		this.kategori = kategori;
	}

	public String getCs_soru() {
		return cs_soru;
	}

	public void setCs_soru(String cs_soru) {
		this.cs_soru = cs_soru;
	}

	public long getCs_id() {
		return cs_id;
	}

	public void setCs_id(long cs_id) {
		this.cs_id = cs_id;
	}

	public String getCs_A() {
		return cs_A;
	}

	public void setCs_A(String cs_A) {
		this.cs_A = cs_A;
	}

	public String getCs_B() {
		return cs_B;
	}

	public String getZorluk() {
		return zorluk;
	}

	public void setZorluk(String zorluk) {
		this.zorluk = zorluk;
	}

	public void setCs_B(String cs_B) {
		this.cs_B = cs_B;
	}

	public String getCs_C() {
		return cs_C;
	}

	public void setCs_C(String cs_C) {
		this.cs_C = cs_C;
	}

	public String getCs_D() {
		return cs_D;
	}

	public void setCs_D(String cs_D) {
		this.cs_D = cs_D;
	}

	public String getCs_dogru() {
		return cs_dogru;
	}

	public void setCs_dogru(String cs_dogru) {
		this.cs_dogru = cs_dogru;
	}

	public int getCs_puan() {
		return cs_puan;
	}

	public void setCs_puan(int cs_puan) {
		this.cs_puan = cs_puan;
	}

	public Kategori getKategori() {
		return kategori;
	}

	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}

}
