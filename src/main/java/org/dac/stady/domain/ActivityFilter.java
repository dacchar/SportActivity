package org.dac.stady.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ActivityFilter {

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateStart;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateEnd;
	
	private boolean sportDeviceFiltered = false;
	private SportDevice sportDevice;

	private boolean personFiltered = false;
	private Person person;
	
	boolean initialized = false;

	public boolean isPersonFiltered() {
		return personFiltered;
	}
	
	public void setPersonFiltered(boolean personFiltered) {
		this.personFiltered = personFiltered;
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public boolean isInitialized() {
		return initialized;
	}
	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}
	
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	public SportDevice getSportDevice() {
		return sportDevice;
	}
	public void setSportDevice(SportDevice sportDevice) {
		this.sportDevice = sportDevice;
	}
	public boolean isSportDeviceFiltered() {
		return sportDeviceFiltered;
	}
	public void setSportDeviceFiltered(boolean sportDeviceFiltered) {
		this.sportDeviceFiltered = sportDeviceFiltered;
	}
}
