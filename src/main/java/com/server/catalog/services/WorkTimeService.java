package com.server.catalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.catalog.DTO.CompanyDTO.WorkTimeDTO;
import com.server.catalog.models.Company;
import com.server.catalog.models.WorkTime;
import com.server.catalog.repositorys.CompanyRepository;
import com.server.catalog.repositorys.WorkTimeRepository;

import jakarta.transaction.Transactional;

@Service
public class WorkTimeService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private WorkTimeRepository workTimeRepository;

	public List<WorkTimeDTO> getWorkTimesByCompanyId(long companyId) {
		
		Company company = companyRepository.findById(companyId).orElseThrow();
		
		List<WorkTime> workTimeList = workTimeRepository.findByCompany(company);
		
		return workTimeList.stream()
				.map(workTime -> convertToDTO(workTime))
				.collect(Collectors.toList());
	}
	

	public List<WorkTimeDTO> saveWorkTimesByCompanyId(List<WorkTimeDTO> workTimeDTOList) {
		List<WorkTime> workTimeList = workTimeDTOList.stream()
				.map(workTimeDTO -> convertToEntity(new WorkTime(), workTimeDTO))
				.collect(Collectors.toList());

		List<WorkTime> savedWorkTimeList = workTimeRepository.saveAll(workTimeList);

		return savedWorkTimeList.stream()
				.map(workTime -> convertToDTO(workTime))
				.collect(Collectors.toList());
	}
	
	@Transactional
	public List<WorkTimeDTO> updateWorkTimeList(List<WorkTimeDTO> workTimeDTOList) {

		Company company = companyRepository.findById(workTimeDTOList.get(0).getCompanyId()).orElseThrow();
		workTimeRepository.deleteByCompany(company);
		
		List<WorkTime> workTimeList = workTimeDTOList.stream()
				.map(workTimeDTO -> convertToEntity(new WorkTime(), workTimeDTO))
				.collect(Collectors.toList());
		
		List<WorkTime> savedWorkTimeList = workTimeRepository.saveAll(workTimeList);
		
		
		return savedWorkTimeList.stream()
				.map(workTime -> convertToDTO(workTime))
				.collect(Collectors.toList());
	}
	

	private WorkTime convertToEntity(WorkTime workTime, WorkTimeDTO workTimeDTO) {

		Company company = companyRepository.findById(workTimeDTO.getCompanyId()).orElseThrow();
		
		workTime.setCompany(company);
		workTime.setDayOfWeek(workTimeDTO.getDayOfWeek());
		workTime.setEndTime(workTimeDTO.getEndTime());
		workTime.setNote(workTimeDTO.getNote());
		workTime.setStartTime(workTimeDTO.getStartTime());
		workTime.setWorkTimeId(workTimeDTO.getWorkTimeId());
		
		return workTime;
	}


	private WorkTimeDTO convertToDTO(WorkTime workTime) {
		
		WorkTimeDTO workTimeDTO = new WorkTimeDTO();
		
		workTimeDTO.setWorkTimeId(workTime.getWorkTimeId());
		workTimeDTO.setCompanyId(workTime.getCompany().getCompanyId());
		workTimeDTO.setDayOfWeek(workTime.getDayOfWeek());
		workTimeDTO.setStartTime(workTime.getStartTime());
		workTimeDTO.setEndTime(workTime.getEndTime());
		workTimeDTO.setNote(workTime.getNote());

		return workTimeDTO;
	}

}
