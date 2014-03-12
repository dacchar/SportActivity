package org.dac.stady.formatter;

import java.util.Locale;
import org.dac.stady.domain.ActivityType;
import org.dac.stady.service.ActivityTypeService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;


// bean name "cityFormatter" used in dispatcher-servlet.xml
@Component
public class ActivityTypeFormatter implements Formatter<ActivityType> {
     @Autowired
     private ActivityTypeService activityTypeService;
     //Some service class which can give the Actor after
     //fetching from Database
 
     @Override
     public String print(ActivityType activityType, Locale arg1) {
           return activityType.getName().toString();
     }
 
     @Override
      public ActivityType parse(String cityId, Locale arg1) throws java.text.ParseException {
    	 	int id = Integer.parseInt(cityId);
    	 	
    	 	return activityTypeService.getById(id);
           //Else you can just return a new object by setting some values
           //which you deem fit.
      }

}