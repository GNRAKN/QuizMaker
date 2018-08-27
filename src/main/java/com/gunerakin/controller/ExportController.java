package com.gunerakin.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gunerakin.model.Sinav;
import com.gunerakin.repository.service.SinavService;

@Controller
public class ExportController {

	@Inject
	SinavService sinavService;

	@RequestMapping(value = "pdfExport", method = RequestMethod.GET)
	public ModelAndView pdfExport(HttpServletResponse response, @RequestParam long sinav_id) {

		Sinav sinav = sinavService.sinavListeleById(sinav_id);
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=" + sinav.getSinav_adi() +"("+sinav.getSinav_gozetmenAdi()+")"+".pdf");

		return new ModelAndView("pdfView", "sinav", sinav);
	}

}
