 package com.company.Company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.Company.dao.CompanyDao;
import com.company.Company.model.Company;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyDao companyDao;
	
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return companyDao.findAll();
	}

	@Override
	public Company getCompany(String cpname) {
		// TODO Auto-generated method stub
		Optional<Company>companyOp = companyDao.findById(cpname);
		return companyOp.get();
	}

	@Override
	public Company saveCompany(Company comp) {
		// TODO Auto-generated method stub
		return companyDao.save(comp);
	}

	@Override
	public Company updateCompany(String cpname, Company comp) {
		// TODO Auto-generated method stub
		Optional<Company>companyOp = companyDao.findById(comp.getCpname());
        Company companyFromDB = companyOp.get();
        
        companyFromDB.setCpname(comp.getCpname());
        companyFromDB.setLocation(comp.getLocation());
        companyFromDB.setPhoneno(comp.getPhoneno());
        companyFromDB.setEmail(comp.getEmail());
        companyFromDB.setPincode(comp.getPincode());
        companyFromDB.setArea(comp.getArea());
        companyFromDB.setHrphone(comp.getHrphone());
        companyFromDB.setHrname(comp.getHrname());


    Company savedc = companyDao.save(companyFromDB);
		return savedc;
	}

	public boolean deleteCompany(String cpname) {
		// TODO Auto-generated method stub
		Optional<Company>companyOp = companyDao.findById(cpname);
		if (companyOp.isPresent()) {
			companyDao.delete(companyOp.get());
			return true;
		}

		return false;
	}

	

	
		
	
	

}