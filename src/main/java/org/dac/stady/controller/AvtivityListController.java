package org.dac.stady.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;  
import java.util.List;
import java.util.Map;  

import javax.validation.Valid;

import org.dac.stady.domain.Activity;
import org.dac.stady.domain.ActivityFilter;
import org.dac.stady.domain.SportDevice;
import org.dac.stady.service.ActivityService;
import org.dac.stady.service.SportDeviceService;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;  
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;  
  
@Controller  
//@SessionAttributes("activityFilter")	// keep the object "activityFilter" save in sessions between GET and PUT/POST
//@SessionAttributes("activity")	// keep the object "activityFilter" save in sessions between GET and PUT/POST
@SessionAttributes( {"activity", "activityFilter" } )	// keep the object "activityFilter" save in sessions between GET and PUT/POST
@RequestMapping(value = "/data/activityList")
public class AvtivityListController {  

	private ActivityFilter activityFilter;
	private String formPage = "activityList";
	private String successPage = "redirect:/data/activityList";
	
   @Autowired  
   private ActivityService activityService;   

   @Autowired  
   private SportDeviceService sportDeviceService;

//   @ModelAttribute("count")
//   public String populateCount() {
//   		return activityService.getCount(activityFilter).toString();
//   }
   
   @ModelAttribute("username")
   public String populateUsername(Principal principal) {
   	return principal.getName();
   }
   
   @ModelAttribute("sportDevices")
   public Collection<SportDevice> populateSportDevices() {
   	List<SportDevice> sportDevices = this.sportDeviceService.getList();
   	return sportDevices;
   }
   
   @InitBinder
   public void setAllowedFields(WebDataBinder dataBinder) {
//	   SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//	   dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
   }
   
	private void createActivityFilter() {
		if(activityFilter == null){
		   activityFilter = new ActivityFilter();
		   		
		   Calendar calendar  = Calendar.getInstance();
		   calendar.set(Calendar.MONTH, 0);
		   calendar.set(Calendar.DAY_OF_MONTH, 1);
		   Date startDate = calendar.getTime();
		   activityFilter.setDateStart(startDate);
		   activityFilter.setDateEnd( new Date() );
		   
		   SportDevice sportDevice = sportDeviceService.getById(1);
		   activityFilter.setSportDevice(sportDevice);
		}
	}
	
   @RequestMapping(method = RequestMethod.GET)  
   public ModelAndView onInit(Principal principal) {
        Map<String, Object> model = new HashMap<String, Object>();  
		
        createActivityFilter();
        
//        model.put( "activity", activityService.getActivityList() );
        model.put( "activity", activityService.getActivityList(activityFilter) );
        model.put( "activityFilter", activityFilter );

        Long count = activityService.getCount(activityFilter);
        model.put( "count", count );

        return new ModelAndView("activityList", model);  
    }  
 
	@RequestMapping( method = { RequestMethod.POST } )
	public String onSubmit(@Valid @ModelAttribute("activityFilter") ActivityFilter activityFilter, BindingResult result) 
	{
		if (result.hasErrors()) {
			return formPage;
		}
		
//        String name = principal.getName();
//		model.put("username", name);
//		
//		model.put( "activity", activityService.getActivityList() );
		

		return successPage;
	}
	
   
}
 