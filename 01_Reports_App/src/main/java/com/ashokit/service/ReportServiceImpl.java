package com.ashokit.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
		return citizenRepo.getPlanName();
	}

	@Override
	public List<String> getPlanStatus() {
		return citizenRepo.getPlanStatus();
	}

	@Override
	public boolean exportExcel() {
		
		return false;
	}

	@Override
	public boolean exportPdf() {
		return false;
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan citizen=new CitizenPlan();
		if(request.getPlanName()!=null && !"".equals(request.getPlanName())) {
			citizen.setPlanName(request.getPlanName());
		}
		if(request.getPlanStatus()!=null && !"".equals(request.getPlanStatus())) {
			citizen.setPlanStatus(request.getPlanStatus());
		}
		if(request.getGender()!=null && !"".equals(request.getGender())) {
			citizen.setGender(request.getGender());
		}
		if(request.getStartDate()!=null && !"".equals(request.getStartDate())) {
			citizen.setPlanStartDate(request.getStartDate());
		}
		if(request.getEndDate()!=null && !"".equals(request.getEndDate())) {
			citizen.setPlanEndDate(request.getEndDate());
		}
		
     	Example<CitizenPlan> example=Example.of(citizen);
		List<CitizenPlan> list=citizenRepo.findAll(example);
		return list;
	}

}
