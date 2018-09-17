package com.gunerakin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.gunerakin.model.Sinav;
import com.gunerakin.model.Soru;
import com.gunerakin.repository.service.SoruService;

@Controller
public class AutoSinavController {

	@Inject
	SoruService soruService;
	
	public HashMap<String, Double> katsayiDondur(String zorluk1, String zorluk2, String zorluk3) {

		HashMap<String, Double> zorluklar = new HashMap<String, Double>();
		zorluklar.put(zorluk1, 0.5);
		zorluklar.put(zorluk2, 0.3);
		zorluklar.put(zorluk3, 0.2);

		return zorluklar;

	}

	public HashMap<Long, Soru> otoSinav(String zorluk, long kategori_id, int tamPuan) {

		Random r;
		int index;
		int sayac;
		int toplamPuan;
		List<Soru> sorular;

		HashMap<Long, Soru> soruHashMap = new HashMap<Long, Soru>();
		HashMap<String, Double> zorluklar = new HashMap<String, Double>();
		
		if (zorluk.equals("kolay")) {
			zorluklar=katsayiDondur("kolay", "orta", "zor");
			
		} else if (zorluk.equals("orta")) {

			zorluklar=katsayiDondur("orta", "kolay", "zor");

		} else if (zorluk.equals("zor")) {
			zorluklar=katsayiDondur("zor", "orta", "kolay");

		}

		for (String k_zorluk : zorluklar.keySet()) {

			index = 0;
			sayac = 0;
			toplamPuan = 0;

			sorular = soruService.listeleSoruByKategoriZorluk(kategori_id, k_zorluk);
			if (!sorular.isEmpty()) {

				r = new Random();

				for (Soru soru : sorular) {
					toplamPuan = toplamPuan + soru.getSoru_puan();
				}

				while (sayac < tamPuan * zorluklar.get(k_zorluk)) {

					index = r.nextInt(sorular.size());

					if (!soruHashMap.containsKey(sorular.get(index).getSoru_id())) {

						sayac = sayac + sorular.get(index).getSoru_puan();
						soruHashMap.put(sorular.get(index).getSoru_id(), sorular.get(index));

					}

					if (sayac == toplamPuan) {
						break;
					}

				}
			}
		}

		return soruHashMap;
	}
	

	@RequestMapping(value = "otoSinavOlustur", method = RequestMethod.POST)
	public String otoSinavOlustur(@RequestParam int tamPuan, @RequestParam String zorluk, HttpSession session) {

		Sinav sinav = (Sinav) session.getAttribute("sinav");
		long kategori_id = sinav.getKategori().getKategori_id();
		sinav.getSorular().clear();
		sinav.getSorular().putAll(otoSinav(zorluk, kategori_id, tamPuan));

		return "redirect:sinavOnIzle";

	}
	}

