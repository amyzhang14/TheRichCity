package cn.amychris.therichcity.dao;

import java.util.List;

import cn.amychris.therichcity.entity.UserEntity;

public interface UserDao {
	
	
	UserEntity getByEmail(String email);
	
	UserEntity getByName(String name);

	Long insert(UserEntity user);

	void delete(List<Long> uuid);

	void update(UserEntity user);
}
