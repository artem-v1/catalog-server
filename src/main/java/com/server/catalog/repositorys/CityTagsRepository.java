package com.server.catalog.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.catalog.models.CityTag;

@Repository
public interface CityTagsRepository extends JpaRepository<CityTag, Long> {

}
