package com.server.catalog.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.catalog.models.Company;
import com.server.catalog.models.CompanyCharacteristic;
import com.server.catalog.models.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
	
	List<Offer> findByCompany(Company company);

}
