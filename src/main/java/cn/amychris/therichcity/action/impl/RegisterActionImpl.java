package cn.amychris.therichcity.action.impl;

import cn.amychris.therichcity.action.RegisterAction;
import cn.amychris.therichcity.service.UserService;
import cn.amychris.therichcity.transformer.UserTransformer;

public class RegisterActionImpl extends BaseActionImpl implements RegisterAction {

	private UserService userService;
	
	
	@Override
	public String register () {
		
		userService.register( UserTransformer.transform( this.getUserForm() ) );
		
		//
		return "Register Successfully";
	}

	public void setUserService ( UserService userService ) {
		this.userService = userService;
	}
	
}
