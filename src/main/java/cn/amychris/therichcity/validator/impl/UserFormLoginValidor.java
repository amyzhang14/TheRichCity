package cn.amychris.therichcity.validator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.amychris.therichcity.form.UserForm;
import cn.amychris.therichcity.util.StringUtil;
import cn.amychris.therichcity.validator.UserFormValidator;

@Scope("singleton")
@Component("userFormLoginValidor")
public class UserFormLoginValidor implements UserFormValidator {
	@Override
	public List<String> validate (UserForm userForm) {
		List<String> errorMesg = new ArrayList<String>();

		// validate the emailAddress
		if (StringUtil.isBlank(userForm.getEmail())) {
			errorMesg.add("邮箱地址不能为空");
		}


		//validate the passwd
		if (StringUtil.isBlank(userForm.getPassword())) {
			errorMesg.add("密碼不能為空。");
		}
		
		return errorMesg;
		
	}

}
