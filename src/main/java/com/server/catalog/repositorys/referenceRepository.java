package com.server.catalog.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.catalog.models.Reference;

@Repository
public interface referenceRepository extends JpaRepository<Reference, Long>{

	String findReferenceByKey(String key);

}
