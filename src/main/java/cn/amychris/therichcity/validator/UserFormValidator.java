package cn.amychris.therichcity.validator;

import java.util.List;

import cn.amychris.therichcity.form.UserForm;

public interface UserFormValidator {
	List<String> validate (UserForm userForm);
}
