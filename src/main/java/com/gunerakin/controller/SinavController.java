package com.gunerakin.controller;

import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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
import com.gunerakin.repository.service.SinavService;

@Controller
public class SinavController {

	@Inject
	KlasikService klasikService;

	@Inject
	SinavService sinavService;
	
	@Inject
	KategoriService kategoriService;

	@RequestMapping(value = "sinavOlustur", method = RequestMethod.GET)
	public ModelAndView sinavOlustur(@ModelAttribute Sinav sinav, HttpSession session) {

		if (session.getAttribute("sinav") != null) {

			session.removeAttribute("sinav");
		}

		HashSet<Kategori> kategoriler = new HashSet<Kategori>();
		
		for (Kategori kategori : klasikService.listeleKategoriBySoru()) {

			kategoriler.add(kategori);
		}
		return new ModelAndView("sinavForm", "kategoriler", kategoriler);
	}

	@RequestMapping(value = "sinavOlustur", method = RequestMethod.POST)
	public String sinavKaydet(@ModelAttribute Sinav sinav,@RequestParam long kategori,
			HttpSession session) {
		
		
	
		sinav.setKategori(kategoriService.kategoriGetirById(kategori));	
		session.setAttribute("sinav", sinav);

		return "redirect:listeleKlasik";
	}

	@RequestMapping(value = "soruEkle", method = RequestMethod.GET)
	public String soruEkle(@RequestParam long k_id, HttpSession session) {

		Sinav sinav = (Sinav) session.getAttribute("sinav");
		sinav.getKlasikSorular().put(k_id, klasikService.listeleKlasikById(k_id));
		session.setAttribute("sinav", sinav);
		return "redirect:listeleKlasik";
	}

	@RequestMapping(value = "sinavKaydet", method = RequestMethod.POST)
	public String sinavKaydet(@ModelAttribute("sinavAttribute") Sinav sinavAttribute, HttpSession session) {

		Sinav sinav = (Sinav) session.getAttribute("sinav");
		sinav.setSinav_adi(sinavAttribute.getSinav_adi());
		sinav.setSinav_gozetmenAdi(sinavAttribute.getSinav_gozetmenAdi());
		sinav.setSinav_yeri(sinavAttribute.getSinav_yeri());
		sinavService.sinavKaydet(sinav);
		session.removeAttribute("sinav");

		return "sinavGetir";
	}

	@RequestMapping(value = "sinavOnIzle", method = RequestMethod.GET)
	public String sinavOnizle(HttpSession session, @ModelAttribute("sinavAttribute") Sinav sinav) {

		return "sinavOnizle";
	}

	@RequestMapping(value = "soruKaldir", method = RequestMethod.GET)
	public String soruKaldir(HttpSession session, @RequestParam("k_id") long k_id) { // Parametrenin buradaki adi ile

		Sinav sinav = (Sinav) session.getAttribute("sinav");
		sinav.getKlasikSorular().remove(k_id);
		session.setAttribute("sinav", sinav);

		return "redirect:sinavOnIzle";
	}

	@RequestMapping(value = "sinavGuncelle", method = RequestMethod.GET)
	public ModelAndView editKlasik(@ModelAttribute Sinav sinav, @RequestParam long sinav_id) {

		sinav = sinavService.sinavListeleById(sinav_id);
		List<Kategori> kategoriler = klasikService.listeleKategoriBySoru();
		return new ModelAndView("sinavForm", "sinav", sinav).addObject("kategoriler", kategoriler);

	}
	
	
	@RequestMapping(value="sinavListele",method=RequestMethod.GET)
	public ModelAndView sinavListele() {
		
		List<Sinav> sinavlar=sinavService.sinavListele();		
		return new ModelAndView("sinavListele","sinavlar",sinavlar);
		
	}
	
	
	@RequestMapping(value="sinavGetir",method=RequestMethod.GET)
	public ModelAndView sinavGetir(@RequestParam("sinav_id") long sinav_id) {
		
		Sinav sinav=sinavService.sinavListeleById(sinav_id);
		
		for (Klasik klasik : sinav.getKlasikSorular().values()) {
			System.out.println(klasik.getK_soru());
		}
	
		return new ModelAndView("sinavGetir","sinav",sinav);
		
	}

}
