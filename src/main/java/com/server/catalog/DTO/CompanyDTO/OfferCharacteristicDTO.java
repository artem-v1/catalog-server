package com.server.catalog.DTO.CompanyDTO;

import java.io.Serializable;

public class OfferCharacteristicDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8958642744445783680L;
	
	private Long offerCharId;
    private Long offerId;
    private String charCategory;
    private String charKey;
    private String charValue;
    private String icon;
	
    public OfferCharacteristicDTO() {}
    
    public OfferCharacteristicDTO(Long offerId, String charCategory, String charKey, String charValue, String icon) {
		super();
		this.offerId = offerId;
		this.charCategory = charCategory;
		this.charKey = charKey;
		this.charValue = charValue;
		this.icon = icon;
	}


    
    
	public String getCharKey() {
		return charKey;
	}

	public void setCharKey(String charKey) {
		this.charKey = charKey;
	}

	public String getCharValue() {
		return charValue;
	}

	public void setCharValue(String charValue) {
		this.charValue = charValue;
	}

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public void setOfferCharId(Long offerCharId) {
		this.offerCharId = offerCharId;
	}

	public String getCharCategory() {
		return charCategory;
	}

	public void setCharCategory(String charCategory) {
		this.charCategory = charCategory;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getOfferCharId() {
		return offerCharId;
	}

	
    
    
}
