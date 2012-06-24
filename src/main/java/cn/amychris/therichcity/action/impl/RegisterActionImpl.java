package cn.amychris.therichcity.action.impl;

import java.util.List;

import cn.amychris.therichcity.action.RegisterAction;
import cn.amychris.therichcity.form.UserForm;
import cn.amychris.therichcity.service.UserService;
import cn.amychris.therichcity.transformer.UserTransformer;

public class RegisterActionImpl implements RegisterAction {

	private UserService userService;

	private List<String> errorMsgs;
	
	private UserForm userForm = new UserForm();
	
	@Override
	public String register () {
		
		userService.register( UserTransformer.transform( userForm ) );
		
		//ละ”เ
		return null;
	}
	
	public List<String> getErrorMsgs () {
		return errorMsgs;
	}

	public UserForm getUserForm () {
		return userForm;
	}

	public void setUserService ( UserService userService ) {
		this.userService = userService;
	}
}
