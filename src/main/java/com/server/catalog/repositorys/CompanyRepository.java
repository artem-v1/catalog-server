package com.server.catalog.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.server.catalog.models.City;
import com.server.catalog.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	
	@Query(value = "SELECT * FROM company WHERE ST_DWithin(CAST(location AS geography), CAST(ST_MakePoint(:longitude, :latitude) AS geography), :radius)", nativeQuery = true) 
	List<Company> findCompaniesByRadius(@Param("longitude") double longitude, @Param("latitude") double latitude, @Param("radius") double radius);
	
//	List<City> findCitiesByRadius(@Param("longitude") double longitude, @Param("latitude") double latitude, @Param("radius") double radius);


	
	

}
