package org.dac.stady.formatter;

import java.util.Locale;
import org.dac.stady.domain.Person;
import org.dac.stady.service.PersonService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;


// bean name "cityFormatter" used in dispatcher-servlet.xml
@Component
public class PersonFormatter implements Formatter<Person> {
     @Autowired
     private PersonService personService; 
     //Some service class which can give the Actor after
     //fetching from Database
 
     @Override
     public String print(Person person, Locale arg1) {
           return person.getName().toString();
     }
 
     @Override
      public Person parse(String cityId, Locale arg1) throws java.text.ParseException {
    	 	int id = Integer.parseInt(cityId);
    	 	
    	 	return personService.getById(id);
           //Else you can just return a new object by setting some values
           //which you deem fit.
      }

}