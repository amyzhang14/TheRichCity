package cn.amychris.therichcity.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import cn.amychris.therichcity.dao.UserDao;
import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.exception.IllegalUserEntityException;
import cn.amychris.therichcity.exception.UserNotfoundException;
import cn.amychris.therichcity.service.UserService;
import cn.amychris.therichcity.validator.UserValidator;

public class UserServiceImpl implements UserService {

	@Resource(name = "userDao")
	private UserDao userDao;

	@Resource(name = "userValidator")
	private UserValidator userValidator;

	@Override
	public UserEntity register(UserEntity user) {
		validateUser(user);
		userDao.insert(user);
		return userDao.getByEmail(user.getEmail());
	}

	@Override
	public UserEntity getByEmail(String email) {

		return userDao.getByEmail(email);
	}

	@Override
	public UserEntity updateUser(UserEntity user) {
		validateUser(user);

		if (null == userDao.getByEmail(user.getEmail())) {
			throw new UserNotfoundException(user + "not found");
		}

		userDao.update(user);
		return userDao.getByEmail(user.getEmail());
	}

	@Override
	public void removeUsers(List<UserEntity> users) {
		if (null == users) {
			throw new NullPointerException("userList is null");
		}

		List<Long> uuidList = new ArrayList<Long>();
		for (UserEntity user : users) {
			uuidList.add(user.getUuid());
		}

		userDao.delete(uuidList);
	}

	private void validateUser(UserEntity user) {
		if (null == user) {
			throw new NullPointerException("user is null");
		}

		if (userValidator.validate(user).isEmpty()) {
			throw new IllegalUserEntityException("User[" + user
					+ "] is illegal.");
		}
	}

}
