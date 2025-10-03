package com.server.catalog.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.locationtech.jts.awt.PointShapeFactory.Point;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.catalog.DTO.CityDTO;
import com.server.catalog.models.City;
import com.server.catalog.models.CityName;
import com.server.catalog.services.CityService;

@RestController
@RequestMapping("/api/cities")
public class CityController {

	@Autowired
	CityService cityService;
	
    @GetMapping("/search")
    public ResponseEntity<List<CityDTO>> searchCities(@RequestParam String query) {
        List<CityDTO> cities = cityService.searchCities(query);
        if (cities.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204, если ничего не найдено
        }
        return ResponseEntity.ok(cities); // 200 с данными
    }
	
	
//    @GetMapping("/setCities")
//    public void setAllCities() throws Exception {
//    	
//    	//or other file:
//    	//cityDe.json
//    	//townDe.json
//        cityService.saveCity("src\\main\\resources\\temp\\villagesDe.json");
//    	System.out.println("Cities saved successful");
//    }
   
	
//	@GetMapping("/test")
//	public void getCities(){
//		
//		List<City> list= cityService.getAllCities();
//    	System.out.println("ALL CITIES " + list.toString());
//
//		
//	}
	
    @GetMapping("/test")
    public List<City> getCities() {
        List<City> list = cityService.getAllCities();
        for (City city : list) {
            System.out.println("ALL CITIES " + city.getCityId() + " / " );
            	for (CityName names : city.getCityNames()) {
                    System.out.println("NAME--- " + names.toString() + " / " );
                    
				}

		}
        return list;
    }
    




	@GetMapping("/test-id")
	public void getCitiesById(){
		
		City city = cityService.getCityById((long) 20833623);
		
		Set<CityName> cityNameSet = new HashSet<CityName>(7);
		cityNameSet.addAll(city.getCityNames());
		
    	System.out.println("CitiesId = " + city.getCityId() + 
    			"latitude = " + city.getLatitude() + 
    			"longitude = " + city.getLongitude() +
    			"location = " + city.getLocation()
    			);

    	cityNameSet.forEach(element -> {
    		String language = element.getId().getLanguage();
    		String name = element.getId().getName();
    	    // выполнить действия с каждым элементом
    	    System.out.println(language + " = " + name); // например, вывод элемента
    	});
	}

			int count = 0;

	@GetMapping("/by-radius")
	public void getCitiesByRadius(){
		List<City> cities = cityService.getCitiesByRadius(7.8169251, 52.2217481, 5000);
		cities.stream().forEach(el -> {
			el.getCityNames().forEach(elNames -> {
				String lang = elNames.getId().getLanguage();
				
				if (lang.equals("name")) {
					count += 1;
					String name = elNames.getId().getName();
					System.out.println("!!!!!!!!!!!!!!!!!!City in radius: " + name + " " + count);
					System.out.println("!!!!!!!!!!!!!!!!!!point: " + el.getLocation());
					System.out.println("!!!!!!!!!!!!!!!!!!point: " + el.getLocation());
					
				}
			});
		});

	}
//	
//	@Autowired
//	private GeometryFactory geometryFactory;
	
	@GetMapping("/locat/radius")
	public void getCitiesByPointAndRadius(){
//		List<City> cities = cityService.getCitiesByRadius(7.8169251, 52.2217481, 5000);
        GeometryFactory geometryFactory = new GeometryFactory();
        org.locationtech.jts.geom.Point center = geometryFactory.createPoint(new Coordinate(7.8169251, 52.2217481));
        center.setSRID(4326); 
		List<City> cities = cityService.findCitiesByPointAndRadius(center, 5000); //Radius(7.8169251, 52.2217481, 5000);

		cities.stream().forEach(el -> {
			el.getCityNames().forEach(elNames -> {
				String lang = elNames.getId().getLanguage();
				
				if (lang.equals("name")) {
					count += 1;
					String name = elNames.getId().getName();
					
					System.out.println("!!!!!!!!!!!!!!!!!!City: " + name);
					System.out.println("!!!!!!!!!!!!!!!!!!param1: " + el.getLongitude() + "; Param2: " + el.getLatitude());
					System.out.println("!!!!!!!!!!!!!!!!!!point: " + el.getLocation());
					
				}
			});
		});

	}

	
	
	
	
}
