package com.server.catalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.catalog.DTO.ReferenceDTO;
import com.server.catalog.DTO.CompanyDTO.CompanyDTO;
import com.server.catalog.models.Reference;
import com.server.catalog.services.ReferenceService;

@RestController
@RequestMapping("api/reference")
public class ReferenceController {

	@Autowired
	private ReferenceService referenceService;
	
	@GetMapping("/all")
	public ResponseEntity<List<ReferenceDTO>> getAllReferences(){
		List<ReferenceDTO> referenceDTOList = referenceService.getAllReferences();
		
        if (referenceDTOList == null) {
            return ResponseEntity.notFound().build();
        }
        
		return new ResponseEntity<List<ReferenceDTO>>(referenceDTOList, HttpStatus.OK);
	}
	
	@PostMapping("/save-ref")
	public ResponseEntity<List<ReferenceDTO>> saveReferences(@RequestBody List<ReferenceDTO> refDTOList){
		List<ReferenceDTO> savedRefDTOList = referenceService.saveReferences(refDTOList);
		return (ResponseEntity<List<ReferenceDTO>>) new ResponseEntity<List<ReferenceDTO>>(savedRefDTOList, HttpStatus.OK);
	}
	
}
