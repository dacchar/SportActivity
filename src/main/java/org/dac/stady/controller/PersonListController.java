package org.dac.stady.controller;

import java.util.HashMap;  
import java.util.Map;  
import org.dac.stady.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;  
  
@Controller  
@RequestMapping(value = "/personList", method = RequestMethod.GET)
public class PersonListController {  

   @Autowired  
   private PersonService personService;   
	

//	it is not neccesary because of relationship:   
//   @ModelAttribute("cities")
//   public Collection<City> populateCities() {
//       return this.cityService.getCityList();
//   }
   
   @RequestMapping(method = RequestMethod.GET)  
   public ModelAndView onInit() {  
        Map<String, Object> model = new HashMap<String, Object>();  
        model.put( "person", personService.getList() );
        
        return new ModelAndView("personList", model);  
    }  
}
 