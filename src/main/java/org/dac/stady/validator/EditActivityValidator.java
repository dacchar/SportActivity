package org.dac.stady.validator;

import org.dac.stady.domain.Activity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Service
public class EditActivityValidator implements Validator
{
	@Override
	public boolean supports(Class<?> clazz) {
		return Activity.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) 
	{
//		// Standard validation:
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "useredit.required.firstName", "Field name is required.");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "useredit.required.lastName", "Field name is required.");
//		
//		// custom validation:
//		UserEx user = (UserEx) target;
//		if( user.getFirstName().length() < 3 ){
//			errors.rejectValue("lastName", "useredit.error.lastname", "Name is too short.");
//		}
	}
}
