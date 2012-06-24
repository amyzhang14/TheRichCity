package cn.amychris.therichcity.action;

import java.util.List;

import cn.amychris.therichcity.form.UserForm;


public interface LoginAction {
	
	String login();
	
	String changePasswd();

	List<String> getErrorMsgs();
	
	UserForm getUserForm();
}
