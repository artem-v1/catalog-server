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

import com.server.catalog.DTO.CompanyDTO.OfferCharacteristicDTO;
import com.server.catalog.services.OfferCharacteristicService;

@RestController
@RequestMapping("api/offer-char")
public class OfferChatacteristicController {

	@Autowired
	private OfferCharacteristicService offerCharacteristicService;
	
	@GetMapping("/{offerId}")
	public ResponseEntity<List<OfferCharacteristicDTO>> getAllOfferCharByOfferId(@PathVariable Long offerId){
		return new ResponseEntity<List<OfferCharacteristicDTO>>(
				offerCharacteristicService.getAllOfferCharByOfferId(offerId), 
				HttpStatus.OK
				);
	}
	
	@PostMapping("/save")
	public ResponseEntity<List<OfferCharacteristicDTO>> saveAllOfferCharByOfferId(@RequestBody List<OfferCharacteristicDTO> offerCharDTOList){
		return new ResponseEntity<List<OfferCharacteristicDTO>>(
				offerCharacteristicService.saveAllOfferCharByOfferId(offerCharDTOList), 
				HttpStatus.OK
				);
	}
	
	@PutMapping("/update")
	public ResponseEntity<List<OfferCharacteristicDTO>> updateAllOfferCharByOfferId(@RequestBody List<OfferCharacteristicDTO> offerCharDTOList){
		return new ResponseEntity<List<OfferCharacteristicDTO>>(
				offerCharacteristicService.updateAllOfferCharByOfferId(offerCharDTOList), 
				HttpStatus.OK
				);
	}
	
}
