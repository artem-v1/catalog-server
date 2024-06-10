package com.server.catalog.DTO.CompanyDTO;

import java.io.Serializable;
import java.util.List;

import org.locationtech.jts.geom.Point;

public class CompanyDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2686572815382869436L;
	
	private Long companyId;
    private String title;
    private String description;
    private String phone;
    private String email;
    public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	private String street;
    private String house;
    private String city;
    private String land;
    private String postCode;
    private double latitude;
    private double longitude;
    private Point location;
    private List<PhotoDTO> photos;
    private List<PriceDTO> prices;
    private List<WorkTimeDTO> workTimes;
    private List<CompanyCharacteristicDTO> companyCharacteristics;
    private List<OfferDTO> offers;
    private List<ReviewDTO> reviews;
    
    
    public CompanyDTO() {}
    
	public CompanyDTO(String title, String description, String phone, String email, String street,
			String house, String city, String land, String postCode, double latitude, double longitude, Point location,
			List<PhotoDTO> photos, List<PriceDTO> prices, List<WorkTimeDTO> workTimes,
			List<CompanyCharacteristicDTO> companyCharacteristics, List<OfferDTO> offers, List<ReviewDTO> reviews) {
		super();
		this.title = title;
		this.description = description;
		this.phone = phone;
		this.email = email;
		this.street = street;
		this.house = house;
		this.city = city;
		this.land = land;
		this.postCode = postCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.location = location;
		this.photos = photos;
		this.prices = prices;
		this.workTimes = workTimes;
		this.companyCharacteristics = companyCharacteristics;
		this.offers = offers;
		this.reviews = reviews;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public List<PhotoDTO> getPhotos() {
		return photos;
	}

	public void setPhotos(List<PhotoDTO> photos) {
		this.photos = photos;
	}

	public List<PriceDTO> getPrices() {
		return prices;
	}

	public void setPrices(List<PriceDTO> prices) {
		this.prices = prices;
	}

	public List<WorkTimeDTO> getWorkTimes() {
		return workTimes;
	}

	public void setWorkTimes(List<WorkTimeDTO> workTimes) {
		this.workTimes = workTimes;
	}

	public List<CompanyCharacteristicDTO> getCompanyCharacteristics() {
		return companyCharacteristics;
	}

	public void setCompanyCharacteristics(List<CompanyCharacteristicDTO> companyCharacteristics) {
		this.companyCharacteristics = companyCharacteristics;
	}

	public List<OfferDTO> getOffers() {
		return offers;
	}

	public void setOffers(List<OfferDTO> offers) {
		this.offers = offers;
	}

	public List<ReviewDTO> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}

	public Long getCompanyId() {
		return companyId;
	}

	
	
}
