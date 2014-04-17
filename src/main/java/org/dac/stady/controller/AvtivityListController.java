package org.dac.stady.controller;

import java.security.Principal;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;  
import java.util.List;
import java.util.Map;  
import javax.validation.Valid;
import org.dac.stady.domain.Activity;
import org.dac.stady.domain.ActivityFilter;
import org.dac.stady.domain.Person;
import org.dac.stady.domain.SportDevice;
import org.dac.stady.domain.User;
import org.dac.stady.service.ActivityService;
import org.dac.stady.service.PersonService;
import org.dac.stady.service.SportDeviceService;
import org.dac.stady.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;  
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;  
  
@Controller  
//@SessionAttributes("activityFilter")	// keep the object "activityFilter" save in sessions between GET and PUT/POST
@RequestMapping(value = "/data/activityList")
//@SessionAttributes("activity")	// keep the object "activityFilter" save in sessions between GET and PUT/POST
@SessionAttributes( {"activity", "activityFilter", "pagedListHolder" } )	// keep the object "activityFilter" save in sessions between GET and PUT/POST
public class AvtivityListController {  

	private String formPage = "activityList";
	private String successPage = "redirect:/data/activityList";
	
//	@Autowired
//	private PageInfo pageInfo;

	// session bean configured throught <aop:scoped-proxy/>:
	@Autowired
	private ActivityFilter activityFilter;
	
   @Autowired  
   private ActivityService activityService;   

   @Autowired  
   private SportDeviceService sportDeviceService;

   @Autowired  
   private UserService userService;
   
   @Autowired  
   private PersonService personService;
   
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

   @ModelAttribute("persons")
   public Collection<Person> populatePersons() {
		List<Person> persons = this.personService.getList();
		return persons;
   }

   @ModelAttribute("users")
   public Collection<User> populateUsers() {
		List<User> users = this.userService.getList();
		return users;
   }
   
   @InitBinder
   public void setAllowedFields(WebDataBinder dataBinder) {
//	   SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//	   dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
   }
   
	private void initActivityFilter() {
		if(!activityFilter.isInitialized()){
//		   activityFilter = new ActivityFilter();
		   		
		   Calendar calendar  = Calendar.getInstance();
		   calendar.set(Calendar.MONTH, 0);
		   calendar.set(Calendar.DAY_OF_MONTH, 1);
		   Date startDate = calendar.getTime();
		   activityFilter.setDateStart(startDate);
		   activityFilter.setDateEnd( new Date() );
		   
		   SportDevice sportDevice = sportDeviceService.getById(1);
		   activityFilter.setSportDevice(sportDevice);
		   
		   activityFilter.setInitialized(true);
		}
	}

   @RequestMapping(method = RequestMethod.GET)  
   public ModelAndView onInit(@RequestParam(value = "page", required = false, defaultValue = "alle") String page, Principal principal) {
        Map<String, Object> model = new HashMap<String, Object>();  
		
        initActivityFilter();
        
//        model.put( "activity", activityService.getActivityList() );
        List<Activity> activities = activityService.getActivityList(activityFilter); 
        model.put( "activity", activities );
        model.put( "activityFilter", activityFilter );

        Long count = activityService.getCount(activityFilter);
        model.put( "count", count );
        
		String viewName;
		if( page.equals("alle")){
//			viewName = "activityList";
//			viewName = "activityList?page=0";
			
			PagedListHolder pagedListHolder = new PagedListHolder(activities);
			model.put( "pagedListHolder", pagedListHolder );
			viewName = "activityListPaged";
		} else {
	        PagedListHolder pagedListHolder = new PagedListHolder(activities);
//	        int test = pagedListHolder.getPageSize();
//			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
	        Integer intPage = Integer.parseInt(page);
	        Integer intShowPage = --intPage;  
			pagedListHolder.setPage(intShowPage);
//			int pageSize = 10;
//			pagedListHolder.setPageSize(pageSize);
			model.put( "pagedListHolder", pagedListHolder );
			viewName = "activityListPaged";
		}
        return new ModelAndView(viewName, model);  
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
 