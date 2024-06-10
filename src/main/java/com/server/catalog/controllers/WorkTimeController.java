package com.server.catalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.catalog.DTO.CompanyDTO.WorkTimeDTO;
import com.server.catalog.services.WorkTimeService;

@RestController
@RequestMapping("/api/work-time")
public class WorkTimeController {

	@Autowired
	private WorkTimeService workTimeService;
	
	@GetMapping("/company/{companyId}")
	public ResponseEntity<List<WorkTimeDTO>> getWorkTimesByCompanyId(@PathVariable long companyId){
		List<WorkTimeDTO> workTimeDTOList = (List<WorkTimeDTO>) workTimeService.getWorkTimesByCompanyId(companyId);
		return new ResponseEntity<List<WorkTimeDTO>>(workTimeDTOList, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<List<WorkTimeDTO>> getWorkTimeByCompanyId(@RequestBody List<WorkTimeDTO> workTimeDTOList){
		List<WorkTimeDTO> savedWorkTimeDTOList = (List<WorkTimeDTO>) workTimeService.saveWorkTimesByCompanyId(workTimeDTOList);
		return new ResponseEntity<List<WorkTimeDTO>>(savedWorkTimeDTOList, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<List<WorkTimeDTO>> updatePriceByCompanyId(@RequestBody List<WorkTimeDTO> priceDTOList){
		List<WorkTimeDTO> savedWorkTimeDTOList = (List<WorkTimeDTO>) workTimeService.updateWorkTimeList(priceDTOList);
		return new ResponseEntity<List<WorkTimeDTO>>(savedWorkTimeDTOList, HttpStatus.OK);
	}
}
