package cn.amychris.therichcity.action.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.amychris.therichcity.action.LoginAction;
import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.exception.SecurityServiceException;
import cn.amychris.therichcity.form.UserForm;
import cn.amychris.therichcity.service.LoginService;
import cn.amychris.therichcity.service.UserService;
import cn.amychris.therichcity.validator.UserFormValidator;

@Scope ("prototype")
@Controller ("loginAction")
public class LoginActionImpl implements LoginAction {

	@Autowired
	@Qualifier("loginService")
	private LoginService loginService;

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Autowired
	@Qualifier("userFormLoginValidor")
	private UserFormValidator userFormLoginValidor;

	private List<String> errorMsgs;
	
	private UserForm userForm = new UserForm();

	@Override
	public String login () {
		errorMsgs = userFormLoginValidor.validate(userForm);
		if ( !errorMsgs.isEmpty() ) {
			return "loginFailed";
		}
		UserEntity user = userService.getByEmail(userForm.getEmail());
		if ( !user.getPassword().equals(userForm.getPassword()) ) {
			errorMsgs.add("√‹¬Î¥ÌŒÛ°£");
			return "loginFailed";
		}
		try {
			loginService.login(user);
		} catch ( SecurityServiceException e ) {
			errorMsgs.add(e.getLocalizedMessage());
			return "loginFailed";
		}

		return "success";
	}

	@Override
	public String changePasswd () {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String register () {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getErrorMsgs () {
		return errorMsgs;
	}
	
	public UserForm getUserForm () {
		return userForm;
	}

}
