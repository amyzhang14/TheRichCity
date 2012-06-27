package cn.amychris.therichcity.action.impl;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

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

	@Override
	public void validateUserNameNotExisting ( FacesContext arg0, UIComponent arg1, Object arg2 ) {
		String name = ( String ) arg2;
		
		if ( ! (null == userService.getByName( name ) )) {
			FacesMessage fm = new FacesMessage( "用户名"+name + "已经存在了" );
			throw new ValidatorException(fm);
		
	}
	
}
	

	@Override
	public void validateEmailNotExisting ( FacesContext arg0, UIComponent arg1, Object arg2 ) {
		String email = ( String ) arg2;
		
		if ( ! (null == userService.getByEmail( email ) )) {
			FacesMessage fm = new FacesMessage( "邮箱地址"+email + "已经存在了" );
			throw new ValidatorException(fm);
	}
//		if ( !StringUtil.isEmailAddress( email ) ) {
//			FacesMessage fm = new FacesMessage( "Email地址" + email + "不是一个合法的Email地址" );
//			throw new ValidatorException(fm);
//		}

	
}
}