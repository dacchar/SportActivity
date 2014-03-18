package org.dac.stady.controller;

import java.security.Principal;
import java.util.HashMap;  
import java.util.Map;  

import org.dac.stady.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;  
  
@Controller  
@RequestMapping(value = "/data/activityList", method = RequestMethod.GET)
public class AvtivityListController {  

   @Autowired  
   private ActivityService activityService;   
	
   @RequestMapping(method = RequestMethod.GET)  
   public ModelAndView onInit(Principal principal) {
        Map<String, Object> model = new HashMap<String, Object>();  
		
        String name = principal.getName();
		model.put("username", name);
		
        model.put( "activity", activityService.getActivityList() );

        return new ModelAndView("activityList", model);  
    }  
   
}
 