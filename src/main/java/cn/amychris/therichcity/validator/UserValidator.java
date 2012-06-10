package cn.amychris.therichcity.validator;

import java.util.List;

import cn.amychris.therichcity.entity.UserEntity;

public interface UserValidator {

	List<String> validate(UserEntity user);

}
