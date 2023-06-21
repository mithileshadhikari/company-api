package com.company.Company.service;

import java.util.List;

import com.company.Company.model.Company;

public interface CompanyService {

List<Company> getAllCompanies();
	
Company getCompany(String  cpname);
	
	Company saveCompany(Company Comp);
	
	Company updateCompany(String cpname ,Company Comp);
	
	boolean deleteCompany(String cpname);


}