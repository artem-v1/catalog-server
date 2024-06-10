package com.server.catalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.catalog.DTO.CompanyDTO.CompanyCharacteristicDTO;
import com.server.catalog.services.CompanyCharacteristicService;

@RestController
@RequestMapping("/api/com-char")
public class CompanyCharacteristicController {

	@Autowired
	private CompanyCharacteristicService companyCharacteristicService;
	 
	 
	@GetMapping("/{companyId}")
	public ResponseEntity<List<CompanyCharacteristicDTO>> getCompanyCharackteristics(@PathVariable Long companyId){
		return new ResponseEntity<List<CompanyCharacteristicDTO>>(
				companyCharacteristicService.getCompanyCharacteristicsByCompanyId(companyId), 
				HttpStatus.OK
				);
	}
	
    @PostMapping("/add")
    public ResponseEntity<List<CompanyCharacteristicDTO>> createCompanyCharacteristics(@RequestBody List<CompanyCharacteristicDTO> characteristicsDTOList) {
        List<CompanyCharacteristicDTO> savedCharacteristicsDTOList = companyCharacteristicService.saveCharacteristics(characteristicsDTOList);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCharacteristicsDTOList);
    }
    
    @PutMapping("/update")
    public ResponseEntity<List<CompanyCharacteristicDTO>> updateCompanyCharacteristics(@RequestBody List<CompanyCharacteristicDTO> сompanyCharDTOList) {
    	List<CompanyCharacteristicDTO> updatedCompanyCharDTOList = companyCharacteristicService.updateCompanyCharacteristics(сompanyCharDTOList);
        if (updatedCompanyCharDTOList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCompanyCharDTOList);
    }
    
    
	    
}
