package cn.amychris.therichcity.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.amychris.therichcity.dao.UserDao;
import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.exception.IllegalUserEntityException;
import cn.amychris.therichcity.exception.UserNotfoundException;
import cn.amychris.therichcity.service.UserService;
import cn.amychris.therichcity.validator.UserValidator;

@Scope("Singleton")
@Service("userService")
public class UserServiceImpl implements UserService {
	private static final transient Log log = LogFactory.getLog(UserServiceImpl.class);

	@Resource (name = "userDao")
	private UserDao userDao;

	@Resource (name = "userValidator")
	private UserValidator userValidator;

	@Override
	public UserEntity register (UserEntity user) {
		log.debug("Enter register(user[" + user + "])...");

		validateUser(user);
		userDao.insert(user);
		UserEntity result = userDao.getByEmail(user.getEmail());
		log.debug("Registered user[" + result + "] successfully.");

		return result;
	}

	@Override
	public UserEntity getByEmail (String email) {
		log.debug("Enter getByEmail(user[" + email + "])...");
		UserEntity re = userDao.getByEmail(email);
		log.debug("Got user[" + re + "] successfully.");
		return re;
	}

	@Override
	public UserEntity updateUser (UserEntity user) {
		log.debug("Enter updateUser(user[" + user + "])...");
		validateUser(user);

		if ( null == userDao.getByEmail(user.getEmail()) ) {
			throw new UserNotfoundException(user + "not found");
		}

		userDao.update(user);
		return userDao.getByEmail(user.getEmail());
	}

	@Override
	public void removeUsers (List<UserEntity> users) {
		log.debug("Enter removeUsers()...");
		if ( null == users ) {
			throw new NullPointerException("userList is null");
		}

		List<Long> uuidList = new ArrayList<Long>();
		for ( UserEntity user : users ) {
			uuidList.add(user.getUuid());
		}

		userDao.delete(uuidList);

		if ( log.isDebugEnabled() ) {
			for ( UserEntity user : users ) {
				log.debug("Removed user[" + user + "] successfully.");
			}
		}
	}

	private void validateUser (UserEntity user) {
		if ( null == user ) {
			throw new NullPointerException("user is null");
		}

		List<String> validateResult = userValidator.validate(user);

		if ( !validateResult.isEmpty() ) {
			throw new IllegalUserEntityException(validateResult);
		}
	}

}
