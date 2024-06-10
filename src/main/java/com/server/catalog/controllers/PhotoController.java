package com.server.catalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.catalog.DTO.CompanyDTO.PhotoDTO;
import com.server.catalog.services.PhotoService;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {
	
	@Autowired
	private PhotoService photoService;
	
    @PostMapping("/save")
    public ResponseEntity<List<PhotoDTO>> createPhotos(@RequestBody List<PhotoDTO> photoDTOList) {
    	List<PhotoDTO> allPhotosDTOList = photoService.savePhotos(photoDTOList);
		return new ResponseEntity<>(allPhotosDTOList, HttpStatus.CREATED);	
    }
	
	@GetMapping("/company/{companyId}")
	public ResponseEntity<List<PhotoDTO>> getPhotosByCompanyId(@PathVariable long companyId){
		List<PhotoDTO> photosList = (List<PhotoDTO>) photoService.getPhotosByCompanyId(companyId);
		return new ResponseEntity<List<PhotoDTO>>(photosList, HttpStatus.OK);
	}
	
	@GetMapping("/offer/{offerId}")
	public ResponseEntity<List<PhotoDTO>> getPhotosByOfferId(@PathVariable long offerId){
		List<PhotoDTO> photosList = (List<PhotoDTO>) photoService.getPhotosByOfferId(offerId);
		return new ResponseEntity<List<PhotoDTO>>(photosList, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delPhotoById(@PathVariable long id){
		photoService.deletePhotoById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	

}
