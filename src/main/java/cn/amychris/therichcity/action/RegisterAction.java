package cn.amychris.therichcity.action;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public interface RegisterAction extends BaseAction {

	String register ();

	void validateUserNameNotExisting ( FacesContext arg0, UIComponent arg1, Object arg2 );
	
	void validateEmailNotExisting ( FacesContext arg0, UIComponent arg1, Object arg2 );
}
