package com.server.catalog.controllers;

import java.util.List;

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

import com.server.catalog.DTO.CompanyDTO.CompanyDTO;
import com.server.catalog.services.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

	@Autowired
    private CompanyService companyService;
		
    @GetMapping("/details/{id}")
    public ResponseEntity<CompanyDTO> getCompanyAllDataById(@PathVariable Long id) {
        CompanyDTO companyDTO = companyService.getCompanyAllDataById(id);
        if (companyDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(companyDTO);
    }

    @GetMapping("/all")
    public List<CompanyDTO> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @PostMapping("/save")
    public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO companyDTO) {
    	CompanyDTO savedCompanyDTO = companyService.saveCompany(companyDTO);
		return new ResponseEntity<>(savedCompanyDTO, HttpStatus.CREATED);	
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable Long id, @RequestBody CompanyDTO companyDTO) {
        CompanyDTO updatedCompanyDTO = companyService.updateCompany(id, companyDTO);
        if (updatedCompanyDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCompanyDTO);
    }
	
    
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable long id) {
            companyService.deleteCompanyById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
