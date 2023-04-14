package com.ashokit.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.ashokit.entity.CitizenPlan;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PdfGenerator {
	
	
	public void generatePdf(HttpServletResponse response,List<CitizenPlan> records,File file) throws Exception {
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(file));

		document.open();
		//creating font object
		Font font=FontFactory.getFont(FontFactory.TIMES_BOLD);
		font.setSize(20);
		
		//creating paragraph
		Paragraph p=new Paragraph("Citizen Plans Info",font);
		//Aligning the paragraph in document
		p.setAlignment(Paragraph.ALIGN_CENTER);
		
		//Adding the created paragraph in document
		document.add(p);
		
		PdfPTable table=new PdfPTable(6);
		table.setSpacingBefore(5);
		
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("End Date");
		
		for(CitizenPlan plan : records) {
			table.addCell(String.valueOf(plan.getCitizenId()));	
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(String.valueOf(plan.getPlanStartDate()));	
			table.addCell(String.valueOf(plan.getPlanEndDate()));	

		}
		
		document.add(table);
		document.close();
	}
}
