package com.server.catalog.DTO.CompanyDTO;

import java.io.Serializable;
import java.util.List;

public class OfferDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8407473480593113391L;
	
	private Long offerId;
    private Long companyId;
    private String categoryOffer;
    private String type;
    private String title;
    private String description;
    private List<PhotoDTO> photoOffers;
    private List<OfferCharacteristicDTO> offerCharacteristics;
	
    public OfferDTO() {}
    
    public OfferDTO(Long companyId, String categoryOffer, String type, String title, String description, List<PhotoDTO> photoOffers,
			List<OfferCharacteristicDTO> offerCharacteristics) {
		super();
		this.companyId = companyId;
		this.categoryOffer = categoryOffer;
		this.type = type;
		this.title = title;
		this.description = description;
		this.photoOffers = photoOffers;
		this.offerCharacteristics = offerCharacteristics;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public void setCategoryOffer(String categoryOffer) {
		this.categoryOffer = categoryOffer;
	}

	
	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public Long getOfferId() {
		return offerId;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public List<PhotoDTO> getPhotoOffers() {
		return photoOffers;
	}

	public void setPhotoOffers(List<PhotoDTO> photoOffers) {
		this.photoOffers = photoOffers;
	}

	public List<OfferCharacteristicDTO> getOfferCharacteristics() {
		return offerCharacteristics;
	}

	public void setOfferCharacteristics(List<OfferCharacteristicDTO> offerCharacteristics) {
		this.offerCharacteristics = offerCharacteristics;
	}

	public String getCategoryOffer() {
		return categoryOffer;
	}
	
    
    
}
