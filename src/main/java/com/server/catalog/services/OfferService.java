package com.server.catalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.server.catalog.DTO.CompanyDTO.CompanyCharacteristicDTO;
import com.server.catalog.DTO.CompanyDTO.OfferDTO;
import com.server.catalog.models.Company;
import com.server.catalog.models.Offer;
import com.server.catalog.repositorys.CompanyRepository;
import com.server.catalog.repositorys.OfferRepository;

@Service
public class OfferService {

	@Autowired
	private OfferRepository offerRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private OfferCharacteristicService offerCharService;
	
	@Autowired
	private PhotoService photoService;
	
	public OfferDTO saveOffer(OfferDTO offerDTO) {
		
    	Offer offer = new Offer();
    	offer = convertToEntity(offer, offerDTO);
    	Offer savedOffer = offerRepository.save(offer);
    	return convertToDTO(savedOffer);
	}
	
	public OfferDTO updateOffer(long offerId, OfferDTO offerDTO) {

		Offer offer = offerRepository.findById(offerId).orElseThrow();
		offer = convertToEntity(offer, offerDTO);
		Offer savedOffer = offerRepository.save(offer);
		return convertToDTO(savedOffer);
	}
	
	private OfferDTO convertToDTO(Offer offer) {

		OfferDTO offerDTO = new OfferDTO();
		
		offerDTO.setOfferId(offer.getOfferId());
	    offerDTO.setCompanyId(offer.getCompany().getCompanyId());
	    offerDTO.setTitle(offer.getTitle());
	    offerDTO.setType(offer.getType());
	    offerDTO.setCategoryOffer(offer.getCategoryOffer());
	    offerDTO.setDescription(offer.getDescription());
	    
	    offerDTO.setOfferCharacteristics(offerCharService.getAllOfferCharByOfferId(offer.getOfferId()));
	    offerDTO.setPhotoOffers(photoService.getPhotosByOfferId(offer.getOfferId()));
		
		return offerDTO;
	}

	
	private Offer convertToEntity(Offer offer, OfferDTO offerDTO) {
		
		// getReference without full upload
		Company company = companyRepository.getReferenceById(offerDTO.getCompanyId());
	   
	    offer.setCompany(company);	
		offer.setTitle(offerDTO.getTitle());
		offer.setType(offerDTO.getType());
	    offer.setCategoryOffer(offerDTO.getCategoryOffer());
	    offer.setDescription(offerDTO.getDescription());
		
		return offer;
	}

	public void deleteOfferById(long offerId) {

		if (!offerRepository.existsById(offerId)) {
	        throw new EmptyResultDataAccessException("No offer found with id: " + offerId, 1);
	    }
    	offerRepository.deleteById(offerId);

	}

	public OfferDTO findOfferById(long offerId) {
		Offer offer = offerRepository.findById(offerId).orElseThrow();
		OfferDTO offerDTO = convertToDTO(offer);
		return offerDTO;
	}
	
	public List<OfferDTO> findOffersByCompanyId(long companyId) {
		Company company = companyRepository.findById(companyId)
    			.orElseThrow(() -> new IllegalArgumentException("Invalid companyId: " + companyId));
		
		List<Offer> allCompanyOffers = offerRepository.findByCompany(company);
		
		List<OfferDTO> allCompanyOffersDTOList = allCompanyOffers.stream()
				.map(offer -> convertToDTO(offer))
				.collect(Collectors.toList());
	
		return allCompanyOffersDTOList;
	}

}
