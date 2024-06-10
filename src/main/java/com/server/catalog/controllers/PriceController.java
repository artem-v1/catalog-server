package com.server.catalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.catalog.DTO.CompanyDTO.PriceDTO;
import com.server.catalog.services.PriceService;

@RestController
@RequestMapping("/api/price")
public class PriceController {

	@Autowired
	private PriceService priceService;
	
	@GetMapping("/company/{companyId}")
	public ResponseEntity<List<PriceDTO>> getPriceByCompanyId(@PathVariable long companyId){
		List<PriceDTO> priceDTOList = (List<PriceDTO>) priceService.getPriceByCompanyId(companyId);
		return new ResponseEntity<List<PriceDTO>>(priceDTOList, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<List<PriceDTO>> savePriceByCompanyId(@RequestBody List<PriceDTO> priceDTOList){
		List<PriceDTO> savedPriceDTOList = (List<PriceDTO>) priceService.savePriceList(priceDTOList);
		return new ResponseEntity<List<PriceDTO>>(savedPriceDTOList, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<List<PriceDTO>> updatePriceByCompanyId(@RequestBody List<PriceDTO> priceDTOList){
		List<PriceDTO> savedPriceDTOList = (List<PriceDTO>) priceService.updatePriceList(priceDTOList);
		return new ResponseEntity<List<PriceDTO>>(savedPriceDTOList, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delPriceById(@PathVariable long id){
		priceService.deletePriceById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
