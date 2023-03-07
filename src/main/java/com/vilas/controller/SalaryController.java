package com.vilas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vilas.entity.Emp;
import com.vilas.salservice.SalService;

@RestController
public class SalaryController 
{	
	@Autowired
	SalService service;

	@GetMapping(value = "/{id}")
	Emp getSalary(@PathVariable("id") int id)
	{
		System.out.println("Controller called..."+id);

		//return service.getSalary(id);
		
		return service.getSalaryByFeign(id);	

	}


}
