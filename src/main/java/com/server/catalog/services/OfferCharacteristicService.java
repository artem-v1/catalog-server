package com.server.catalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.catalog.DTO.CompanyDTO.OfferCharacteristicDTO;
import com.server.catalog.models.Offer;
import com.server.catalog.models.OfferCharacteristic;
import com.server.catalog.repositorys.OfferCharacteristicRepository;
import com.server.catalog.repositorys.OfferRepository;

import jakarta.transaction.Transactional;

@Service
public class OfferCharacteristicService {
	
	@Autowired
	private OfferCharacteristicRepository offerCharacteristicRepository;
	
	@Autowired
	private OfferRepository offerRepository;

	public List<OfferCharacteristicDTO> getAllOfferCharByOfferId(Long offerId) {
		
		Offer offer = offerRepository.findById(offerId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid offerId: " + offerId));
		
		List<OfferCharacteristic> offerCharacteristicsList = offerCharacteristicRepository.findByOffer(offer);
		
		return offerCharacteristicsList.stream()
				.map(offerChar -> convertToDTO(offerChar))
				.collect(Collectors.toList());
	}

	public List<OfferCharacteristicDTO> saveAllOfferCharByOfferId(List<OfferCharacteristicDTO> offerCharDTOList) {

		List<OfferCharacteristic> offerCharList = offerCharDTOList.stream()
				.map(offerCharDTO -> convertToEntity(new OfferCharacteristic(), offerCharDTO))
				.collect(Collectors.toList());
		
		List<OfferCharacteristic> savedOfferCharList = offerCharacteristicRepository.saveAll(offerCharList);
		
		return savedOfferCharList.stream()
				.map(savedOfferChar -> convertToDTO(savedOfferChar))
				.collect(Collectors.toList());
	}
	
	@Transactional
	public List<OfferCharacteristicDTO> updateAllOfferCharByOfferId(List<OfferCharacteristicDTO> offerCharDTOList) {

		Offer offer = offerRepository.findById(offerCharDTOList.get(0).getOfferId())
				.orElseThrow(() -> new IllegalArgumentException("Invalid offerId: " + offerCharDTOList.get(0).getOfferId()));
		
		offerCharacteristicRepository.deleteAllByOffer(offer);
		
		List<OfferCharacteristic> offerCharList = offerCharDTOList.stream()
				.map(offerCharDTO -> convertToEntity(new OfferCharacteristic(), offerCharDTO))
				.collect(Collectors.toList());
		
		List<OfferCharacteristic> savedOfferCharList = offerCharacteristicRepository.saveAll(offerCharList);
		
		return savedOfferCharList.stream()
				.map(savedOfferChar -> convertToDTO(savedOfferChar))
				.collect(Collectors.toList());
	}
	
	private OfferCharacteristicDTO convertToDTO(OfferCharacteristic offerChar) {

		OfferCharacteristicDTO offerCharDTO = new OfferCharacteristicDTO();
		
		offerCharDTO.setOfferCharId(offerChar.getOfferCharId());
		offerCharDTO.setOfferId(offerChar.getOffer().getOfferId());
		offerCharDTO.setCharCategory(offerChar.getCharCategory());
		offerCharDTO.setCharKey(offerChar.getCharKey());
		offerCharDTO.setCharValue(offerChar.getCharValue());
		offerCharDTO.setIcon(offerChar.getIcon());

		return offerCharDTO;
	}

	private OfferCharacteristic convertToEntity(OfferCharacteristic offerChar, OfferCharacteristicDTO offerCharDTO) {
		
		Offer offer = offerRepository.findById(offerCharDTO.getOfferId()).orElseThrow();
		
		offerChar.setOffer(offer);
		offerChar.setCharCategory(offerCharDTO.getCharCategory());
		offerChar.setCharKey(offerCharDTO.getCharKey());
		offerChar.setCharValue(offerCharDTO.getCharValue());
		offerChar.setIcon(offerCharDTO.getIcon());		
		
		return offerChar;
	}

	

	
	

}
