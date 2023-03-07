package com.vilas.salservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.vilas.FeignClient.AdvService;
import com.vilas.FeignClient.DayService;
import com.vilas.entity.Emp;

@Component
public class SalService {
	
	@Autowired
	private DayService dayService;
	
	@Autowired
	private AdvService advService;
	
	@Value("${name: default name}")
	String name;
	
	@Value("${contact: default name}")
	String contact;
	
	public Emp getSalary(int id)
	{	
		//int id;
		String name = "Xyz";
		int salary_per_day = 5000;
		int total_working_day = 0;
		int advance_salary = 0;
		int total_salary =0;
  
		// Call DayService
		Map<String, String>uriVariables=new HashMap<>();  
		uriVariables.put("id", id+"");  

		ResponseEntity<Emp> response = new RestTemplate().getForEntity("http://localhost:8081/{id}", Emp.class, uriVariables);
		Emp e_days = response.getBody();
		System.out.println("DayService Response of Rest Template of Total Working Day"+ e_days.getTotal_working_day());
		total_working_day = e_days.getTotal_working_day();
		
		//Call Advance Salary
		Map<String, String>uriVariables2=new HashMap<>();  
		uriVariables2.put("id", id+"");  

		ResponseEntity<Emp> response2 = new RestTemplate().getForEntity("http://localhost:8082/{id}", Emp.class, uriVariables2);
		Emp e_adv = response2.getBody();
		System.out.println("AdvSalary Service Response of Rest Template of Total Working Day"+ e_adv.getAdvance_salary());
		advance_salary = e_adv.getAdvance_salary();
		
		//Calculate total salary
		
		total_salary = (salary_per_day * total_working_day) - advance_salary;
		
		return new Emp(id, name, salary_per_day, total_working_day, advance_salary, total_salary); 
	}
	
	
	public Emp getSalaryByFeign(int id)
	{	
		
		//int id;
		String name = "Xyz";
		int salary_per_day = 5000;
		int total_working_day = 0;
		int advance_salary = 0;
		int total_salary =0;
  
		
		// Call DayService
		Emp e_days = dayService.getDays(id+"");
		System.out.println("DayService Response of Feign client of Total Working Day"+ e_days.getTotal_working_day());
		total_working_day = e_days.getTotal_working_day();
		
		//Call Advance Salary
		Map<String, String>uriVariables2=new HashMap<>();  
		uriVariables2.put("id", id+"");  

		Emp e_adv = advService.getAdvance(id+"");
		System.out.println("AdvSalary Service Response of Feign Client of Total Working Day"+ e_adv.getAdvance_salary());
		advance_salary = e_adv.getAdvance_salary();
		
		//Calculate total salary		
		total_salary = (salary_per_day * total_working_day) - advance_salary;		
		return new Emp(id, name, salary_per_day, total_working_day, advance_salary, total_salary); 
	}

}
