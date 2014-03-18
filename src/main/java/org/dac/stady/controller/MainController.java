package org.dac.stady.controller;

import java.security.Principal;
import java.util.HashMap;  
import java.util.Map;  

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;  
  
@Controller  
public class MainController {  
  
   @RequestMapping("/main")  
    public ModelAndView onInit(Principal principal) {  
        Map<String, Object> model = new HashMap<String, Object>();  
        
        if( principal != null ){
	        String name = principal.getName();
			model.put("username", name);
        }
        
        return new ModelAndView("main", model);  
    }  

   @RequestMapping("/Data")  
   public ModelAndView onInitData() {  
       Map<String, Object> model = new HashMap<String, Object>();  
       
       return new ModelAndView("mainData", model);  
   }  

//   @RequestMapping("/DataExpanded")  
//   public ModelAndView onInitDataExpanded() {  
//       Map<String, Object> model = new HashMap<String, Object>();  
//       
//       return new ModelAndView("mainDataExpanded", model);  
//   }  
   
}