package org.dac.stady.formatter;

import java.util.Locale;
import org.dac.stady.domain.User;
import org.dac.stady.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;


// bean name "userFormatter" used in dispatcher-servlet.xml
@Component
public class UserFormatter implements Formatter<User> {
     @Autowired
     private UserService userService; 
     //Some service class which can give the Actor after
     //fetching from Database
 
     @Override
     public String print(User user, Locale arg1) {
           return user.getUsername().toString();
     }
 
     @Override
      public User parse(String personId, Locale arg1) throws java.text.ParseException {
    	 	int id = Integer.parseInt(personId);
    	 	
    	 	return userService.getById(id);
           //Else you can just return a new object by setting some values
           //which you deem fit.
      }

}