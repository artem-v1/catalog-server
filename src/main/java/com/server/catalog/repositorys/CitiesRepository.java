package com.server.catalog.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.server.catalog.models.City;

//@Repository
public interface CitiesRepository extends JpaRepository<City, Long> {

//	SELECT * FROM cities WHERE ST_DWithin(location::geography, ST_MakePoint(?, ?)::geography, ?)

//	 @Query(value = "SELECT * FROM constants.cities WHERE ST_DWithin(location::geography, "
//	 		+ "ST_MakePoint(?, ?)::geography, ?)", nativeQuery = true)
	 
//	WHERE ST_DWithin(location:::geography, "
//	 		+ "ST_MakePoint(52.2217481, 7.8169251):::geography, 20
//	
//	@Query(value = "SELECT * FROM constants.cities WHERE ST_DWithin(location::geography, ST_MakePoint(:longitude, :latitude)::geography, :radius)", nativeQuery = true)
	@Query(value = "SELECT * FROM constants.city WHERE ST_DWithin(CAST(location AS geography), CAST(ST_MakePoint(:longitude, :latitude) AS geography), :radius)", nativeQuery = true) 
	List<City> findCitiesByRadius(@Param("longitude") double longitude, @Param("latitude") double latitude, @Param("radius") double radius);	 
	 
}
