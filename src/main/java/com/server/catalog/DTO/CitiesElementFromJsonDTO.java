package com.server.catalog.DTO;

import java.util.Map;

public class CitiesElementFromJsonDTO {

    private String type;
    private Long id;
    private Double lat;
    private Double lon;
    private Map<String, String> tags;
    

    
	public CitiesElementFromJsonDTO() {
	}

	public CitiesElementFromJsonDTO(String type, Long id, Double lat, Double lon, Map<String, String> tags) {
		this.type = type;
		this.id = id;
		this.lat = lat;
		this.lon = lon;
		this.tags = tags;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Map<String, String> getTags() {
		return tags;
	}

	public void setTags(Map<String, String> tags) {
		this.tags = tags;
	}
	
	
    
    
	
}
