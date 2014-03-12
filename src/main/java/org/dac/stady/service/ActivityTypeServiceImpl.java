package org.dac.stady.service;

import java.util.List;
import org.dac.stady.dao.ActivityTypeDao;
import org.dac.stady.domain.ActivityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service  
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)  
public class ActivityTypeServiceImpl implements ActivityTypeService {

    @Autowired  
    ActivityTypeDao activityTypeDao;  
	
	@Override
	public void add(ActivityType activityType) {
		activityTypeDao.save(activityType);
	}

	@Override
	public List<ActivityType> getActivityTypeList() {
		return activityTypeDao.getActivityTypeList(); 
	}

	@Override
	public ActivityType getById(Integer id) {
		return activityTypeDao.getById(id);
	}

	@Override
	public void remove(Integer id) {
		activityTypeDao.remove(id);
	}
}
