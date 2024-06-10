package com.server.catalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.catalog.DTO.CompanyDTO.CompanyCharacteristicDTO;
import com.server.catalog.models.Company;
import com.server.catalog.models.CompanyCharacteristic;
import com.server.catalog.repositorys.CompanyCharacteristicRepository;
import com.server.catalog.repositorys.CompanyRepository;

import jakarta.transaction.Transactional;


@Service
public class CompanyCharacteristicService {

    @Autowired
    private CompanyCharacteristicRepository companyCharacteristicRepository;
	
    @Autowired
    private CompanyRepository companyRepository;
    
	public List<CompanyCharacteristicDTO> getCompanyCharacteristicsByCompanyId(long companyId) {

    	Company company = companyRepository.findById(companyId)
    			.orElseThrow(() -> new IllegalArgumentException("Invalid companyId: " + companyId));
    
    	List<CompanyCharacteristic> companyCharacteristicsList = companyCharacteristicRepository.findByCompany(company);
    	
		List<CompanyCharacteristicDTO> companyCharacteristicsDTOList = companyCharacteristicsList.stream()
				.map(comChar -> convertToDTO(comChar))
				.collect(Collectors.toList());
		return companyCharacteristicsDTOList;
	}
    
	 public List<CompanyCharacteristicDTO> saveCharacteristics(List<CompanyCharacteristicDTO> characteristicsDTOList) {
		 
		 List<CompanyCharacteristic> characteristicsList = characteristicsDTOList.stream()
				    .map(dto -> convertToEntity(new CompanyCharacteristic(), dto))
				    .collect(Collectors.toList());
	        
		 List<CompanyCharacteristic> savedCharacteristics = companyCharacteristicRepository.saveAll(characteristicsList);

		 return savedCharacteristics.stream()
	                                   .map(this::convertToDTO)
	                                   .collect(Collectors.toList());
	 }

	 @Transactional
	 public List<CompanyCharacteristicDTO> updateCompanyCharacteristics(List<CompanyCharacteristicDTO> characteristicsDTOList) {
	        
	        Long companyId = characteristicsDTOList.get(0).getCompanyId();
	        Company company = companyRepository.findById(companyId).orElseThrow(() -> new IllegalArgumentException("Invalid company ID: " + companyId));
	  
	        
	        companyCharacteristicRepository.deleteByCompany(company);
	                
	        List<CompanyCharacteristic> characteristicsList = characteristicsDTOList.stream()
	                .map(dto -> convertToEntity(new CompanyCharacteristic(), dto))
	                .collect(Collectors.toList());

	        List<CompanyCharacteristic> savedCharacteristics = companyCharacteristicRepository.saveAll(characteristicsList);

	        return savedCharacteristics.stream()
	                                   .map(this::convertToDTO)
	                                   .collect(Collectors.toList());

	    }
	 

	private CompanyCharacteristicDTO convertToDTO(CompanyCharacteristic updatedCompanyChar) {
		
		CompanyCharacteristicDTO companyCharacteristicDTO = new CompanyCharacteristicDTO();
		
		companyCharacteristicDTO.setComCharId(updatedCompanyChar.getComCharId());
		companyCharacteristicDTO.setCompanyId(updatedCompanyChar.getCompany().getCompanyId());
		companyCharacteristicDTO.setCharCategory(updatedCompanyChar.getCharCategory());
		companyCharacteristicDTO.setCharKey(updatedCompanyChar.getCharKey());
		companyCharacteristicDTO.setIcon(updatedCompanyChar.getIcon());
		//companyCharacteristicDTO.setCharValue(updatedCompanyChar.getCharValue());
		
		return companyCharacteristicDTO;
	}

	private CompanyCharacteristic convertToEntity(CompanyCharacteristic companyChar,
			CompanyCharacteristicDTO companyCharacteristicDTO) {
		
		Company company = companyRepository.findById(companyCharacteristicDTO.getCompanyId()).orElseThrow();
	   
		companyChar.setCompany(company);			    
		companyChar.setCharCategory(companyCharacteristicDTO.getCharCategory());
		companyChar.setCharKey(companyCharacteristicDTO.getCharKey());
		//companyChar.setCharValue(companyCharacteristicDTO.getCharValue());
		companyChar.setIcon(companyCharacteristicDTO.getIcon());
		
		return companyChar;
	}

}

	
	
