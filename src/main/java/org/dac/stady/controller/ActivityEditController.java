package org.dac.stady.controller;

import javax.validation.Valid;
import java.sql.Time;
import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;  
import org.dac.stady.domain.Activity;
import org.dac.stady.domain.ActivityType;
import org.dac.stady.domain.SportDevice;
import org.dac.stady.domain.User;
import org.dac.stady.service.ActivityService;
import org.dac.stady.service.ActivityTypeService;
import org.dac.stady.service.SportDeviceService;
import org.dac.stady.service.UserService;
import org.dac.stady.validator.EditActivityValidator;
import org.springframework.beans.factory.annotation.Autowired;  
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
public class ActivityEditController {  
	
	private String formPage = "editActivity";
//	private String successPage = "redirect:/data/activityList";
	private String successPage = "redirect:/data/activityList?page=1";
  
//	@Autowired
//	private ConversionService conversionService;
	
    @Autowired  
    private ActivityService activityService;  

    @Autowired  
    private ActivityTypeService activityTypeService;  

    @Autowired  
    private UserService userService;  

    @Autowired  
    private SportDeviceService sportDeviceService;  
    
	@Autowired
	private EditActivityValidator editActivityValidator;
	
//	@Autowired
//	private MessageSource messageSource;

	public EditActivityValidator getEditActivityValidator() {
		return editActivityValidator;
	}

	public void setEditActivityValidator(EditActivityValidator editActivityValidator) {
		this.editActivityValidator = editActivityValidator;
	}

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
    	// for security reason, the user can change the id, it is not allowed:
        dataBinder.setDisallowedFields("activityId");

        // format data in jsp:
        // comment in favor of @DateTimeFormat(pattern = "dd/MM/yyyy") in domain model
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        dateFormat.setLenient(false);
//        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
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
    
	@RequestMapping(value = "/{Id}/edit", method = RequestMethod.GET)
	public String onInitEdit(@PathVariable("Id") Integer Id, Map<String, Object> map, Locale locale) {
		Activity activity = activityService.getById(Id);
		map.put("activity", activity);
		
//		Integer cityId = user.getCity().getId();
//		map.put("cityId", cityId);
		//map.put("title", messageSource.getMessage("useredit.label.title.edit", null, locale) );

		return formPage;
	}
	
	@RequestMapping( value = "{Id}/edit", method = { RequestMethod.PUT, RequestMethod.POST } )
	public String onSubmitEdit(@Valid @ModelAttribute("activity") Activity activity, BindingResult result) 
	{
		if (result.hasErrors()) {
			return formPage;
		}		
		editActivityValidator.validate(activity, result);
		if (result.hasErrors()) {
			return formPage;
		}

		activityService.addActivity(activity);

		return successPage;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String onInitAdd(Map<String, Object> map, Locale locale) {
		Activity activity = new Activity();
		
		Date currentDate = new Date();
		activity.setActivityDate(currentDate);
		activity.setAmount(0);
		
		long currentTime = currentDate.getTime();
		activity.setActivityTime( new Time(currentTime) );

		map.put("activity", activity);
		//map.put("title", messageSource.getMessage("useredit.label.title.add", null, locale) );

		return formPage;
	}
   
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String onSubmitAdd(@ModelAttribute("activity") Activity activity, BindingResult result) 
	{
		editActivityValidator.validate(activity, result);
		if (result.hasErrors()) {
			return formPage;
		}

		activityService.addActivity(activity);

		return successPage;
	}
}