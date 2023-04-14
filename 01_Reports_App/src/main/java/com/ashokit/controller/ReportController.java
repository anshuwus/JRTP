package com.ashokit.controller;

import java.util.List;

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
	private IReportService reportService;
	
	@GetMapping("/")
	public String indexPage(Model model) {
		SearchRequest req=new SearchRequest();
		init(model,req);
		return "index";
	}
	
	@PostMapping("/search")
	public String searchRequest(@ModelAttribute("req")SearchRequest req,Model model) {
		System.out.println("request: "+req);
		List<CitizenPlan> list=reportService.search(req);
		list.forEach(citizen -> {
			System.out.println("Citizen Record:: "+citizen);
		});
		System.out.println();
		model.addAttribute("list", list);
		init(model,req);
		return "index";
	}
	
	private void init(Model model,SearchRequest req) {
		//SearchRequest req=new SearchRequest();
		model.addAttribute("request", req);
		model.addAttribute("names", reportService.getPlanNames());
		model.addAttribute("status", reportService.getPlanStatus());
	
	}
}
