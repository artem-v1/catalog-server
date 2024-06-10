package com.server.catalog.repositorys;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.catalog.DTO.CompanyDTO.ReviewDTO;
import com.server.catalog.models.Company;
import com.server.catalog.models.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

	List<Review> findByCompany(Company company);

	Collection<Review> findAllByCompany(Company company);

}
