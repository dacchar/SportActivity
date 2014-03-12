package org.dac.stady.domain;  
  
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;  
import javax.persistence.Table;  
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity  
@Table(name = "sportDevices")
@XmlRootElement(name = "sportDevice")
public class SportDevice {  
 
    @Id  
    @GeneratedValue  
    @Column(name = "sportDeviceId")  
    private int SportDeviceId;  
  
	@Column(name = "name")  
    private String name;  


	@XmlElement
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public int getSportDeviceId() {
		return SportDeviceId;
	}

	public void setSportDeviceId(int sportDeviceId) {
		SportDeviceId = sportDeviceId;
	}
}