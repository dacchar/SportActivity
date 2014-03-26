package org.dac.stady.service;

import java.util.List;

import org.dac.stady.domain.Activity;
import org.dac.stady.domain.ActivityFilter;

public interface ActivityService {
    public void addActivity(Activity activity);  
    public List<Activity> getActivityList();
    public List<Activity> getActivityList(ActivityFilter activityFilter);
    public Long getCount(ActivityFilter activityFilter);
    public Activity getById(Integer id);
    public void remove(Integer id);
}
