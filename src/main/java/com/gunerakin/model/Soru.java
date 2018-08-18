package com.gunerakin.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.jboss.logging.Logger;

@Entity
@Table(name = "Soru")
public class Soru implements Serializable {

	private static final Logger logger = Logger.getLogger(Soru.class);

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long soru_id;

	private String soru_kok;
	private String soru_A;
	private String soru_B;
	private String soru_C;
	private String soru_D;
	private String soru_E;
	private String soru_dogru;
	private int soru_puan;

	private String zorluk;
	
	@ManyToOne
	@JoinColumn(name = "kategori_id")
	private Kategori kategori;

	public Soru() {

		logger.info("Soru Model Sınıfı");
	}

	public Soru(String soru_kok, String soru_A, String soru_B, String soru_C, String soru_D, String soru_E,
			String soru_dogru, int soru_puan, String zorluk, Kategori kategori) {
		
		this.soru_kok = soru_kok;
		this.soru_A = soru_A;
		this.soru_B = soru_B;
		this.soru_C = soru_C;
		this.soru_D = soru_D;
		this.soru_E = soru_E;
		this.soru_dogru = soru_dogru;
		this.soru_puan = soru_puan;
		this.zorluk = zorluk;
		this.kategori = kategori;
	}

	public long getSoru_id() {
		return soru_id;
	}

	public String getSoru_kok() {
		return soru_kok;
	}

	public String getSoru_A() {
		return soru_A;
	}

	public String getSoru_B() {
		return soru_B;
	}

	public String getSoru_C() {
		return soru_C;
	}

	public String getSoru_D() {
		return soru_D;
	}

	public String getSoru_E() {
		return soru_E;
	}

	public String getSoru_dogru() {
		return soru_dogru;
	}

	public int getSoru_puan() {
		return soru_puan;
	}

	public String getZorluk() {
		return zorluk;
	}

	public Kategori getKategori() {
		return kategori;
	}

	public void setSoru_id(long soru_id) {
		this.soru_id = soru_id;
	}

	public void setSoru_kok(String soru_kok) {
		this.soru_kok = soru_kok;
	}

	public void setSoru_A(String soru_A) {
		this.soru_A = soru_A;
	}

	public void setSoru_B(String soru_B) {
		this.soru_B = soru_B;
	}

	public void setSoru_C(String soru_C) {
		this.soru_C = soru_C;
	}

	public void setSoru_D(String soru_D) {
		this.soru_D = soru_D;
	}

	public void setSoru_E(String soru_E) {
		this.soru_E = soru_E;
	}

	public void setSoru_dogru(String soru_dogru) {
		this.soru_dogru = soru_dogru;
	}

	public void setSoru_puan(int soru_puan) {
		this.soru_puan = soru_puan;
	}

	public void setZorluk(String zorluk) {
		this.zorluk = zorluk;
	}

	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}

	
	
}