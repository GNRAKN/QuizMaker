package com.gunerakin.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.gunerakin.model.Kategori;
import com.gunerakin.model.Sinav;
import com.gunerakin.model.Soru;
import com.gunerakin.repository.service.KategoriService;
import com.gunerakin.repository.service.SoruService;

@Controller
public class SoruBankasiController {

	private static final Logger logger = LoggerFactory.getLogger(SoruBankasiController.class);

	@Inject
	SoruService soru_Service;

	@Inject
	KategoriService kategori_Service;

	@RequestMapping(value = "yeniSoru", method = RequestMethod.GET)
	public ModelAndView yeniSoru(@ModelAttribute Soru soru) {

		List<Kategori> kategoriler = kategori_Service.kategoriListele();

		return new ModelAndView("soruForm", "kategoriler", kategoriler);

	}

	@RequestMapping(value = "kaydetSoru", method = RequestMethod.POST)
	public ModelAndView kaydetSoru(@ModelAttribute Soru soru, @RequestParam("kategori") Long kategori) {

		if (soru.getSoru_id() == 0) {

			soru.getKategori().setKategori_id(kategori);
			soru_Service.ekleSoru(soru);
			logger.info("Yeni kayit veritabanina eklendi.");

		} else {
			soru.getKategori().setKategori_id(kategori);
			soru_Service.guncelleSoru(soru);
			logger.info(soru.getSoru_id() + " id degerine sahip kayit guncellendi.");
		}
		return new ModelAndView("redirect:listeleSoru");
	}

	@RequestMapping(value = "listeleSoru", method = RequestMethod.GET)
	public ModelAndView listeleSoru(ModelAndView model, HttpSession session) {

		List<Soru> sorular ;
		if(session.getAttribute("sinav")==null) {
			
			sorular= soru_Service.listeleSorular();
			HashSet<Kategori> kategoriler = new HashSet<Kategori>();
			for (Soru soru : sorular) {

				kategoriler.add(soru.getKategori());
			}
			
			return new ModelAndView("soruListele", "sorular", sorular).addObject("kategoriler",
					kategoriler);
		}
		
		else {
			Sinav sinav = (Sinav) session.getAttribute("sinav");
			sorular = soru_Service.listeleSoruByKategori(sinav.getKategori().getKategori_id());
			logger.info(sinav.getKategori().getKategori_ad() + " kategorisindeki sorular listelendi.");

			return new ModelAndView("soruListele", "sorular", sorular)
					.addObject("soruSayisi", sinav.getSorular().size());
		}

		
	}

	@RequestMapping(value = "listeleSoru", method = RequestMethod.POST)
	public ModelAndView listeleSoru(@ModelAttribute Soru kriterler, HttpSession session) {

	    List<Soru> sorular = soru_Service.listeleSorular();

		HashSet<Kategori> kategoriler = new HashSet<Kategori>();
		for (Soru soru: sorular) {

			kategoriler.add(soru.getKategori());
		}
		
		long kategori_id = kriterler.getKategori().getKategori_id();
		String zorluk = kriterler.getZorluk();

		if (kategori_id != 0 & !zorluk.equals("")) {

			sorular = soru_Service.listeleSoruByKategoriZorluk(kategori_id, zorluk);

		}

		else if (kategori_id == 0 & !zorluk.equals("")) {

			sorular = soru_Service.listeleSoruByZorluk(zorluk);

		}

		else if (kategori_id != 0 & zorluk.equals("")) {

			sorular = soru_Service.listeleSoruByKategori(kategori_id);

		}
		
		if(session.getAttribute("sinav")!=null) {
			
			Sinav sinav = (Sinav) session.getAttribute("sinav");
			return new ModelAndView("soruListele", "sorular", sorular).addObject("kategoriler", kategoriler)
					.addObject("soruSayisi", sinav.getSorular().size());
		
		}

		else {
					
			return new ModelAndView("soruListele", "sorular", sorular).addObject("kategoriler",
					kategoriler);
		}
	}

	@RequestMapping(value = "duzenleSoru", method = RequestMethod.GET)
	public ModelAndView duzenleSoru(@ModelAttribute Soru soru, @RequestParam long soru_id) {

		soru = soru_Service.getirSoruById(soru_id);
		List<Kategori> kategoriler = kategori_Service.kategoriListele();
		return new ModelAndView("soruForm", "soru", soru).addObject("kategoriler", kategoriler);

	}

	@RequestMapping(value = "silSoru", method = RequestMethod.GET)
	public ModelAndView silSoru(@RequestParam long soru_id) {

		soru_Service.silSoru(soru_id);
		logger.info(soru_id + " id degerine sahip kayit silindi.");
		return new ModelAndView("redirect:listeleSoru");
	}

}
