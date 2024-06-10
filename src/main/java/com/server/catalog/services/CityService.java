package com.server.catalog.services;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.catalog.DTO.CitiesElementFromJsonDTO;
import com.server.catalog.DTO.CitiesRootInfoFromJsonDTO;
import com.server.catalog.models.City;
import com.server.catalog.models.CityName;
import com.server.catalog.models.CityNameId;
import com.server.catalog.models.CityTag;
import com.server.catalog.models.CityTagId;
import com.server.catalog.repositorys.CitiesRepository;
import com.server.catalog.serializer.JsonParser;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CityService {
    
	public CityService() {
	}
	
	@Autowired
    private CitiesRepository citiesRepository;
	
//    
//    private CityNamesRepository cityNamesRepository;
//    
//    
//    private CityTagsRepository cityTagsRepository;
//	
//    @Autowired
//    public CityService(CitiesRepository citiesRepository) {
//        this.citiesRepository = citiesRepository;
//    }
    
//    @Autowired
//    public CityService(CityNamesRepository cityNamesRepository) {
//        this.cityNamesRepository = cityNamesRepository;
//    }
//    
//    @Autowired
//    public CityService(CityTagsRepository cityTegsRepository) {
//        this.cityTagsRepository = cityTagsRepository;
//    }

	
    
    public void saveCity(String pathFile) throws Exception {
    	
	    JsonParser jsonParser = new JsonParser();
	
//		try {
			CitiesRootInfoFromJsonDTO citiesDTO = 
					jsonParser.parseCitiesJson(pathFile); //link needs to be changing to var: filePath
			
			List<City> listOfCities = new ArrayList<City>();
			
			
			for (CitiesElementFromJsonDTO el: citiesDTO.getElements()) {
				City cities = new City();
				cities.setCityId(el.getId());
				cities.setLatitude(el.getLat());
				cities.setLongitude(el.getLon());
				
				Set<CityTag> cityTegsSet = new HashSet<CityTag>(7);
				Set<CityName> cityNamesSet = new HashSet<CityName>(7);
				
				//Map<String, String> tags = el.getTags();
				
				el.getTags().entrySet().stream()
				   .forEach(entry -> {
					   
					   String key = entry.getKey();
					   String value = entry.getValue();
					   
					   
					   if (key.startsWith("name")) {
						   
						 //Composite id
						   CityNameId cityNamesId = new CityNameId();
						   cityNamesId.setCityNamesId(el.getId());
						   cityNamesId.setLanguage(key); // получить язык из ключа
						   cityNamesId.setName(value);
						   
						   CityName cityNames = new CityName (cityNamesId, cities);
						   cityNamesSet.add(cityNames);
						   
					   } else {
						   
						 //Composite id
						   CityTagId cityTagsId = new CityTagId();
						   cityTagsId.setCityTagId(el.getId());
						   cityTagsId.setTagKey(key);
						   cityTagsId.setTagValue(value);
						   
						   CityTag cityTags = new CityTag(cityTagsId, cities);
						   cityTegsSet.add(cityTags);
					   }
			   		
				   });
				cities.setCityTagses(cityTegsSet);
				cities.setCityNameses(cityNamesSet);
				listOfCities.add(cities);
    
			}
			citiesRepository.saveAll(listOfCities);

    }

    public List<City> getAllCities() {
        return citiesRepository.findAll();
    }
    
    
    public City getCityById(Long id) {
        return citiesRepository.findById(id).orElseThrow(() -> 
        	new EntityNotFoundException("City not found with id: " + id));
    }
    
 
    public List<City> getCitiesByRadius(double latitude, double longitude, double radius) {
        return citiesRepository.findCitiesByRadius(latitude, longitude, radius);
    }
    

}

    
    
