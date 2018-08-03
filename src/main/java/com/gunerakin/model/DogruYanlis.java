package com.gunerakin.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jboss.logging.Logger;

@Entity
@Table(name = "DOGRU_YANLIS")
public class DogruYanlis implements Serializable {

	private static final Logger logger = Logger.getLogger(DogruYanlis.class);

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long dy_id;

	private String dy_soru;
	private String dy_dogru;
	private String dy_puan;

	public DogruYanlis() {

		logger.info("DogruYanlis Model Sınıfı");
	}

	public DogruYanlis(String dy_soru, String dy_dogru, String dy_puan) {

		this.dy_soru = dy_soru;
		this.dy_dogru = dy_dogru;
		this.dy_puan = dy_puan;
	}

	public long getDy_id() {
		return dy_id;
	}

	public void setDy_id(long dy_id) {
		this.dy_id = dy_id;
	}

	public String getDy_soru() {
		return dy_soru;
	}

	public void setDy_soru(String dy_soru) {
		this.dy_soru = dy_soru;
	}

	public String getDy_dogru() {
		return dy_dogru;
	}

	public void setDy_dogru(String dy_dogru) {
		this.dy_dogru = dy_dogru;
	}

	public String getDy_puan() {
		return dy_puan;
	}

	public void setDy_puan(String dy_puan) {
		this.dy_puan = dy_puan;
	}

}
