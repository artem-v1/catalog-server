package com.server.catalog.DTO.CompanyDTO;

import java.io.Serializable;
import java.util.Date;

public class ReviewDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7178537028501362541L;
	
	private Long reviewId;
	private Long companyId;
	private String photo;
	private String title;
	private Date date;
	private double rating;
	private String reviewContent;
	private Integer reviewLike;
	private Integer reviewUnlike;

	public ReviewDTO() {
	}

	public ReviewDTO(Long companyId, String photo, String title, Date date, double rating, String reviewContent,
			Integer reviewLike, Integer reviewUnlike) {
		super();
		this.companyId = companyId;
		this.photo = photo;
		this.title = title;
		this.date = date;
		this.rating = rating;
		this.reviewContent = reviewContent;
		this.reviewLike = reviewLike;
		this.reviewUnlike = reviewUnlike;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public Integer getReviewLike() {
		return reviewLike;
	}

	public void setReviewLike(Integer reviewLike) {
		this.reviewLike = reviewLike;
	}

	public Integer getReviewUnlike() {
		return reviewUnlike;
	}

	public void setReviewUnlike(Integer reviewUnlike) {
		this.reviewUnlike = reviewUnlike;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

}
