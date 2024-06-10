package com.server.catalog.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.server.catalog.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {


	
	

}
