package org.dac.stady.service;

import java.util.List;
import org.dac.stady.dao.ActivityDao;
import org.dac.stady.domain.Activity;
import org.dac.stady.domain.ActivityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service  
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)  
public class ActivityServiceImpl implements ActivityService {

    @Autowired  
    ActivityDao activityDao;  
	
	@Override
	public void addActivity(Activity activity) {
		activityDao.save(activity);
	}

	@Override
	public List<Activity> getActivityList() {
		return activityDao.getActivityList(); 
	}
	
	
	@Override
	public List<Activity> getActivityList(ActivityFilter activityFilter) {
		return activityDao.getActivityList(activityFilter); 
	}

	@Override
	public Activity getById(Integer id) {
		return activityDao.getById(id);
	}

	@Override
	public void remove(Integer id) {
		activityDao.remove(id);
	}
}
