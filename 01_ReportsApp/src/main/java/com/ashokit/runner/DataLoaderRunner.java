package com.ashokit.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.repository.ICitizenPlanRepository;

//@Component
public class DataLoaderRunner implements ApplicationRunner{
	@Autowired
	private ICitizenPlanRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		//Cash Plan Data
				CitizenPlan c1=new CitizenPlan();
				c1.setCitizenName("John");
				c1.setGender("Male");
				c1.setPlanName("Cash");
				c1.setPlanStatus("Approved");
				c1.setPlanStartDate(LocalDate.now());
				c1.setPlanEndDate(LocalDate.now().plusMonths(6));
				c1.setBenefitAmt(5000.0);
				
				CitizenPlan c2=new CitizenPlan();
				c2.setCitizenName("Samanta");
				c2.setGender("Fe-Male");
				c2.setPlanName("Cash");
				c2.setPlanStatus("Approved");
				c2.setPlanStartDate(LocalDate.now().minusMonths(2));
				c2.setPlanEndDate(LocalDate.now().plusMonths(8));
				c2.setBenefitAmt(5000.0);
				
				CitizenPlan c3=new CitizenPlan();
				c3.setCitizenName("Smith");
				c3.setGender("Male");
				c3.setPlanName("Cash");
				c3.setPlanStatus("Denied");
			    c3.setDenialReason("Rental Income");
				
			    CitizenPlan c4=new CitizenPlan();
			    c4.setCitizenName("Shivi");
			    c4.setGender("Fe-Male");
			    c4.setPlanName("Cash");
			    c4.setPlanStatus("Denied");
			    c4.setDenialReason("Govt Job");
			    
			    CitizenPlan c5=new CitizenPlan();
			    c5.setCitizenName("Paxton");
			    c5.setGender("Male");
				c5.setPlanName("Cash");
				c5.setPlanStatus("Terminated");
				c5.setPlanStartDate(LocalDate.now().minusMonths(4));
				c5.setPlanEndDate(LocalDate.now().plusMonths(6));
				c5.setBenefitAmt(4000.0);
				c5.setTerminatedDate(LocalDate.now());
				c5.setTerminationRsn("Employed");
						 
				CitizenPlan c6=new CitizenPlan();
				c6.setCitizenName("Devi");
				c6.setGender("Fe-Male");
				c6.setPlanName("Cash");
				c6.setPlanStatus("Terminated");
				c6.setPlanStartDate(LocalDate.now().minusMonths(4));
				c6.setPlanEndDate(LocalDate.now().plusMonths(6));
				c6.setBenefitAmt(4000.0);
				c6.setTerminatedDate(LocalDate.now());
				c6.setTerminationRsn("Employed");
				
				
				//Food Plan Data
				CitizenPlan c7=new CitizenPlan();
				c7.setCitizenName("David");
				c7.setGender("Male");
				c7.setPlanName("Food");
				c7.setPlanStatus("Approved");
				c7.setPlanStartDate(LocalDate.now());
				c7.setPlanEndDate(LocalDate.now().plusMonths(6));
				c7.setBenefitAmt(5000.0);
				
				CitizenPlan c8=new CitizenPlan();
				c8.setCitizenName("Anansy");
				c8.setGender("Fe-Male");
				c8.setPlanName("Food");
				c8.setPlanStatus("Approved");
				c8.setPlanStartDate(LocalDate.now().minusMonths(2));
				c8.setPlanEndDate(LocalDate.now().plusMonths(8));
				c8.setBenefitAmt(5000.0);
				
				CitizenPlan c9=new CitizenPlan();
				c9.setCitizenName("Cristian");
				c9.setGender("Male");
				c9.setPlanName("Food");
				c9.setPlanStatus("Denied");
				c9.setDenialReason("Property Income");
				
			    CitizenPlan c10=new CitizenPlan();
			    c10.setCitizenName("Anesthesia");
			    c10.setGender("Fe-Male");
			    c10.setPlanName("Food");
			    c10.setPlanStatus("Denied");
			    c10.setDenialReason("Land Interest");
			    
			    CitizenPlan c11=new CitizenPlan();
			    c11.setCitizenName("Dev");
			    c11.setGender("Male");
			    c11.setPlanName("Food");
			    c11.setPlanStatus("Terminated");
			    c11.setPlanStartDate(LocalDate.now().minusMonths(4));
			    c11.setPlanEndDate(LocalDate.now().plusMonths(6));
				c11.setBenefitAmt(4000.0);
				c11.setTerminatedDate(LocalDate.now());
				c11.setTerminationRsn("Govt worker");
						 
				CitizenPlan c12=new CitizenPlan();
				c12.setCitizenName("Any");
				c12.setGender("Fe-Male");
				c12.setPlanName("Food");
				c12.setPlanStatus("Terminated");
				c12.setPlanStartDate(LocalDate.now().minusMonths(3));
				c12.setPlanEndDate(LocalDate.now().plusMonths(7));
				c12.setBenefitAmt(4000.0);
				c12.setTerminatedDate(LocalDate.now());
				c12.setTerminationRsn("Employed");
				
				
				//Medical Plan Data
				CitizenPlan c13=new CitizenPlan();
				c13.setCitizenName("Cathy");
				c13.setGender("Male");
				c13.setPlanName("Medical");
				c13.setPlanStatus("Approved");
				c13.setPlanStartDate(LocalDate.now());
				c13.setPlanEndDate(LocalDate.now().plusMonths(6));
				c13.setBenefitAmt(5000.0);
				
				CitizenPlan c14=new CitizenPlan();
				c14.setCitizenName("Mikey");
				c14.setGender("Fe-Male");
				c14.setPlanName("Medical");
				c14.setPlanStatus("Approved");
				c14.setPlanStartDate(LocalDate.now().minusMonths(2));
				c14.setPlanEndDate(LocalDate.now().plusMonths(8));
				c14.setBenefitAmt(5000.0);
				
				CitizenPlan c15=new CitizenPlan();
				c15.setCitizenName("Grey");
				c15.setGender("Male");
				c15.setPlanName("Medical");
				c15.setPlanStatus("Denied");
				c15.setDenialReason("Property Income");
				
			    CitizenPlan c16=new CitizenPlan();
			    c16.setCitizenName("Mehak");
			    c16.setGender("Fe-Male");
			    c16.setPlanName("Medical");
			    c16.setPlanStatus("Denied");
			    c16.setDenialReason("Land Interest");
			    
			    CitizenPlan c17=new CitizenPlan();
			    c17.setCitizenName("Vikas");
			    c17.setGender("Male");
			    c17.setPlanName("Medical");
			    c17.setPlanStatus("Terminated");
			    c17.setPlanStartDate(LocalDate.now().minusMonths(4));
			    c17.setPlanEndDate(LocalDate.now().plusMonths(6));
			    c17.setBenefitAmt(4000.0);
			    c17.setTerminatedDate(LocalDate.now());
			    c17.setTerminationRsn("Govt worker");
						 
				CitizenPlan c18=new CitizenPlan();
				c18.setCitizenName("Aman");
				c18.setGender("Fe-Male");
				c18.setPlanName("Medical");
				c18.setPlanStatus("Terminated");
				c18.setPlanStartDate(LocalDate.now().minusMonths(3));
				c18.setPlanEndDate(LocalDate.now().plusMonths(7));
				c18.setBenefitAmt(4000.0);
				c18.setTerminatedDate(LocalDate.now());
				c18.setTerminationRsn("Employed");
				
				//Employment Plan Data
				CitizenPlan c19=new CitizenPlan();
				c19.setCitizenName("Georage");
				c19.setGender("Male");
				c19.setPlanName("Employment");
				c19.setPlanStatus("Approved");
				c19.setPlanStartDate(LocalDate.now());
				c19.setPlanEndDate(LocalDate.now().plusMonths(6));
				c19.setBenefitAmt(5000.0);
				
				CitizenPlan c20=new CitizenPlan();
				c20.setCitizenName("Meena");
				c20.setGender("Fe-Male");
				c20.setPlanName("Employment");
				c20.setPlanStatus("Approved");
				c20.setPlanStartDate(LocalDate.now().minusMonths(2));
				c20.setPlanEndDate(LocalDate.now().plusMonths(8));
				c20.setBenefitAmt(5000.0);
				
				CitizenPlan c21=new CitizenPlan();
				c21.setCitizenName("Grey");
				c21.setGender("Male");
				c21.setPlanName("Employment");
				c21.setPlanStatus("Denied");
				c21.setDenialReason("Property Income");
				
			    CitizenPlan c22=new CitizenPlan();
			    c22.setCitizenName("Mehak");
			    c22.setGender("Fe-Male");
			    c22.setPlanName("Employment");
			    c22.setPlanStatus("Denied");
			    c22.setDenialReason("Land Interest");
			    
			    CitizenPlan c23=new CitizenPlan();
			    c23.setCitizenName("Deep");
			    c23.setGender("Male");
			    c23.setPlanName("Employment");
			    c23.setPlanStatus("Terminated");
			    c23.setPlanStartDate(LocalDate.now().minusMonths(4));
			    c23.setPlanEndDate(LocalDate.now().plusMonths(6));
			    c23.setBenefitAmt(4000.0);
			    c23.setTerminatedDate(LocalDate.now());
			    c23.setTerminationRsn("Govt worker");
						 
				CitizenPlan c24=new CitizenPlan();
				c24.setCitizenName("Priya");
				c24.setGender("Fe-Male");
				c24.setPlanName("Employment");
				c24.setPlanStatus("Terminated");
				c24.setPlanStartDate(LocalDate.now().minusMonths(3));
				c24.setPlanEndDate(LocalDate.now().plusMonths(7));
				c24.setBenefitAmt(4000.0);
				c24.setTerminatedDate(LocalDate.now());
				c24.setTerminationRsn("Employed");
				
				List<CitizenPlan> list=Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24);
				repo.saveAll(list);
			}
	
}
