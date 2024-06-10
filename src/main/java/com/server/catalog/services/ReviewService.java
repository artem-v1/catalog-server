package com.server.catalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.server.catalog.DTO.CompanyDTO.ReviewDTO;
import com.server.catalog.models.Company;
import com.server.catalog.models.Review;
import com.server.catalog.repositorys.CompanyRepository;
import com.server.catalog.repositorys.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private CompanyRepository companyRepository;

	public List<ReviewDTO> getReviewsByCompanyId(long companiId) {

		Company company = companyRepository.findById(companiId).orElseThrow();
	
		List<Review> reviewList = reviewRepository.findByCompany(company);
		List<ReviewDTO> reviewDTOList = reviewList.stream()
				.map(review -> convertToDTO(review))
				.collect(Collectors.toList());
		return reviewDTOList;
	}
	
	public ReviewDTO addReview(ReviewDTO reviewDTO) {
				
		Review review = convertToEntity(new Review(), reviewDTO);
		
		Review savedReview = reviewRepository.save(review);
		
		return convertToDTO(savedReview);
	}
	
	public ReviewDTO updateReview(ReviewDTO reviewDTO) {

		Review review = reviewRepository.findById(reviewDTO.getReviewId()).orElseThrow();
		
		review = reviewRepository.save(convertToEntity(review, reviewDTO));
		
		return convertToDTO(review);
	}
	
	public void deleteReview(Long reviewId) {
		if (!reviewRepository.existsById(reviewId)) {
	        throw new EmptyResultDataAccessException("No offer found with id: " + reviewId, 1);
	    }
    	reviewRepository.deleteById(reviewId);
    	
	}

	private Review convertToEntity(Review review, ReviewDTO reviewDTO) {

		Company company = companyRepository.findById(reviewDTO.getCompanyId()).orElseThrow();
		
		review.setCompany(company);
		review.setTitle(reviewDTO.getTitle());
		review.setDate(reviewDTO.getDate());
		review.setPhoto(reviewDTO.getPhoto());
		review.setRating(reviewDTO.getRating());
		review.setReviewContent(reviewDTO.getReviewContent());
		review.setReviewLike(reviewDTO.getReviewLike());
		review.setReviewUnlike(reviewDTO.getReviewUnlike());
		

		return review;
	}

	private ReviewDTO convertToDTO(Review review) {

		ReviewDTO reviewDTO = new ReviewDTO();
		
		reviewDTO.setCompanyId(review.getCompany().getCompanyId());
		reviewDTO.setDate(review.getDate());
		reviewDTO.setPhoto(review.getPhoto());
		reviewDTO.setRating(review.getRating());
		reviewDTO.setReviewContent(review.getReviewContent());
		reviewDTO.setReviewId(review.getReviewId());
		reviewDTO.setReviewLike(review.getReviewLike());
		reviewDTO.setReviewUnlike(review.getReviewUnlike());
		reviewDTO.setTitle(review.getTitle());
		
		return reviewDTO;
	}




	
	
	
}
