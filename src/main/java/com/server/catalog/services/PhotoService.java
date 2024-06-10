package com.server.catalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.server.catalog.DTO.CompanyDTO.PhotoDTO;
import com.server.catalog.models.Company;
import com.server.catalog.models.Offer;
import com.server.catalog.models.Photo;
import com.server.catalog.repositorys.CompanyRepository;
import com.server.catalog.repositorys.OfferRepository;
import com.server.catalog.repositorys.PhotoRepository;

@Service
public class PhotoService {
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private OfferRepository offerRepository;

	public List<PhotoDTO> getPhotosByCompanyId(long companyId) {
		
		Company company = companyRepository.getReferenceById(companyId);

		List<Photo> photosList = photoRepository.findPhotoByCompany(company);
		List<PhotoDTO> photosDTOList = photosList.stream()
				.map(photo -> convertToDTO(photo))
				.collect(Collectors.toList());

		return photosDTOList;
	}
	
	public List<PhotoDTO> getPhotosByOfferId(long offerId) {
		
		Offer offer = offerRepository.getReferenceById(offerId);

		List<Photo> photosList = photoRepository.findPhotoByOffer(offer);
		List<PhotoDTO> photosDTOList = photosList.stream()
				.map(photo -> convertToDTO(photo))
				.collect(Collectors.toList());

		return photosDTOList;
	}
	
	public List<PhotoDTO> savePhotos(List<PhotoDTO> photoDTOList) {

		List<Photo> photoList = photoDTOList.stream()
				.map(photoDTO -> convertToEntity(new Photo(), photoDTO))
				.collect(Collectors.toList());
		
		List<Photo> savedPhotosList = photoRepository.saveAll(photoList);				
		
		return savedPhotosList
				.stream()
				.map(photo -> convertToDTO(photo))
				.collect(Collectors.toList());
	}

    public void deletePhotoById(long id) {
		if (!photoRepository.existsById(id)) {
	        throw new EmptyResultDataAccessException("No photo found with id: " + id, 1);
	    }
			photoRepository.deleteById(id);
    }

	public PhotoDTO convertToDTO(Photo photo) {
		
		PhotoDTO photoDTO = new PhotoDTO();
		if(photo.getCompany() != null) {
			photoDTO.setCompanyId(photo.getCompany().getCompanyId());
		}
		if(photo.getOffer() != null) {
			photoDTO.setOfferId(photo.getOffer().getOfferId());
		}
		photoDTO.setPhotoId(photo.getPhotoId());
		photoDTO.setPhotoLink(photo.getPhotoLink());
		photoDTO.setPhotoName(photo.getPhotoName());
		
		return photoDTO;
	}
	
	public Photo convertToEntity(Photo photo, PhotoDTO photoDTO) {
		
		if(photoDTO.getCompanyId() != null) {
			Optional<Company> optionalCompany = companyRepository.findById(photoDTO.getCompanyId());
			if(optionalCompany.isPresent()) {
				Company company = optionalCompany.get();
				photo.setCompany(company);

			}
		}
		
		if(photoDTO.getOfferId() != null) {
			Optional<Offer> optionalOffer = offerRepository.findById(photoDTO.getOfferId());
			if(optionalOffer.isPresent()) {
				Offer offer = optionalOffer.get();
				photo.setOffer(offer);
			}
		}

		photo.setPhotoLink(photoDTO.getPhotoLink());
		photo.setPhotoName(photoDTO.getPhotoName());

		return photo;
		
	}

	
}
