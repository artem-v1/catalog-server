package com.server.catalog.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.catalog.models.CityName;

@Repository
public interface CityNamesRepository extends JpaRepository<CityName, Long> {

}
