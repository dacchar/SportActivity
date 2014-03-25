package org.dac.stady.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ActivityFilter {

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateStart;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateEnd;
	
	
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
}
