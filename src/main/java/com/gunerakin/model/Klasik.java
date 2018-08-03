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
@Table(name = "KLASIK")
public class Klasik implements Serializable {

	private static final Logger logger = Logger.getLogger(Klasik.class);

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long k_id;

	private String k_soru;
	private String k_dogru;
	private String k_zorluk;
	private String k_puan;

	@ManyToOne
	@JoinColumn(name = "kategori_id")
	private Kategori kategori;

	public Klasik() {

		logger.info("Klasik Model Sınıfı");
	}

	public Klasik(Kategori kategori, String k_soru, String k_dogru, String k_zorluk, String k_puan) {
		super();
		this.kategori = kategori;
		this.k_soru = k_soru;
		this.k_dogru = k_dogru;
		this.k_zorluk = k_zorluk;
		this.k_puan = k_puan;
	}

	public long getK_id() {
		return k_id;
	}

	public String getK_soru() {
		return k_soru;
	}

	public String getK_dogru() {
		return k_dogru;
	}

	public String getK_zorluk() {
		return k_zorluk;
	}

	public String getK_puan() {
		return k_puan;
	}

	public Kategori getKategori() {
		return kategori;
	}

	public void setK_id(long k_id) {
		this.k_id = k_id;
	}

	public void setK_soru(String k_soru) {
		this.k_soru = k_soru;
	}

	public void setK_dogru(String k_dogru) {
		this.k_dogru = k_dogru;
	}

	public void setK_zorluk(String k_zorluk) {
		this.k_zorluk = k_zorluk;
	}

	public void setK_puan(String k_puan) {
		this.k_puan = k_puan;
	}

	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}

	@Override
	public String toString() {
		return "Klasik [k_id=" + k_id + ", k_soru=" + k_soru + ", k_dogru=" + k_dogru + ", k_zorluk=" + k_zorluk
				+ ", k_puan=" + k_puan + ", kategori=" + kategori + "]";
	}

}
