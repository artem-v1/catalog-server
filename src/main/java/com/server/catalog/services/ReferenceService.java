package com.server.catalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.catalog.DTO.ReferenceDTO;
import com.server.catalog.models.Reference;
import com.server.catalog.repositorys.referenceRepository;

@Service
public class ReferenceService {

	@Autowired
	private referenceRepository referenceRepository;

	public String getReferenceValueByKey(String key) {
		return referenceRepository.findReferenceByKey(key);
	}
	
	public List<ReferenceDTO> getAllReferences() {
		List<Reference> references = referenceRepository.findAll();
		
		List<ReferenceDTO> ReferenceDTOList = references.stream()
				.map(ref -> convertToDTO(ref))
				.collect(Collectors.toList());
		
		return ReferenceDTOList;
	}
	

	public ReferenceDTO convertToDTO(Reference reference) {
		
		ReferenceDTO referenceDTO = new ReferenceDTO();
		
		referenceDTO.setReferenceId(reference.getReferenceId());
		referenceDTO.setScope(reference.getScope());
		referenceDTO.setKey(reference.getKey());
		referenceDTO.setValue(reference.getValue());
		referenceDTO.setIcon(reference.getIcon());
		referenceDTO.setSortOrder(reference.getSortOrder());

		return referenceDTO;
	}

//	public List<Reference> saveCategoryDTOList(List<CategoryDtoTEMP> categoryDtoList) {
//		
//		List<Reference> referenceList = categoryDtoList.stream()
//				.map(category -> convertCategoryToEntity(category))
//				.collect(Collectors.toList());
//		
//		List<Reference> savedReferenceList = referenceRepository.saveAll(referenceList);
//		
//		return savedReferenceList;
//	}
//
//	private Reference convertCategoryToEntity(CategoryDtoTEMP category) {
//
//		Reference reference = new Reference();
//		
//		reference.setKey(category.getCatKey());
//		reference.setValue(category.getCatValue());
//		reference.setSortOrder(category.getOrder());
//		
//		reference.setScope("company_charact_category");
//		
//		return reference;
//	}
//
//	public List<Reference> saveCharDTOList(List<СharacteristicDtoTEMP> charDtoList) {
//
//		List<Reference> referenceList = charDtoList.stream()
//				.map(charact -> convertCharToEntity(charact))
//				.collect(Collectors.toList());
//		
//		List<Reference> savedReferenceList = referenceRepository.saveAll(referenceList);
//		
//		return savedReferenceList;
//	}
//
//	private Reference convertCharToEntity(СharacteristicDtoTEMP charact) {
//
//		Reference reference = new Reference();
//
//		reference.setKey(charact.getCharKey());
//		reference.setValue(charact.getCharValue());
//		reference.setIcon(charact.getIcon());
//		
//		reference.setScope("company_cgaracteristic");
//
//		return reference;
//	}
	
	
}
