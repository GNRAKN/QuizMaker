package com.gunerakin.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.Table;

import org.jboss.logging.Logger;

@Entity
@Table(name = "SINAV")
public class Sinav {

	private static final Logger logger = Logger.getLogger(Klasik.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sinav_id;

	private String sinav_adi;

	@ManyToOne
	@JoinColumn(name = "kategori_id")
	private Kategori kategori;

	private String sinav_yeri;
	private String sinav_gozetmenAdi;

	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "Sinav_Klasik", joinColumns = { @JoinColumn(name = "Sinav_Id") }, inverseJoinColumns = {
			@JoinColumn(name = "Klasik_Id") })
	@MapKey(name = "k_id") // bunu kullanmazsak cokacok iliskiden dogan tabloya HashMap key'ini insert
							// ediyor.
	private Map<Long, Klasik> klasikSorular = new HashMap<Long, Klasik>();

	public Sinav() {

		logger.info("Sınav Model Sınıfı");
	}

	public Sinav(String sinav_adi, Kategori kategori, String sinav_yeri, String sinav_gozetmenAdi,
			Map<Long, Klasik> klasikSorular) {

		this.sinav_adi = sinav_adi;
		this.kategori = kategori;
		this.sinav_yeri = sinav_yeri;
		this.sinav_gozetmenAdi = sinav_gozetmenAdi;
		this.klasikSorular = klasikSorular;
	}

	public long getSinav_id() {
		return sinav_id;
	}

	public String getSinav_adi() {
		return sinav_adi;
	}

	public Kategori getKategori() {
		return kategori;
	}

	public String getSinav_yeri() {
		return sinav_yeri;
	}

	public String getSinav_gozetmenAdi() {
		return sinav_gozetmenAdi;
	}

	public Map<Long, Klasik> getKlasikSorular() {
		return klasikSorular;
	}

	public void setSinav_id(long sinav_id) {
		this.sinav_id = sinav_id;
	}

	public void setSinav_adi(String sinav_adi) {
		this.sinav_adi = sinav_adi;
	}

	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}

	public void setSinav_yeri(String sinav_yeri) {
		this.sinav_yeri = sinav_yeri;
	}

	public void setSinav_gozetmenAdi(String sinav_gozetmenAdi) {
		this.sinav_gozetmenAdi = sinav_gozetmenAdi;
	}

	public void setKlasikSorular(Map<Long, Klasik> klasikSorular) {
		this.klasikSorular = klasikSorular;
	}

}