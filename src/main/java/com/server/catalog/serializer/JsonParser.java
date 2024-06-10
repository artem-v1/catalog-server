package com.server.catalog.serializer;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.catalog.DTO.CitiesRootInfoFromJsonDTO;

public class JsonParser {

	
	 public CitiesRootInfoFromJsonDTO parseCitiesJson(String pathToJsonFile) throws IOException {
		 
	        ObjectMapper objectMapper = new ObjectMapper();
	        File file = new File(pathToJsonFile);
	        
	        return objectMapper.readValue(file, CitiesRootInfoFromJsonDTO.class);
	    }
}
