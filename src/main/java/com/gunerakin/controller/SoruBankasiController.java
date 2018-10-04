package com.gunerakin.controller;

import java.util.HashSet;
import java.util.Iterator;
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
import com.gunerakin.model.Tip;
import com.gunerakin.repository.service.KategoriService;
import com.gunerakin.repository.service.SoruService;
import com.gunerakin.repository.service.TipService;

@Controller
public class SoruBankasiController {

	private static final Logger logger = LoggerFactory.getLogger(SoruBankasiController.class);

	@Inject
	SoruService soru_Service;

	@Inject
	KategoriService kategori_Service;

	@Inject
	TipService tip_Service;

	public List<Kategori> soruKategori() {

		List<Kategori> kategoriler = soru_Service.listeleKategoriBySoru();
		return kategoriler; // DAO tarafında Group By kullanılarak gruplama işlemi için for dan kurtulduk.
	}

	public HashSet<String> zorluklar() {

		HashSet<String> zorluklar = new HashSet<String>();
		zorluklar.add("Kolay");
		zorluklar.add("Orta");
		zorluklar.add("Zor");

		return zorluklar;
	}

	public HashSet<String> siklar() {

		HashSet<String> siklar = new HashSet<String>();
		siklar.add("A");
		siklar.add("B");
		siklar.add("C");
		siklar.add("D");
		siklar.add("E");

		return siklar;
	}

	@RequestMapping(value = "yeniSoru", method = RequestMethod.GET)
	public ModelAndView yeniSoru(@ModelAttribute Soru soru) {

		List<Kategori> kategoriler = kategori_Service.kategoriListele();
		List<Tip> tipler = tip_Service.tipleriGetir();

		return new ModelAndView("soruForm", "kategoriler", kategoriler).addObject("tipler", tipler)
				.addObject("zorluklar", zorluklar()).addObject("siklar", siklar());

	}

	@RequestMapping(value = "kaydetSoru", method = RequestMethod.POST)
	public ModelAndView kaydetSoru(@ModelAttribute Soru soru, @RequestParam("kategori") Long kategori,
			@RequestParam("tip") int tip) {

		soru.getKategori().setKategori_id(kategori);
		soru.getTip().setTip_id(tip);

		if (soru.getSoru_id() == 0) {

			soru_Service.ekleSoru(soru);
			logger.info("Yeni kayit veritabanina eklendi.");

		} else {
			soru_Service.guncelleSoru(soru);
			logger.info(soru.getSoru_id() + " id degerine sahip kayit guncellendi.");
		}
		return new ModelAndView("redirect:listeleSoru");
	}

	@RequestMapping(value = "duzenleSoru", method = RequestMethod.GET)
	public ModelAndView duzenleSoru(@ModelAttribute Soru soru, @RequestParam long soru_id) {

		soru = soru_Service.getirSoruById(soru_id);

		List<Kategori> kategoriler = kategori_Service.kategoriListele();
		List<Tip> tipler = tip_Service.tipleriGetir();

		Iterator<Tip> iterator1 = tipler.iterator();
		while (iterator1.hasNext()) {

			if (iterator1.next().getTip_id() == (soru.getTip().getTip_id())) {

				iterator1.remove();
				break;
			}
		}

		Iterator<Kategori> iterator2 = kategoriler.iterator();
		while (iterator2.hasNext()) {

			if (iterator2.next().getKategori_id() == soru.getKategori().getKategori_id()) {

				iterator2.remove();
				break;
			}

		}

		HashSet<String> zorluklar = zorluklar();
		

		zorluklar.remove(soru.getZorluk());

		if (soru.getTip().getTip_id() == 2) {
			
			HashSet<String> siklar = siklar();
			siklar.remove(soru.getSoru_dogru());

			return new ModelAndView("soruForm", "soru", soru).addObject("kategoriler", kategoriler)
					.addObject("tipler", tipler).addObject("zorluklar", zorluklar).addObject("siklar", siklar);
		}

		else {

			return new ModelAndView("soruForm", "soru", soru).addObject("kategoriler", kategoriler)
					.addObject("tipler", tipler).addObject("zorluklar", zorluklar);
		}

	}

	@RequestMapping(value = "silSoru", method = RequestMethod.GET)
	public ModelAndView silSoru(@RequestParam long soru_id) {

		soru_Service.silSoru(soru_id);
		logger.info(soru_id + " id degerine sahip kayit silindi.");
		return new ModelAndView("redirect:listeleSoru");
	}

	@RequestMapping(value = "listeleSoru", method = RequestMethod.GET)
	public ModelAndView listeleSoru(ModelAndView model, HttpSession session) {

		List<Soru> sorular;

		if (session.getAttribute("sinav") == null) {
			sorular = soru_Service.listeleSorular();
			return new ModelAndView("soruListele", "sorular", sorular).addObject("kategoriler", soruKategori());
		}

		else {
			Sinav sinav = (Sinav) session.getAttribute("sinav");
			sorular = soru_Service.listeleSoruByKategori(sinav.getKategori().getKategori_id());
			logger.info(sinav.getKategori().getKategori_ad() + " kategorisindeki sorular listelendi.");

			java.util.Iterator<Soru> itr;

			for (itr = sorular.iterator(); itr.hasNext();) {

				if (sinav.getSorular().containsKey(itr.next().getSoru_id())) {

					itr.remove();
					// iki for la map içerisinde arama yapmak yerine contains metodu kullanıldı.
					// list içerisindeki nesneleri direk olarak silmeye çalışırken hata verdiği için
					// iteratorle sildim.

				}
			}

			return new ModelAndView("soruListele", "sorular", sorular).addObject("soruSayisi",
					sinav.getSorular().size());
		}

	}

	@RequestMapping(value = "listeleSoru", method = RequestMethod.POST)
	public ModelAndView listeleSoru(@ModelAttribute Soru kriterler, HttpSession session) {

		List<Soru> sorular;

		long kategori_id = kriterler.getKategori().getKategori_id();
		String zorluk = kriterler.getZorluk();

		if (kategori_id != 0 & !zorluk.isEmpty()) {
			sorular = soru_Service.listeleSoruByKategoriZorluk(kategori_id, zorluk);

		} else if (kategori_id == 0 & !zorluk.isEmpty()) {

			sorular = soru_Service.listeleSoruByZorluk(zorluk);

		} else if (kategori_id != 0 & zorluk.isEmpty()) {

			sorular = soru_Service.listeleSoruByKategori(kategori_id);

		} else {

			sorular = soru_Service.listeleSorular();
		}

		return new ModelAndView("soruListele", "sorular", sorular).addObject("kategoriler", soruKategori());

	}

}