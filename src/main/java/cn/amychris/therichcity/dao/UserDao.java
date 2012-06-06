package cn.amychris.therichcity.dao;

import cn.amychris.therichcity.entity.UserEntity;

public interface UserDao {
	
	
	UserEntity getByEmail(String email);

	Long insert(UserEntity user);

	void delete(Long uuid);

	void update(UserEntity user);
}
