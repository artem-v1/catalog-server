package com.server.catalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.server.catalog.DTO.CompanyDTO.CompanyCharacteristicDTO;
import com.server.catalog.DTO.CompanyDTO.CompanyDTO;
import com.server.catalog.models.Company;
import com.server.catalog.repositorys.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private CompanyCharacteristicService companyCharService;
	
	@Autowired
	private OfferService offerService;
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private PriceService priceService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private WorkTimeService workTimeService;

	public CompanyDTO getCompanyAllDataById(Long id) {
		Company companyAllData = companyRepository.findById(id).orElse(null);
		if (companyAllData == null) {
			return null;
		}
		return convertToDTO(companyAllData);
	}
	
	public CompanyDTO getCompanyById(Long id) {
		Company company = companyRepository.findById(id).orElse(null);
		if (company == null) {
			return null;
		}
		return convertToDTO(company);
	}

	public List<CompanyDTO> getAllCompanies() {
		List<Company> companies = companyRepository.findAll();
		return companies.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	public CompanyDTO saveCompany(CompanyDTO companyDTO) {
		Company company = new Company();
		company = convertToEntity(company, companyDTO);
		Company savedCompany = companyRepository.save(company);
		return convertToDTO(savedCompany);
	}

	public CompanyDTO updateCompany(Long id, CompanyDTO companyDTO) {
		Company existingCompany = companyRepository.findById(id).orElse(null);
		if (existingCompany != null) {

			existingCompany = convertToEntity(existingCompany, companyDTO);
			Company updatedCompany = companyRepository.save(existingCompany);

			return convertToDTO(updatedCompany);
		}
		return null;
	}

	private CompanyDTO convertToDTO(Company company) {
		
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setCompanyId(company.getCompanyId());
		companyDTO.setTitle(company.getTitle());
		companyDTO.setDescription(company.getDescription());
		companyDTO.setPhone(company.getPhone());
		companyDTO.setEmail(company.getEmail());
		companyDTO.setStreet(company.getStreet());
		companyDTO.setHouse(company.getHouse());
		companyDTO.setCity(company.getCity());
		companyDTO.setLand(company.getLand());
		companyDTO.setPostCode(company.getPostCode());
		companyDTO.setLatitude(company.getLatitude());
		companyDTO.setLongitude(company.getLongitude());
		
		companyDTO.setCompanyCharacteristics(companyCharService.getCompanyCharacteristicsByCompanyId(company.getCompanyId()));
		companyDTO.setOffers(offerService.findOffersByCompanyId(company.getCompanyId()));
		companyDTO.setPhotos(photoService.getPhotosByCompanyId(company.getCompanyId()));
		companyDTO.setPrices(priceService.getPriceByCompanyId(company.getCompanyId()));
		companyDTO.setReviews(reviewService.getReviewsByCompanyId(company.getCompanyId()));
		companyDTO.setWorkTimes(workTimeService.getWorkTimesByCompanyId(company.getCompanyId()));
			
		return companyDTO;
	}

	private Company convertToEntity(Company company, CompanyDTO companyDTO) {

		company.setTitle(companyDTO.getTitle());
		company.setDescription(companyDTO.getDescription());
		company.setPhone(companyDTO.getPhone());
		company.setEmail(companyDTO.getEmail());
		company.setStreet(companyDTO.getStreet());
		company.setHouse(companyDTO.getHouse());
		company.setCity(companyDTO.getCity());
		company.setLand(companyDTO.getLand());
		company.setPostCode(companyDTO.getPostCode());
		company.setLatitude(companyDTO.getLatitude());
		company.setLongitude(companyDTO.getLongitude());

		return company;
	}

	public void deleteCompanyById(long id) {
		if (!companyRepository.existsById(id)) {
			throw new EmptyResultDataAccessException("No offer found with id: " + id, 1);
		}
		companyRepository.deleteById(id);

	}

}
