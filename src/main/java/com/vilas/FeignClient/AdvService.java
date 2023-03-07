package com.vilas.FeignClient;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.vilas.entity.Emp;

@FeignClient(name = "advance-service")//, url = "http://localhost:8082")
public interface AdvService 
{
	@GetMapping("/{id}")
	public Emp getAdvance(@PathVariable("id") String id);
	
}


/*
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
*/