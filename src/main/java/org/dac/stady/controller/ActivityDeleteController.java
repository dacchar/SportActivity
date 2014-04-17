package org.dac.stady.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;  

import org.dac.stady.domain.Activity;
import org.dac.stady.domain.ActivityType;
import org.dac.stady.domain.User;
import org.dac.stady.domain.SportDevice;
import org.dac.stady.service.ActivityService;
import org.dac.stady.service.ActivityTypeService;
import org.dac.stady.service.PersonService;
import org.dac.stady.service.SportDeviceService;
import org.dac.stady.service.UserService;
import org.dac.stady.validator.EditActivityValidator;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.beans.propertyeditors.CustomDateEditor;
//import org.springframework.context.MessageSource;
//import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;  
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


  
@Controller
@SessionAttributes("activity")	// keep the object "activity" save in sessions between GET and PUT/POST
@RequestMapping("/data/activityList")
public class ActivityDeleteController {  
	
	private String formPage = "deleteActivity";
	private String successPage = "redirect:/data/activityList";
  
	
    @Autowired  
    private ActivityService activityService;  

    @Autowired  
    private ActivityTypeService activityTypeService;  

    @Autowired  
    private UserService userService;  

    @Autowired  
    private SportDeviceService sportDeviceService;  
	
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
    	// for security reason, the user can change the id, it is not allowed:
        dataBinder.setDisallowedFields("activityId");

        // format data in jsp:
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
        // done in dispacher servlet:
        //dataBinder.setConversionService(conversionService);
    }

    @ModelAttribute("activityTypes")
    public Collection<ActivityType> populateActivities() {
        return this.activityTypeService.getActivityTypeList();
    }

    @ModelAttribute("users")
    public Collection<User> populateUsers() {
        return this.userService.getList();
    }

    @ModelAttribute("sportDevices")
    public Collection<SportDevice> populateSportDevices() {
    	List<SportDevice> sportDevices = this.sportDeviceService.getList();
    	return sportDevices;
    }
    
    @ModelAttribute("username")
    public String populateUsername(Principal principal) {
    	return principal.getName();
    }
    
	@RequestMapping(value = "/{Id}/delete", method = RequestMethod.GET)
	public String onInit(@PathVariable("Id") Integer Id, Map<String, Object> map, Locale locale) {
		Activity activity = activityService.getById(Id);
		map.put("activity", activity);
		
		return formPage;
	}
	
	@RequestMapping( value = "{Id}/delete", method = { RequestMethod.DELETE, RequestMethod.POST } )
	public String onSubmit(@ModelAttribute("activity") Activity activity, BindingResult result) 
	{
		activityService.remove( activity.getActivityId() );

		return successPage;
	}
	
}