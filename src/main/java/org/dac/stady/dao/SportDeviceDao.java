package org.dac.stady.dao;  
  
import java.util.List;  

import org.dac.stady.domain.Person;
import org.dac.stady.domain.SportDevice;
  
public interface SportDeviceDao {  
	public void save(SportDevice sportDevice);  
	public List<SportDevice> getList();  
	public SportDevice getById(Integer id);
	public void remove(Integer id);
}  