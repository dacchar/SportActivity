package org.dac.stady.domain;  
  
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;  
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Lob;

@Entity  
@Table(name = "users")
@XmlRootElement(name = "user")
public class User {  
 
    @Id  
    @Column(name = "USER_ID")  
    private int userId;  
  

	@Column(name = "username")  
    private String username;  

	@Column(name="avatar")
    @Lob
    private byte[] avatar;
			 
	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}
	
	@XmlElement
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@XmlElement
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}