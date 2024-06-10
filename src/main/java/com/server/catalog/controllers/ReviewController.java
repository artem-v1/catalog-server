package com.server.catalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.catalog.DTO.CompanyDTO.ReviewDTO;
import com.server.catalog.services.ReviewService;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/company/{companyId}")
	public ResponseEntity<List<ReviewDTO>> getReviewsByCompanyId(@PathVariable Long companyId) {

		return new ResponseEntity<List<ReviewDTO>>(reviewService.getReviewsByCompanyId(companyId), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<ReviewDTO> addReview(@RequestBody ReviewDTO reviewDTO) {
		ReviewDTO savedReviewDTO = reviewService.addReview(reviewDTO);
		return new ResponseEntity<ReviewDTO>(savedReviewDTO, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<ReviewDTO> updateReview(@RequestBody ReviewDTO reviewDTO) {
		ReviewDTO savedReviewDTO = reviewService.updateReview(reviewDTO);
		return new ResponseEntity<ReviewDTO>(savedReviewDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{reviewId}")
	public ResponseEntity<?> deleteReview(@PathVariable Long reviewId) {
		reviewService.deleteReview(reviewId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
