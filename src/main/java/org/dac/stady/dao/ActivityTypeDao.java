package org.dac.stady.dao;  
  
import java.util.List;  
import org.dac.stady.domain.ActivityType;
  
public interface ActivityTypeDao {  
	public void save(ActivityType activityType);  
	public List<ActivityType> getActivityTypeList();  
	public ActivityType getById(Integer id);
	public void remove(Integer id);
}  