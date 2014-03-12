package org.dac.stady.domain;  
  
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;  
import javax.persistence.Table;  
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity  
@Table(name = "persons")
@XmlRootElement(name = "person")
public class Person {  
 
    @Id  
    @GeneratedValue  
    @Column(name = "personId")  
    private int personId;  
  

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
	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}
}