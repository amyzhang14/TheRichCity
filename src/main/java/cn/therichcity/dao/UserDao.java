package cn.therichcity.dao;

import java.math.BigInteger;

import cn.therichcity.entity.UserEntity;

public interface UserDao {
	UserEntity getByEmail(String email);

	int insert(UserEntity user);

	int delete(BigInteger uuid);

	int update(UserEntity user);
}
