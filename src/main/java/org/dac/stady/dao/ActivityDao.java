package org.dac.stady.dao;  
  
import java.util.List;  

import org.dac.stady.domain.Activity;
  
public interface ActivityDao {  
	public void save(Activity activity);  
	public List<Activity> getActivityList();  
	public Activity getById(Integer id);
	public void remove(Integer id);
}  