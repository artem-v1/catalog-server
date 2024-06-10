package com.server.catalog.DTO.CompanyDTO;

import java.io.Serializable;

public class CompanyCharacteristicDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4039243229116774299L;
	
	private Long comCharId;
    private Long companyId;
    private String charCategory;
    private String charKey;
    //private String charValue;
    private String icon;
    
    public CompanyCharacteristicDTO() {}
    
    public CompanyCharacteristicDTO(Long companyId, String charCategory, String charKey, String icon) {
		super();
		this.companyId = companyId;
		this.charCategory = charCategory;
		this.charKey = charKey;
		this.icon = icon;
	}

	
	public String getCharKey() {
		return charKey;
	}



	public void setCharKey(String charKey) {
		this.charKey = charKey;
	}

	public void setComCharId(Long comCharId) {
		this.comCharId = comCharId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCharCategory() {
		return charCategory;
	}

	public void setCharCategory(String charCategory) {
		this.charCategory = charCategory;
	}

//	public String getCharValue() {
//		return charValue;
//	}
//
//	public void setCharValue(String charValue) {
//		this.charValue = charValue;
//	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getComCharId() {
		return comCharId;
	}
    
	
    
}
