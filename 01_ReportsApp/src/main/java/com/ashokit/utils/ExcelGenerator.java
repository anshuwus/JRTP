package com.ashokit.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.ashokit.entity.CitizenPlan;

@Component
public class ExcelGenerator {
	
	
	public void generateExcel(HttpServletResponse response,List<CitizenPlan> citizen,File file)throws Exception {
		
		Workbook workbook=new HSSFWorkbook();
		Sheet sheet=workbook.createSheet("plans-data");
		Row headerRow=sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Plan Name");
		headerRow.createCell(3).setCellValue("Plan Status");
		headerRow.createCell(4).setCellValue("Plan Start Date");
		headerRow.createCell(5).setCellValue("Plan End Date");
		headerRow.createCell(6).setCellValue("Benefit Amt");
		int index=0;
		for(CitizenPlan data : citizen) {
			Row dataRow=sheet.createRow(index++);
			dataRow.createCell(0).setCellValue(data.getCitizenId());
			dataRow.createCell(1).setCellValue(data.getCitizenName());
			dataRow.createCell(2).setCellValue(data.getPlanName());
			dataRow.createCell(3).setCellValue(data.getPlanStatus());
			if(data.getPlanStartDate()!=null && !"".equals(data.getPlanStartDate()))
			    dataRow.createCell(4).setCellValue(data.getPlanStartDate()+"");
			else
				dataRow.createCell(4).setCellValue("N/A");
			
			if(data.getPlanEndDate()!=null && !"".equals(data.getPlanEndDate())) 
			    dataRow.createCell(5).setCellValue(data.getPlanEndDate()+"");
		    else
			    dataRow.createCell(5).setCellValue("N/A");

			if(data.getBenefitAmt()!=null)
				dataRow.createCell(6).setCellValue(data.getBenefitAmt());
		    else
				dataRow.createCell(6).setCellValue("N/A");

		}
		ServletOutputStream outputStream= response.getOutputStream();
		workbook.write(outputStream);
		
		
		FileOutputStream fos=new FileOutputStream(file);
		workbook.write(fos);
		fos.close();
		workbook.close();

	}
}
