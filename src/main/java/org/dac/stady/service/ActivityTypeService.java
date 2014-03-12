package org.dac.stady.service;

import java.util.List;

import org.dac.stady.domain.ActivityType;

public interface ActivityTypeService {
    public void add(ActivityType activityType);  
    public List<ActivityType> getActivityTypeList();
    public ActivityType getById(Integer id);
    public void remove(Integer id);
}
