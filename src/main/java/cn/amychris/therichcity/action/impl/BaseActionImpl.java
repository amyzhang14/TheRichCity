package cn.amychris.therichcity.action.impl;

import cn.amychris.therichcity.action.BaseAction;
import cn.amychris.therichcity.form.UserForm;

public class BaseActionImpl implements BaseAction {

	private UserForm	userForm	= new UserForm();

	@Override
	public UserForm getUserForm() {
		return userForm;
	}

	@Override
	public String getGameName() {
		return "TheRichCity";
	}

}
