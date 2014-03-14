package org.dac.stady.formatter;

import java.util.Locale;
import org.dac.stady.domain.SportDevice;
import org.dac.stady.service.SportDeviceService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;


// bean name "sportDeviceFormatter" used in dispatcher-servlet.xml
@Component
public class SportDeviceFormatter implements Formatter<SportDevice> {
     @Autowired
     private SportDeviceService sportDeviceService; 
     //Some service class which can give the Actor after
     //fetching from Database
 
     @Override
     public String print(SportDevice sportDevice, Locale arg1) {
           return sportDevice.getName().toString();
     }
 
     @Override
      public SportDevice parse(String cityId, Locale arg1) throws java.text.ParseException {
    	 	int id = Integer.parseInt(cityId);
    	 	
    	 	return sportDeviceService.getById(id);
           //Else you can just return a new object by setting some values
           //which you deem fit.
      }

}