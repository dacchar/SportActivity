package org.dac.stady.controller;

import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.Locale;
import java.util.Map;  
import org.apache.commons.io.IOUtils;
import org.dac.stady.domain.User;
import org.dac.stady.service.ActivityTypeService;
import org.dac.stady.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import javax.servlet.http.HttpServletResponse;

  
@Controller
@SessionAttributes("user")	// keep the object "activity" save in sessions between GET and PUT/POST
@RequestMapping("/data/userList")
public class UserEditController {  
	
	private String formPage = "editUser";
	private String successPage = "redirect:/data/userList";
  
//	@Autowired
//	private ConversionService conversionService;
	

    @Autowired  
    private ActivityTypeService activityTypeService;  

    @Autowired  
    private UserService userService;  

   

	@RequestMapping(value = "/{Id}/getImage", method = RequestMethod.GET)
	public void getImage(HttpServletResponse response, @PathVariable("Id") int Id) {
		User user = userService.getById(Id);
		byte[] avatar = user.getAvatar();

		response.setContentType("image/jpeg");
		InputStream in1 = new ByteArrayInputStream(avatar);
		try {
			IOUtils.copy(in1, response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 	
	}

	@RequestMapping(value = "/{Id}/hasImage", method = RequestMethod.GET)
	public int hasImage(@PathVariable("Id") int Id) {
		User user = userService.getById(Id);
		byte[] avatar = user.getAvatar();
		
		if(avatar == null){
			return 0;
		} else {
			return 1;
		}
	}
	
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
    	// for security reason, the user can change the id, it is not allowed:
//        dataBinder.setDisallowedFields("userId");

        dataBinder.registerCustomEditor( byte[].class, new ByteArrayMultipartFileEditor() );
        
        // format data in jsp:
        // comment in favor of @DateTimeFormat(pattern = "dd/MM/yyyy") in domain model
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        dateFormat.setLenient(false);
//        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
        // done in dispacher servlet:
        //dataBinder.setConversionService(conversionService);
    }


    @ModelAttribute("username")
    public String populateUsername(Principal principal) {
    	return principal.getName();
    }
    
	@RequestMapping(value = "/{Id}/edit", method = RequestMethod.GET)
	public String onInitEdit(@PathVariable("Id") Integer Id, Map<String, Object> map, Locale locale) {
		User user = userService.getById(Id);
		map.put("user", user);
		
		return formPage;
	}
	
	
//	@RequestMapping( value = "{Id}/edit", method = { RequestMethod.PUT, RequestMethod.POST } )
	@RequestMapping( value = "{Id}/edit", headers = "content-type=multipart/*", method = { RequestMethod.PUT, RequestMethod.POST } )
	public String onSubmitEdit(
			@Valid @ModelAttribute("user") User user
			, @RequestParam("file") MultipartFile file
			, BindingResult result
			) 
	{
		if (result.hasErrors()) {
			return formPage;
		}		
//		editActivityValidator.validate(activity, result);
//		if (result.hasErrors()) {
//			return formPage;
//		}

		
		if( !file.isEmpty() ) {
			try {
				user.setAvatar( file.getBytes() );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		byte[] bytes;
//		try {
//			bytes =  file.getBytes();
//			user.setAavatarArray(bytes); 
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		userService.add(user);

		return successPage;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String onInitAdd(Map<String, Object> map, Locale locale) {
		User user = new User();
		
		map.put("user", user);

		return formPage;
	}
   
	//@RequestMapping(value = "/new", method = RequestMethod.POST)
	@RequestMapping( value = "/new", headers = "content-type=multipart/*", method = { RequestMethod.PUT, RequestMethod.POST } )
	public String onSubmitAdd(
			@Valid @ModelAttribute("user") User user
			, @RequestParam("file") MultipartFile file
			, BindingResult result
			)  
	{
		if (result.hasErrors()) {
			return formPage;
		}		
		
		if( !file.isEmpty() ) {
			try {
				user.setAvatar( file.getBytes() );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		userService.add(user);

		return successPage;
	}
}