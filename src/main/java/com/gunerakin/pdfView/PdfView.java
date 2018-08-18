package com.gunerakin.pdfView;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.view.document.AbstractPdfView;


import com.gunerakin.model.Sinav;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class PdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Sinav sinav=(Sinav) model.get("sinav");
		
		Table table=new Table(3);
		table.addCell("Sınav Adı");
		table.addCell("Gözetmen");
		table.addCell("Sınav Yeri");
		
		
		
		table.addCell(sinav.getSinav_adi());
		table.addCell(sinav.getSinav_gozetmenAdi());
		table.addCell(sinav.getSinav_yeri());
		
		document.add(table);
		
	}

}
