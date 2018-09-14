package com.gunerakin.pdfView;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.gunerakin.model.Sinav;
import com.gunerakin.model.Soru;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Sinav sinav = (Sinav) model.get("sinav");

		Paragraph header = new Paragraph(
				new Chunk(sinav.getSinav_adi(), FontFactory.getFont(FontFactory.HELVETICA, 30)));
		document.add(header);
		Paragraph body = null;
		int i = 0;
		for (Soru soru : sinav.getSorular().values()) {
			i++;
			if (soru.getTip().getTip_id() == 2) {

				body = new Paragraph(new Chunk("\n" + i + ")" + soru.getSoru_kok() + " (" + soru.getSoru_puan() + ")"
						+ "\n" + "A)" + soru.getSoru_A() + "\n" + "B)" + soru.getSoru_B() + "\n" + "C)"
						+ soru.getSoru_C() + "\n" + "D)" + soru.getSoru_D() + "\n" + "E)" + soru.getSoru_E()));
				document.add(body);
			}else {
				body = new Paragraph(new Chunk("\n" + i + ")" + soru.getSoru_kok() + " (" + soru.getSoru_puan() + ")"
						+ "\n\n\n\n"));
				document.add(body);
				
			}

		}

		
	}
}
