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

	private boolean userFiltered = false;
	private User user;
	
	boolean initialized = false;

	public boolean isUserFiltered() {
		return userFiltered;
	}
	
	public void setUserFiltered(boolean userFiltered) {
		this.userFiltered = userFiltered;
	}
	
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
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
