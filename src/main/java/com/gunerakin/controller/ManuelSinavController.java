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
import com.gunerakin.model.Sinav;
import com.gunerakin.repository.service.KategoriService;
import com.gunerakin.repository.service.SinavService;
import com.gunerakin.repository.service.SoruService;


@Controller
public class ManuelSinavController {

	@Inject
	SoruService soruService;

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

		for (Kategori kategori : soruService.listeleKategoriBySoru()) {

			kategoriler.add(kategori);
		}
		return new ModelAndView("sinavForm", "kategoriler", kategoriler);
	}

	@RequestMapping(value = "sinavOlustur", method = RequestMethod.POST)
	public String sinavOlustur(@ModelAttribute Sinav sinav, @RequestParam long kategori, HttpSession session) {

		sinav.setKategori(kategoriService.kategoriGetirById(kategori));
		session.setAttribute("sinav", sinav);

		return "redirect:listeleSoru";
	}

	@RequestMapping(value = "soruEkle", method = RequestMethod.GET)
	public String soruEkle(@RequestParam long soru_id, HttpSession session) {

		Sinav sinav = (Sinav) session.getAttribute("sinav");
		
		if(sinav.getSorular().containsKey(soru_id)) {
			
			System.out.println("Bu soruyu zaten eklediniz !");
		}
		else {
			
			sinav.getSorular().put(soru_id,soruService.getirSoruById(soru_id));
		}
		session.setAttribute("sinav", sinav);
		return "redirect:listeleSoru";
	}

	@RequestMapping(value = "sinavKaydet", method = RequestMethod.POST)
	public String sinavKaydet(@ModelAttribute("sinavAttribute") Sinav sinavAttribute, HttpSession session) {
		
		Sinav sinav = (Sinav) session.getAttribute("sinav");
		sinav.setSinav_adi(sinavAttribute.getSinav_adi());
		sinav.setSinav_gozetmenAdi(sinavAttribute.getSinav_gozetmenAdi());
		sinav.setSinav_yeri(sinavAttribute.getSinav_yeri());
		
		if(sinav.getSinav_id()==0) {
				
		sinavService.sinavKaydet(sinav);
		}
		else {
			
			sinavService.sinavGuncelle(sinav);
			
		}
		session.removeAttribute("sinav");

		return "redirect:sinavListele";
	}

	@RequestMapping(value = "sinavOnIzle", method = RequestMethod.GET)
	public String sinavOnizle(HttpSession session, @ModelAttribute("sinavAttribute") Sinav sinav) {

		return "sinavOnizle";
	}

	@RequestMapping(value = "soruKaldir", method = RequestMethod.GET)
	public String soruKaldir(HttpSession session, @RequestParam("soru_id") long soru_id) { // Parametrenin buradaki adi ile

		Sinav sinav = (Sinav) session.getAttribute("sinav");
		sinav.getSorular().remove(soru_id);
		session.setAttribute("sinav", sinav);

		return "redirect:sinavOnIzle";
	}

	@RequestMapping(value = "sinavGuncelle", method = RequestMethod.GET)
	public String sinavGuncelle(@ModelAttribute Sinav sinav, @RequestParam long sinav_id,HttpSession session) {

		sinav = sinavService.sinavListeleById(sinav_id);
		if(session.getAttribute("sinav")!=null) {
			
			session.removeAttribute("sinav");
			
		}
		
		session.setAttribute("sinav",sinav);
		
		return "redirect:sinavOnIzle";

	}

	@RequestMapping(value = "sinavListele", method = RequestMethod.GET)
	public ModelAndView sinavListele() {

		List<Sinav> sinavlar = sinavService.sinavListele();
		return new ModelAndView("sinavListele", "sinavlar", sinavlar);

	}

	@RequestMapping(value = "sinavGetir", method = RequestMethod.GET)
	public ModelAndView sinavGetir(@RequestParam("sinav_id") long sinav_id) {

		Sinav sinav = sinavService.sinavListeleById(sinav_id);

		return new ModelAndView("sinavGetir", "sinav", sinav);

	}

	@RequestMapping(value = "sinavSil", method = RequestMethod.GET)
	public String sinavSil(@RequestParam("sinav_id") long sinav_id) {

		sinavService.sinavSil(sinav_id);
		return "redirect:sinavListele";
	}

}
