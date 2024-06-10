package com.server.catalog.DTO;

import java.util.List;
import java.util.Map;

public class CitiesRootInfoFromJsonDTO {
	
    private Double version;
    private String generator;
    private Map<String, String> osm3s;
    private List<CitiesElementFromJsonDTO> elements;
    
	public CitiesRootInfoFromJsonDTO() {
	}

	public CitiesRootInfoFromJsonDTO(Double version, String generator, Map<String, String> osm3s, List<CitiesElementFromJsonDTO> elements) {
		this.version = version;
		this.generator = generator;
		this.osm3s = osm3s;
		this.elements = elements;
	}

	public Double getVersion() {
		return version;
	}

	public void setVersion(Double version) {
		this.version = version;
	}

	public String getGenerator() {
		return generator;
	}

	public void setGenerator(String generator) {
		this.generator = generator;
	}

	public Map<String, String> getOsm3s() {
		return osm3s;
	}

	public void setOsm3s(Map<String, String> osm3s) {
		this.osm3s = osm3s;
	}

	public List<CitiesElementFromJsonDTO> getElements() {
		return elements;
	}

	public void setElements(List<CitiesElementFromJsonDTO> elements) {
		this.elements = elements;
	};
	
	
	
}
