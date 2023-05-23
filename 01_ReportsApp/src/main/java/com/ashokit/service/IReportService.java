package com.ashokit.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.request.SearchRequest;

public interface IReportService {
	
	public List<String> getPlanName();
	public List<String> getPlanStatus();
	public boolean exportExcel(HttpServletResponse response)throws Exception;
	public ResponseEntity<InputStreamResource> showExcel(HttpServletResponse response,HttpHeaders headers)throws Exception;
	public boolean exportPdf(HttpServletResponse response)throws Exception;
	public List<CitizenPlan> search(SearchRequest request);
}
