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
	
	public List<ReferenceDTO> saveReferences(List<ReferenceDTO> refDTOList){
		
		List<Reference> refList = refDTOList.stream()
				.map(refDTO -> convertToEntity(refDTO))
				.collect(Collectors.toList());
		
		List<Reference> savedReferences = referenceRepository.saveAll(refList);
		
		return savedReferences.stream()
				.map(ref -> convertToDTO(ref))
				.collect(Collectors.toList());
		
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
	
	public Reference convertToEntity(ReferenceDTO refDTO) {
		
		Reference ref = new Reference();
		
		ref.setReferenceId(refDTO.getReferenceId());
		ref.setScope(refDTO.getScope());
		ref.setKey(refDTO.getKey());
		ref.setValue(refDTO.getValue());
		ref.setIcon(ref.getIcon());
		ref.setSortOrder(refDTO.getSortOrder());
		
		return ref;
	}	
	
}
