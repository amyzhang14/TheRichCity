package cn.amychris.therichcity.action.impl;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import cn.amychris.therichcity.action.RegisterAction;
import cn.amychris.therichcity.service.UserService;
import cn.amychris.therichcity.transformer.UserTransformer;

public class RegisterActionImpl extends BaseActionImpl implements RegisterAction {

	private UserService	userService;

	@Override
	public String register() {

		userService.register( UserTransformer.transform( this.getUserForm() ) );

		return "Register Successfully";
	}

	public void setUserService( UserService userService ) {
		this.userService = userService;
	}

	@Override
	public void validateUserNameNotExisting( FacesContext arg0, UIComponent arg1, Object arg2 ) {
		String name = ( String ) arg2;

		if ( null != userService.getUserByName( name ) ) {
			FacesMessage fm = new FacesMessage( "�û���" + name + "�Ѿ�������" );
			throw new ValidatorException( fm );

		}

	}

	@Override
	public void validateEmailNotExisting( FacesContext arg0, UIComponent arg1, Object arg2 ) {
		String email = ( String ) arg2;

		if (  null != userService.getUserByEmail( email )  ) {
			FacesMessage fm = new FacesMessage( "�����ַ" + email + "�Ѿ�������" );
			throw new ValidatorException( fm );
		}
		
	}
}