package com.gunerakin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jboss.logging.Logger;

@Entity
@Table(name="Tipler")
public class Tip {

	private static final Logger logger = Logger.getLogger(Soru.class);
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tip_id;
	
	private String tip_adi;

	public Tip() {
		
		logger.info("Tip Model Sınıfı");
	}

	public Tip(String tip_adi) {
		
		this.tip_adi = tip_adi;
	}

	public int getTip_id() {
		return tip_id;
	}

	public String getTip_adi() {
		return tip_adi;
	}

	public void setTip_id(int tip_id) {
		this.tip_id = tip_id;
	}

	public void setTip_adi(String tip_adi) {
		this.tip_adi = tip_adi;
	}
	
	
	
	
	
	
	
	
}
