package com.server.catalog.controllers;

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

import com.server.catalog.DTO.CompanyDTO.OfferDTO;
import com.server.catalog.services.OfferService;

@RestController
@RequestMapping("/api/offer")
public class OfferController {

	@Autowired
	private OfferService offerService;
	
	@GetMapping("/{offerId}")
	public ResponseEntity<OfferDTO> getOffer(@PathVariable long offerId){
		OfferDTO savedOfferDTO = offerService.findOfferById(offerId);
		return new ResponseEntity<>(savedOfferDTO, HttpStatus.CREATED);
	}
	
	@PostMapping("/save")
	public ResponseEntity<OfferDTO> createOffer(@RequestBody OfferDTO offerDTO){
		OfferDTO savedOfferDTO = offerService.saveOffer(offerDTO);
		return new ResponseEntity<>(savedOfferDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{offerId}")
	public ResponseEntity<OfferDTO> updateOffer(@PathVariable long offerId, @RequestBody OfferDTO offerDTO){
		OfferDTO savedOfferDTO = offerService.updateOffer(offerId, offerDTO);
		return new ResponseEntity<>(savedOfferDTO, HttpStatus.OK);
	}
	
    @DeleteMapping("/remove/{offerId}")
    public ResponseEntity<?> deleteOffer(@PathVariable long offerId) {
            //companyService.deleteCompanyById(id);
            offerService.deleteOfferById(offerId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
	
}
