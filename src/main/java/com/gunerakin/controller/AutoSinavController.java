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

	@RequestMapping(value = "otoSinavOlustur", method = RequestMethod.POST)
	public String otoSinavOlustur(@RequestParam int tamPuan, @RequestParam String zorluk, HttpSession session) {

		Sinav sinav = (Sinav) session.getAttribute("sinav");
		long kategori_id = sinav.getKategori().getKategori_id();
		sinav.getSorular().clear();

		HashMap<Long, Soru> soruHashMap = new HashMap<Long, Soru>();

		List<Soru> kolaySorular;
		List<Soru> ortaSorular;
		List<Soru> zorSorular;

		int index = 0;
		int sayac = 0;
		Random r;
		int toplamPuan = 0;

		if (zorluk.equals("kolay")) {

			kolaySorular = soruService.listeleSoruByKategoriZorluk(kategori_id, "kolay");

			if (!kolaySorular.isEmpty()) { // list için isEmpty sayı için == String için .equals kullanılır unutma !

				r = new Random();

				for (Soru soru : kolaySorular) {
					toplamPuan = toplamPuan + soru.getSoru_puan();
				}

				while (sayac < tamPuan * 0.5) {

					index = r.nextInt(kolaySorular.size());

					if (!soruHashMap.containsKey(kolaySorular.get(index).getSoru_id())) {
						sayac = sayac + kolaySorular.get(index).getSoru_puan();

						soruHashMap.put(kolaySorular.get(index).getSoru_id(), kolaySorular.get(index));

					}

					if (sayac == toplamPuan) {
						break;
					}

				}
			}

			ortaSorular = soruService.listeleSoruByKategoriZorluk(kategori_id, "orta");

			if (!ortaSorular.isEmpty()) {

				r = new Random();
				sayac = 0;
				toplamPuan = 0;
				for (Soru soru : ortaSorular) {

					toplamPuan = toplamPuan + soru.getSoru_puan();
				}

				while (sayac < tamPuan * 0.3) {

					index = r.nextInt(ortaSorular.size());

					if (!soruHashMap.containsKey(ortaSorular.get(index).getSoru_id())) {

						sayac = sayac + ortaSorular.get(index).getSoru_puan();
						soruHashMap.put(ortaSorular.get(index).getSoru_id(), ortaSorular.get(index));

					}
					if (sayac == toplamPuan) {

						break;
					}

				}
			}

			zorSorular = soruService.listeleSoruByKategoriZorluk(kategori_id, "zor");

			if (!zorSorular.isEmpty()) {

				r = new Random();
				sayac = 0;
				toplamPuan = 0;

				for (Soru soru : zorSorular) {

					toplamPuan = toplamPuan + soru.getSoru_puan();
				}
				while (sayac < tamPuan * 0.2) {
					index = r.nextInt(zorSorular.size());

					if (!soruHashMap.containsKey(zorSorular.get(index).getSoru_id())) {
						sayac = sayac + zorSorular.get(index).getSoru_puan();
						soruHashMap.put(zorSorular.get(index).getSoru_id(), zorSorular.get(index));

					}
					if (sayac == toplamPuan) {

						break;
					}

				}

			}
		}

		// ------------------------------------------------------------------------------------------------------------------

		if (zorluk.equals("orta")) {

			ortaSorular = soruService.listeleSoruByKategoriZorluk(kategori_id, "orta");

			if (!ortaSorular.isEmpty()) {

				r = new Random();
				sayac = 0;
				toplamPuan = 0;
				for (Soru soru : ortaSorular) {

					toplamPuan = toplamPuan + soru.getSoru_puan();
				}

				while (sayac < tamPuan * 0.5) {

					index = r.nextInt(ortaSorular.size());

					if (!soruHashMap.containsKey(ortaSorular.get(index).getSoru_id())) {

						sayac = sayac + ortaSorular.get(index).getSoru_puan();
						soruHashMap.put(ortaSorular.get(index).getSoru_id(), ortaSorular.get(index));

					}
					if (sayac == toplamPuan) {

						break;
					}

				}
			}

			zorSorular = soruService.listeleSoruByKategoriZorluk(kategori_id, "zor");
		
			if (!zorSorular.isEmpty()) {
				
				r = new Random();
				sayac = 0;
				toplamPuan = 0;

				for (Soru soru : zorSorular) {

					toplamPuan = toplamPuan + soru.getSoru_puan();
				}
				while (sayac < tamPuan * 0.3) {
					index = r.nextInt(zorSorular.size());

					if (!soruHashMap.containsKey(zorSorular.get(index).getSoru_id())) {
						sayac = sayac + zorSorular.get(index).getSoru_puan();
						soruHashMap.put(zorSorular.get(index).getSoru_id(), zorSorular.get(index));

					}
					if (sayac == toplamPuan) {

						break;
					}

				}

			}

			kolaySorular = soruService.listeleSoruByKategoriZorluk(kategori_id, "kolay");
			
			if (!kolaySorular.isEmpty()) { // list için isEmpty sayı için == String için .equals kullanılır unutma !

				
				r = new Random();
				sayac = 0;
				toplamPuan=0;
				
				for (Soru soru : kolaySorular) {
					toplamPuan = toplamPuan + soru.getSoru_puan();
				}

				while (sayac < tamPuan * 0.2) {

					index = r.nextInt(kolaySorular.size());

					if (!soruHashMap.containsKey(kolaySorular.get(index).getSoru_id())) {
						sayac = sayac + kolaySorular.get(index).getSoru_puan();

						soruHashMap.put(kolaySorular.get(index).getSoru_id(), kolaySorular.get(index));

					}

					if (sayac == toplamPuan) {
						break;
					}

				}
			}

		}

		// ------------------------------------------------------------------------------------------------------------------

		if (zorluk.equals("zor")) {

			zorSorular = soruService.listeleSoruByKategoriZorluk(kategori_id, "zor");

			if (!zorSorular.isEmpty()) {

				r = new Random();
				sayac = 0;
				toplamPuan = 0;

				for (Soru soru : zorSorular) {

					toplamPuan = toplamPuan + soru.getSoru_puan();
				}
				while (sayac < tamPuan * 0.5) {
					index = r.nextInt(zorSorular.size());

					if (!soruHashMap.containsKey(zorSorular.get(index).getSoru_id())) {
						sayac = sayac + zorSorular.get(index).getSoru_puan();
						soruHashMap.put(zorSorular.get(index).getSoru_id(), zorSorular.get(index));

					}
					if (sayac == toplamPuan) {

						break;
					}

				}

			}

			ortaSorular = soruService.listeleSoruByKategoriZorluk(kategori_id, "orta");

			if (!ortaSorular.isEmpty()) {

				r = new Random();
				sayac = 0;
				toplamPuan = 0;
				
				for (Soru soru : ortaSorular) {

					toplamPuan = toplamPuan + soru.getSoru_puan();
				}

				while (sayac < tamPuan * 0.3) {

					index = r.nextInt(ortaSorular.size());

					if (!soruHashMap.containsKey(ortaSorular.get(index).getSoru_id())) {

						sayac = sayac + ortaSorular.get(index).getSoru_puan();
						soruHashMap.put(ortaSorular.get(index).getSoru_id(), ortaSorular.get(index));

					}
					if (sayac == toplamPuan) {

						break;
					}

				}
			}

			kolaySorular = soruService.listeleSoruByKategoriZorluk(kategori_id, "kolay");

			if (!kolaySorular.isEmpty()) { // list için isEmpty sayı için == String için .equals kullanılır unutma !

				r = new Random();
				sayac = 0;
				toplamPuan = 0;

				for (Soru soru : kolaySorular) {
					toplamPuan = toplamPuan + soru.getSoru_puan();
				}

				while (sayac < tamPuan * 0.2) {

					index = r.nextInt(kolaySorular.size());

					if (!soruHashMap.containsKey(kolaySorular.get(index).getSoru_id())) {
						sayac = sayac + kolaySorular.get(index).getSoru_puan();

						soruHashMap.put(kolaySorular.get(index).getSoru_id(), kolaySorular.get(index));

					}

					if (sayac == toplamPuan) {
						break;
					}

				}
			}

		}
		sinav.getSorular().putAll(soruHashMap);
		session.setAttribute("sinav", sinav);

		return "redirect:sinavOnIzle";
	}
}
