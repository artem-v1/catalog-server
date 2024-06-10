package com.server.catalog.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.catalog.models.Company;
import com.server.catalog.models.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{

	List<Price> findPriceByCompany(Company company);

	void deleteAllByCompany(Company company);

}
