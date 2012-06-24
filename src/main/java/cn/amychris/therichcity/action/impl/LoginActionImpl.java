package cn.amychris.therichcity.action.impl;

import java.util.List;

import cn.amychris.therichcity.action.LoginAction;
import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.exception.SecurityServiceException;
import cn.amychris.therichcity.form.UserForm;
import cn.amychris.therichcity.service.LoginService;
import cn.amychris.therichcity.service.UserService;
import cn.amychris.therichcity.validator.UserFormValidator;

public class LoginActionImpl implements LoginAction {

	private LoginService loginService;

	private UserService userService;

	private UserFormValidator userFormLoginValidator;

	private List<String> errorMsgs;

	private UserForm userForm = new UserForm();

	@Override
	public String login () {
		errorMsgs = userFormLoginValidator.validate( userForm );
		
		if ( ! errorMsgs.isEmpty() ) {
			return "Login Unsuccessfully";
		}

		UserEntity user = userService.getByEmail( userForm.getEmail() );

		if ( null == user ) {
			errorMsgs.add( "” œ‰°æ" + userForm.getEmail() + "°øŒ¥◊¢≤·" );
			return "Login Unsuccessfully";
		}

		if ( ! user.getPassword().equals( userForm.getPassword() ) ) {
			errorMsgs.add( "√‹¬Î¥ÌŒÛ°£" );
			return "Login Unsuccessfully";
		}

		try {
			loginService.login( user );
		} catch ( SecurityServiceException e ) {
			errorMsgs.add( e.getLocalizedMessage() );
			return "Login Unsuccessfully";
		}

		return "Login Successfully";
	}

	@Override
	public String changePasswd () {
		// TODO Auto-generated method stub
		return null;
	}


	public List<String> getErrorMsgs () {
		return errorMsgs;
	}

	public UserForm getUserForm () {
		return userForm;
	}

	public void setLoginService ( LoginService loginService ) {
		this.loginService = loginService;
	}

	public void setUserService ( UserService userService ) {
		this.userService = userService;
	}

	public void setUserFormLoginValidator ( UserFormValidator userFormLoginValidator ) {
		this.userFormLoginValidator = userFormLoginValidator;
	}

}
