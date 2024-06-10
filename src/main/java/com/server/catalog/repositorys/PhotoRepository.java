package com.server.catalog.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.catalog.models.Company;
import com.server.catalog.models.Offer;
import com.server.catalog.models.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

	List<Photo> findPhotoByCompany(Company company);

	List<Photo> findPhotoByOffer(Offer offer);

}
