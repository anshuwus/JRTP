package com.ashokit.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.request.SearchRequest;

public interface IReportService {
	
	public List<String> getPlanName();
	public List<String> getPlanStatus();
	public boolean exportExcel(HttpServletResponse response)throws Exception;
	public boolean exportPdf(HttpServletResponse response)throws Exception;
	public List<CitizenPlan> search(SearchRequest request);
}
