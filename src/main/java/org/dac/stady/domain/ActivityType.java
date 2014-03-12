package org.dac.stady.domain;  
  
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;  
import javax.persistence.Table;  
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity  
@Table(name = "activityTypes")
@XmlRootElement(name = "activityType")
public class ActivityType {  
 
    @Id  
    @GeneratedValue  
    @Column(name = "activityTypeId")  
    private int activityTypeId;  
  
    @Column(name = "name")  
    private String Name;  
  
  
    @XmlElement
    public int getActivityTypeId() {  
        return activityTypeId;  
    }  
  
    public void setIdActivityType(int id) {  
        this.activityTypeId = id;  
    }  
  
    @XmlElement
    public String getName() {  
        return Name;  
    }  
  
    public void setName(String Name) {  
        this.Name = Name;  
    }  
}