package com.gunerakin.controller;

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
import com.gunerakin.model.Klasik;
import com.gunerakin.model.Sinav;
import com.gunerakin.repository.service.KategoriService;
import com.gunerakin.repository.service.KlasikService;

@Controller
public class SoruBankasiController {

	private static final Logger logger = LoggerFactory.getLogger(SoruBankasiController.class);

	@Inject
	KlasikService k_Service;

	@Inject
	KategoriService kategori_Service;

	@RequestMapping(value = "yeniKlasik", method = RequestMethod.GET)
	public ModelAndView yeniKlasik(@ModelAttribute Klasik klasik) {

		List<Kategori> kategoriler = kategori_Service.kategoriListele();

		return new ModelAndView("klasikForm", "kategoriler", kategoriler);

	}

	@RequestMapping(value = "kaydetKlasik", method = RequestMethod.POST)
	public ModelAndView kaydetKlasik(@ModelAttribute Klasik klasik, @RequestParam("kategori") Long kategori) {

		System.out.println(klasik.getK_soru());
		if (klasik.getK_id() == 0) {

			klasik.getKategori().setKategori_id(kategori);
			k_Service.ekleKlasikSoru(klasik);
			System.out.println(klasik.getK_soru());
			logger.info("Yeni kayit veritabanina eklendi.");

		} else {
			klasik.getKategori().setKategori_id(kategori);
			k_Service.guncelleKlasikSoru(klasik);
			logger.info(klasik.getK_id() + " id degerine sahip kayit guncellendi.");
		}
		return new ModelAndView("redirect:listeleKlasik");
	}

	@RequestMapping(value = "listeleKlasik", method = RequestMethod.GET)
	public ModelAndView listeleKlasik(ModelAndView model, HttpSession session) {

		List<Klasik> klasikSorular = k_Service.listeleKlasikSorular();
		HashSet<Kategori> kategoriler = new HashSet<Kategori>();
		for (Klasik klasik : klasikSorular) {

			kategoriler.add(klasik.getKategori());
		}
		if (session.getAttribute("sinav") != null) {
			Sinav sinav = (Sinav) session.getAttribute("sinav");
			klasikSorular = k_Service.listeleKlasikByKategori(sinav.getKategori().getKategori_id());
			logger.info(sinav.getKategori().getKategori_ad() + " kategorindeki klasik sorular listelendi.");

			return new ModelAndView("formListele", "klasikSorular", klasikSorular).addObject("kategoriler", kategoriler)
					.addObject("soruSayisi", sinav.getKlasikSorular().size());
		}

		else {
			return new ModelAndView("formListele", "klasikSorular", klasikSorular).addObject("kategoriler",
					kategoriler);
		}
	}
	
	
	
	@RequestMapping(value = "listeleKlasik", method = RequestMethod.POST)
	public ModelAndView listeleKlasik(@ModelAttribute Klasik kriterler, HttpSession session) {

		List<Klasik> klasikSorular = null;
		klasikSorular = k_Service.listeleKlasikSorular();

		HashSet<Kategori> kategoriler = new HashSet<Kategori>();
		for (Klasik klasik : klasikSorular) {

			kategoriler.add(klasik.getKategori());
		}

		long kategori_id = kriterler.getKategori().getKategori_id();
		String zorluk = kriterler.getK_zorluk();

		if (kategori_id != 0 & !zorluk.equals("")) {

			klasikSorular = k_Service.listeleKlasikByKategoriZorluk(kategori_id, zorluk);

		}

		else if (kategori_id == 0 & !zorluk.equals("")) {

			klasikSorular = k_Service.listeleKlasikByZorluk(zorluk);

		}

		else if (kategori_id != 0 & zorluk.equals("")) {

			klasikSorular = k_Service.listeleKlasikByKategori(kategori_id);

		}

		if (session.getAttribute("sinav") != null) {
			Sinav sinav = (Sinav) session.getAttribute("sinav");
			return new ModelAndView("formListele", "klasikSorular", klasikSorular).addObject("kategoriler", kategoriler)
					.addObject("soruSayisi", sinav.getKlasikSorular().size());

		} else {

			return new ModelAndView("formListele", "klasikSorular", klasikSorular).addObject("kategoriler",
					kategoriler);
		}
	}
	
	

	@RequestMapping(value = "editKlasik", method = RequestMethod.GET)
	public ModelAndView editKlasik(@ModelAttribute Klasik klasik, @RequestParam long k_id) {

		klasik = k_Service.listeleKlasikById(k_id);
		List<Kategori> kategoriler = kategori_Service.kategoriListele();
		return new ModelAndView("klasikForm", "klasik", klasik).addObject("kategoriler", kategoriler);

	}

	@RequestMapping(value = "deleteKlasik", method = RequestMethod.GET)
	public ModelAndView deleteKlasik(@RequestParam long k_id) {

		k_Service.silKlasikSoru(k_id);
		logger.info(k_id + " id degerine sahip kayit silindi.");
		return new ModelAndView("redirect:listeleKlasik");
	}

	

}
