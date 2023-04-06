package com.ashokit.service;

import java.util.List;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.request.SearchRequest;

public interface IReportService {
	
	public List<String> getPlanNames();
	public List<String> getPlanStatus();
	public boolean exportExcel();
	public boolean exportPdf();
	public List<CitizenPlan> search(SearchRequest request);
}
