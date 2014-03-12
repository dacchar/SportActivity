package org.dac.stady.service;

import java.util.List;
import org.dac.stady.domain.Activity;

public interface ActivityService {
    public void addActivity(Activity activity);  
    public List<Activity> getActivityList();
    public Activity getById(Integer id);
    public void remove(Integer id);
}
