package com.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.repo.ICitizenPlaneRepository;
import com.ashokit.request.SearchRequest;

@Service
public class ReportServiceImpl implements IReportService {
	@Autowired
	private ICitizenPlaneRepository citizenRepo;
	
	@Override
	public List<String> getPlanNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getPlanStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exportExcel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exportPdf() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
