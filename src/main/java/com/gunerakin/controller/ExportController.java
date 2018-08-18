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
	
	@RequestMapping(value="pdfExport",method=RequestMethod.GET)
	public ModelAndView pdfExport(HttpServletResponse response) {
		
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition","attachment; filename=exportMy.pdf");
		
		Sinav sinav=sinavService.sinavListeleById(1);
		System.out.println(sinav.getSinav_adi());
		return new ModelAndView("pdfView","sinav",sinav);
	}
	
	
}
