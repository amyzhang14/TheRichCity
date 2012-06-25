package cn.amychris.therichcity.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import cn.amychris.therichcity.util.StringUtil;

public class EmailFormatValidator implements Validator {

	@Override
	public void validate( FacesContext arg0, UIComponent arg1, Object arg2 ) throws ValidatorException {
		String email = ( String ) arg2;
		
		if ( !StringUtil.isEmailAddress( email ) ) {
			FacesMessage fm = new FacesMessage( FacesMessage.SEVERITY_ERROR, "�Ƿ���Email��ַ", email + "����һ���Ϸ���Email��ַ" );
			throw new ValidatorException(fm);
		}

	}

}
