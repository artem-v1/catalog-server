package com.server.catalog.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.catalog.models.Company;
import com.server.catalog.models.CompanyCharacteristic;

@Repository
public interface CompanyCharacteristicRepository extends JpaRepository<CompanyCharacteristic, Long> {

	void deleteByCompany(Company company);

	List<CompanyCharacteristic> findByCompany(Company company);

}
