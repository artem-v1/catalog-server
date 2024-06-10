package com.server.catalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
//	@GetMapping("/")
//	public ResponseEntity<String> getReferenceValueByKey(@RequestBody String key){
//		String referenceValue = referenceService.getReferenceValueByKey(key);
//		return new ResponseEntity<String>(referenceValue, HttpStatus.OK);
//	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ReferenceDTO>> getAllReferences(){
		List<ReferenceDTO> referenceDTOList = referenceService.getAllReferences();
		
        if (referenceDTOList == null) {
            return ResponseEntity.notFound().build();
        }
        
		return new ResponseEntity<List<ReferenceDTO>>(referenceDTOList, HttpStatus.OK);
	}
	
	
//	@GetMapping("/all")
//	public ResponseEntity<List<Reference>> getAllReferences(){
//		List<Reference> references = referenceService.getAllReferences();
//		return new ResponseEntity<List<Reference>>(references, HttpStatus.OK);
//	}
	
	
//	//можно тестить
//	@PostMapping("/save-cat")
//	public ResponseEntity<List<Reference>> saveCategoryByCompanyId(@RequestBody List<CategoryDtoTEMP> categoryDtoList){
//		List<Reference> savedCategoryList = referenceService.saveCategoryDTOList(categoryDtoList);
//		return (ResponseEntity<List<Reference>>) new ResponseEntity<List<Reference>>(savedCategoryList, HttpStatus.OK);
//	}
//	
//	//сделать теперь метод для сохранения характеристик
//	//+сервисній слой
//	//можно тестить
//	@PostMapping("/save-char")
//	public ResponseEntity<List<Reference>> saveCharByCompanyId(@RequestBody List<СharacteristicDtoTEMP> charDtoList){
//		List<Reference> savedCharList = referenceService.saveCharDTOList(charDtoList);
//		return (ResponseEntity<List<Reference>>) new ResponseEntity<List<Reference>>(savedCharList, HttpStatus.OK);
//	}
	
	
}
