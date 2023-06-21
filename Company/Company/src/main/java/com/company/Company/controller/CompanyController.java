package com.company.Company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.Company.model.Company;
import com.company.Company.service.CompanyService;

import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/company")
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@GetMapping(produces = "application/json")
	@PermitAll
	public ResponseEntity<List<Company>> getAllCompany()
	{
		List<Company> compList = companyService.getAllCompanies();
		ResponseEntity<List<Company>> response =
				new ResponseEntity<List<Company>>(compList,HttpStatusCode.valueOf(200));
		return response;
	}
	
	@PostMapping(produces = "application/json")
	@PermitAll
	public ResponseEntity <Company> saveCompany(@Valid @RequestBody Company Comp)
	{
		Company com =companyService.saveCompany(Comp);
		ResponseEntity <Company> response = 
		new ResponseEntity <Company>(com,HttpStatusCode.valueOf(200));
		return response;	    
	}
	
	@GetMapping(value = "/{cpname}",produces = "application/json")
	public ResponseEntity<Company> getCompany(@PathVariable("cpname")String cpname)
	{
		Company comp=companyService.getCompany(cpname);
		ResponseEntity<Company> response =
		new ResponseEntity<Company>(comp, HttpStatusCode.valueOf(200));
		return response;
		
	}
	
	@PutMapping(value = "/{cpname}",produces = "application/json")
	@PermitAll
	public ResponseEntity<Company> updateCompany(@PathVariable("cpname")String cpname,@Valid @RequestBody Company Comp)
	{
		Company comp=companyService.updateCompany(cpname, Comp);
		ResponseEntity<Company> response =
		new ResponseEntity<Company>(comp,HttpStatusCode.valueOf(200));
		return response;
		
	}
	
	@DeleteMapping(value = "/{cpname}", produces = "application/json")
	public ResponseEntity<String> deleteCourses(@PathVariable("cpname") String cpname)
	{
		boolean res = companyService.deleteCompany(cpname);
		String message;
		int status;
		if(res == true)
		{
		message = "course deleted!";
		status = 200;
		
		} else {
			message = "unable to delete!";
			status = 400;
		}
		ResponseEntity<String> response = 
				new ResponseEntity<String>(message, HttpStatusCode.valueOf(status));
		return response;
		
	}

}
