package com.server.catalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.server.catalog.DTO.CompanyDTO.PriceDTO;
import com.server.catalog.models.Company;
import com.server.catalog.models.Price;
import com.server.catalog.repositorys.CompanyRepository;
import com.server.catalog.repositorys.PriceRepository;

import jakarta.transaction.Transactional;

@Service
public class PriceService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private PriceRepository priceRepository;

	public List<PriceDTO> getPriceByCompanyId(long companyId) {

		Company company = companyRepository.getReferenceById(companyId);

		List<Price> priceList = priceRepository.findPriceByCompany(company);
		List<PriceDTO> priceDTOList = priceList.stream().map(price -> convertToDTO(price)).collect(Collectors.toList());

		return priceDTOList;
	}

	public List<PriceDTO> savePriceList(List<PriceDTO> priceDTOList) {

		List<Price> priceList = priceDTOList.stream()
				.map(priceDTO -> convertToEntity(new Price(), priceDTO))
				.collect(Collectors.toList());

		List<Price> savedPriceList = priceRepository.saveAll(priceList);

		return savedPriceList.stream().map(savedPrice -> convertToDTO(savedPrice)).collect(Collectors.toList());
	}

	@Transactional
	public List<PriceDTO> updatePriceList(List<PriceDTO> priceDTOList) {

		// delete all by company
		Company company = companyRepository.findById(priceDTOList.get(0).getCompanyId()).orElseThrow();
		priceRepository.deleteAllByCompany(company);

		List<Price> priceList = priceDTOList.stream()
				.map(priceDTO -> convertToEntity(new Price(), priceDTO))
				.collect(Collectors.toList());

		List<Price> savedPriceList = priceRepository.saveAll(priceList);

		return savedPriceList.stream().map(savedPrice -> convertToDTO(savedPrice)).collect(Collectors.toList());
	}

	public void deletePriceById(long id) {
		if (!priceRepository.existsById(id)) {
			throw new EmptyResultDataAccessException("No price found with id: " + id, 1);
		}
		priceRepository.deleteById(id);
	}
	
	private Price convertToEntity(Price price, PriceDTO priceDTO) {

		Company company = companyRepository.findById(priceDTO.getCompanyId()).orElseThrow();

		price.setCompany(company);
		price.setInfo(priceDTO.getInfo());
		price.setName(priceDTO.getName());
		price.setPrice(priceDTO.getPrice());
		price.setUnit(priceDTO.getUnit());

		return price;
	}

	private PriceDTO convertToDTO(Price price) {

		PriceDTO priceDTO = new PriceDTO();

		priceDTO.setPriceId(price.getPriceId());
		priceDTO.setCompanyId(price.getCompany().getCompanyId());
		priceDTO.setName(price.getName());
		priceDTO.setPrice(price.getPrice());
		priceDTO.setUnit(price.getUnit());
		priceDTO.setInfo(price.getInfo());

		return priceDTO;
	}

}
