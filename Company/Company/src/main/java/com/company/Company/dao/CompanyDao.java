package com.company.Company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.Company.model.Company;

@Repository
public interface CompanyDao extends JpaRepository<Company, String> {

}