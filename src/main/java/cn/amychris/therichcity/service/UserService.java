package cn.amychris.therichcity.service;

import java.util.List;

import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.security.Session;

public interface UserService {

	UserEntity register(UserEntity user);
	
	UserEntity getByEmail(String email);
	
	UserEntity updateUser(UserEntity user);
	
	void removeUsers(List<UserEntity> users);
	
}
