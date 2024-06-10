package com.server.catalog.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.catalog.models.City;
import com.server.catalog.models.CityName;
import com.server.catalog.services.CityService;

@RestController
@RequestMapping("/api/tech")
public class techAdminController {

	@Autowired
	CityService cityService;
	
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
		List<City> cities = cityService.getCitiesByRadius(7.8169251, 52.2217481, 25000);
		cities.stream().forEach(el -> {
			el.getCityNames().forEach(elNames -> {
				String lang = elNames.getId().getLanguage();
				
				if (lang.equals("name")) {
					count += 1;
					String name = elNames.getId().getName();
					System.out.println("!!!!!!!!!!!!!!!!!!City in radius: " + name + " " + count);
					
				}
			});
		});

	}


	
	
	
	
}
