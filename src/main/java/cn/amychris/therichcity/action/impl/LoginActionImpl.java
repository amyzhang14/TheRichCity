package cn.amychris.therichcity.action.impl;

import cn.amychris.therichcity.action.LoginAction;
import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.form.UserForm;
import cn.amychris.therichcity.service.LoginService;
import cn.amychris.therichcity.service.UserService;

public class LoginActionImpl extends BaseActionImpl implements LoginAction {

	private LoginService loginService;

	private UserService userService;

	private UserForm userForm = new UserForm();

	@Override
	public String login () {

		UserEntity user = userService.getByEmail( userForm.getEmail() );
		loginService.login( user );
		return "Login Successfully";
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

}
