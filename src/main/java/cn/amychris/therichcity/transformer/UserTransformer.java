package cn.amychris.therichcity.transformer;

import org.apache.commons.beanutils.BeanUtils;

import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.exception.UserTransformingException;
import cn.amychris.therichcity.form.UserForm;

public class UserTransformer {
	
	public static UserEntity transform(UserForm userForm){
		UserEntity re = new UserEntity();
		try {
			BeanUtils.copyProperties(re, userForm);
		} catch ( Exception e ) {
			throw new UserTransformingException(e);
		}
		
		return null;
	}

}
