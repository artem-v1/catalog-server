package com.server.catalog.DTO.CompanyDTO;

import java.io.Serializable;

public class PhotoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3940900382620333049L;
	
	private Long photoId;
    private Long companyId;
    private Long offerId;
    private String photoName;
    private String photoLink;
	
    public PhotoDTO() {}
    
    public PhotoDTO(Long companyId, Long offerId, String photoName, String photoLink) {
		super();
		this.companyId = companyId;
		this.offerId = offerId;
		this.photoName = photoName;
		this.photoLink = photoLink;
	}

	public Long getPhotoId() {
		return photoId;
	}



	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}

	public Long getCompanyId() {
		return companyId;
	}
    
    public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}
	
}
