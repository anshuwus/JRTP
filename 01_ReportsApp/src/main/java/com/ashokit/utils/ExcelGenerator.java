package com.ashokit.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
			index++;
			Row dataRow=sheet.createRow(index);
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
	
	
	 public ResponseEntity<InputStreamResource> showExcel(HttpServletResponse response,HttpHeaders headers, List<CitizenPlan> citizen) throws Exception {
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
				index++;
				Row dataRow=sheet.createRow(index);
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
			//convert the workbook to HTML content
			 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		     workbook.write(outputStream);
		     ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		     String htmlContent = convertToHTML(inputStream);
		     
		  // Return the response entity with the converted HTML content
		        return ResponseEntity
		                .ok()
		                .headers(headers)
		                .contentType(MediaType.TEXT_HTML)
		                .body(new InputStreamResource(new ByteArrayInputStream(htmlContent.getBytes())));
		 
	}
	 
	 
	  private String convertToHTML(InputStream inputStream) throws IOException {
	        Workbook workbook = WorkbookFactory.create(inputStream);

	        StringBuilder html = new StringBuilder();
	        html.append("<html><body><table>");
	        html.append("Hi");
	        
	        for (Sheet sheet : workbook) {
	        	sheet.getHeader();
	            html.append("<tr><th colspan=\"").append(sheet.getRow(0).getLastCellNum()).append("\">").append(sheet.getSheetName()).append("</th></tr>");
	         //   html.append("<tr><td>"+sheet.getfi);
	            for (Row row : sheet) {
	                html.append("<tr>");
	                
	                for (Cell cell : row) {
	                    html.append("<td>");

	                    CellType cellType = cell.getCellType();
	                    if (cellType == CellType.STRING) {
	                        html.append(cell.getStringCellValue());
	                    } else if (cellType == CellType.NUMERIC) {
	                        if (DateUtil.isCellDateFormatted(cell)) {
	                            html.append(cell.getDateCellValue());
	                        } else {
	                            html.append(cell.getNumericCellValue());
	                        }
	                    } else if (cellType == CellType.BOOLEAN) {
	                        html.append(cell.getBooleanCellValue());
	                    } else if (cellType == CellType.FORMULA) {
	                        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
	                        evaluator.evaluateFormulaCell(cell);
	                        html.append(cell.getNumericCellValue());
	                    }

	                    html.append("</td>");
	                }

	                html.append("</tr>");
	            }
	        }

	        html.append("</table></body></html>");

	        workbook.close();

	        return html.toString();
	    }
}
