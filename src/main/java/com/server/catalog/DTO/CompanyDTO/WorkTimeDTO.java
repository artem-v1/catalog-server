package com.server.catalog.DTO.CompanyDTO;

import java.io.Serializable;
import java.sql.Time;

public class WorkTimeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6076304762306225093L;
	
	private Long workTimeId;
	private Long companyId;
	private String dayOfWeek;
	private Time startTime;
	private Time endTime;
	private String note;

	public WorkTimeDTO() {
	}

	public WorkTimeDTO(Long companyId, String dayOfWeek, Time startTime, Time endTime, String note) {
		super();
		this.companyId = companyId;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.note = note;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public void setWorkTimeId(Long workTimeId) {
		this.workTimeId = workTimeId;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getWorkTimeId() {
		return workTimeId;
	}

}
