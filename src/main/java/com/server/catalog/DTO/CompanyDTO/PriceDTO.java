package com.server.catalog.DTO.CompanyDTO;

import java.io.Serializable;

public class PriceDTO implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 3222690451389294358L;
	
	private Long priceId;
    private Long companyId;
    private String name;
    private double price;
    private String unit;
    private String info;
	
    public PriceDTO() {}
    
    public PriceDTO(Long companyId, String name, double price, String unit, String info) {
		super();
		this.companyId = companyId;
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.info = info;
	}

    
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getPriceId() {
		return priceId;
	}

	
	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Long getCompanyId() {
		return companyId;
	}
    
    

}
