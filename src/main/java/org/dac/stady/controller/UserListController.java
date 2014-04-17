package org.dac.stady.controller;

import java.security.Principal;
import java.util.HashMap;  
import java.util.Map;  
import org.dac.stady.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;  
  
@Controller  
@RequestMapping(value = "/data/userList", method = RequestMethod.GET)
public class UserListController {  

   @Autowired  
   private UserService userService;   
	

//	it is not neccesary because of relationship:   
//   @ModelAttribute("cities")
//   public Collection<City> populateCities() {
//       return this.cityService.getCityList();
//   }
   
   @RequestMapping(method = RequestMethod.GET)  
   public ModelAndView onInit(Principal principal) {  
        Map<String, Object> model = new HashMap<String, Object>();  
        model.put( "user", userService.getList() );
        
        String name = principal.getName();
		model.put("username", name);
        
        return new ModelAndView("userList", model);  
    }  
}
 