package com.ashokit.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.repository.ICitizenPlanRepository;
import com.ashokit.request.SearchRequest;
import com.ashokit.utils.EmailUtils;
import com.ashokit.utils.ExcelGenerator;
import com.ashokit.utils.PdfGenerator;

@Service
public class ReportServiceImpl implements IReportService {
	
	@Autowired
	private ICitizenPlanRepository citizenRepo;
	@Autowired
	private ExcelGenerator excelGen;
	@Autowired
	private PdfGenerator pdfGen;
	@Autowired
	private EmailUtils emailUtils;
	
	@Override
	public List<String> getPlanName() {
		return citizenRepo.getPlanName();
	}

	@Override
	public List<String> getPlanStatus() {
		return citizenRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request){
		CitizenPlan citizen=new CitizenPlan();
		if(request.getPlanName()!=null && !"".equals(request.getPlanName()))
			citizen.setPlanName(request.getPlanName());
		if(request.getPlanStatus()!=null && !"".equals(request.getPlanStatus()))
			citizen.setPlanStatus(request.getPlanStatus());
		if(request.getGender()!=null && !"".equals(request.getGender()))
			citizen.setGender(request.getGender());
		if(request.getStartDate()!=null && !"".equals(request.getStartDate())) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			  String date = request.getStartDate();
			  //convert String to LocalDate
			  LocalDate localDate = LocalDate.parse(date, formatter);
			  citizen.setPlanStartDate(localDate);
		}	
		if(request.getEndDate()!=null && !"".equals(request.getEndDate())) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			  String date = request.getEndDate();
			  //convert String to LocalDate
			  LocalDate localDate = LocalDate.parse(date, formatter);
			  citizen.setPlanEndDate(localDate);
		}	
		return citizenRepo.findAll(Example.of(citizen));
	}
	
	@Override
	public boolean exportExcel(HttpServletResponse response)throws Exception{
		List<CitizenPlan> citizen=citizenRepo.findAll();
		File file=new File("Plans.xls");
		excelGen.generateExcel(response, citizen,file);
		
		String subject="Test Mail Subject";
		String body="<h1>Test Java Mail API</h>";
		String to="sweetuvi2508@gmail.com";
		emailUtils.sendEmail(subject, body, to,file);
		file.delete();
		
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response)throws Exception{
		List<CitizenPlan> citizen=citizenRepo.findAll();
		File file=new File("Plans.pdf");
        pdfGen.generatePdf(response, citizen,file);
        String subject="Test Mail Subject";
		String body="<h1>Test Mail body</h>";
		String to="sweetuvi2508@gmail.com";
		emailUtils.sendEmail(subject, body, to,file);
		file.delete();
	
		return true;
	}

}
