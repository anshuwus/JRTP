package com.ashokit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.request.SearchRequest;
import com.ashokit.service.IReportService;

@Controller
public class ReportController {
	@Autowired
	private IReportService service;
	
	@GetMapping("/")
	public String indexPage(Model model) {
		SearchRequest req=new SearchRequest();
		init(model,req,"indexPage",null);
		return "index";
	}
	
	@PostMapping("/search")
	public String searchRequest(@ModelAttribute("req")SearchRequest request,Model model) {
		List<CitizenPlan> list=service.search(request);
		System.out.println("SearchRequest:: "+request);
		list.forEach(citizenPlan -> {
			System.out.println("CitizenPlan:: "+citizenPlan);
		});
		System.out.println();
		//model.addAttribute("list", list);
		init(model,request,"searchReq",list);
		return "index";
	}
	
	private void init(Model model,SearchRequest req,String s,List<CitizenPlan> list) {
		
		if(s.equals("searchReq")) {
			 System.out.println("searchReq");
			 model.addAttribute("data", "sucess");
		     model.addAttribute("list", list);
		}
		model.addAttribute("request", req);
		model.addAttribute("names", service.getPlanName());
		model.addAttribute("status", service.getPlanStatus());
	}
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=plans.xls");
		service.exportExcel(response);
	}
	
	@GetMapping("/pdf")
	public void excelPdf(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename=plans.pdf");
		service.exportPdf(response);
	}
}
