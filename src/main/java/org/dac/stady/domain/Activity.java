package org.dac.stady.domain;  
  
//import java.sql.Date;
import java.util.Date;
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;  
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;  
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity  
@Table(name = "activities")
@XmlRootElement(name = "activity")
public class Activity {  
 
    @Id  
    @GeneratedValue  
    @Column(name = "activityId")  
    private int activityId;  
  
	@ManyToOne
    @JoinColumn(name="activityTypeId")
    private ActivityType activityType;

	@ManyToOne
    @JoinColumn(name="personId")
    private Person person;

	@ManyToOne
    @JoinColumn(name="sportDeviceId")
    private SportDevice sportDevice;
	
	@Column(name = "activityDate")  
    private Date activityDate;  
    

    public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}
	
    @XmlElement
    public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	@Column(name = "amount")  
    private Integer amount;  
    
  
    @XmlElement
    public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@XmlElement
    public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	@XmlElement
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@XmlElement
	public SportDevice getSportDevice() {
		return sportDevice;
	}

	public void setSportDevice(SportDevice sportDevice) {
		this.sportDevice = sportDevice;
	}
}