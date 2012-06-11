package cn.amychris.therichcity.service.impl;

import java.util.LinkedList;
import java.util.List;

import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.exception.ExceedingMaxLoginUsersException;
import cn.amychris.therichcity.exception.SecurityServiceException;
import cn.amychris.therichcity.service.LoginService;


public class LoginServiceImpl implements LoginService {

	private List<UserEntity> loginUser;

	private int maxLoginUsers;

	public LoginServiceImpl(int maxLoginUsers) {
		this.maxLoginUsers = maxLoginUsers;
		loginUser = new LinkedList<UserEntity>();
	}

	@Override
	public void login (UserEntity user) {
		if ( null == user ) {
			throw new NullPointerException("User could not be null.");
		}

		if ( loginUser.contains(user) ) {
			throw new SecurityServiceException("User(" + user.toString() + ") has already logined.");
		}

		synchronized (loginUser) {
			if ( loginUser.size() == maxLoginUsers ) {
				throw new ExceedingMaxLoginUsersException("The maximum number of users can login is " + maxLoginUsers);
			}

			loginUser.add(user);
		}
	}

	@Override
	public void logout (UserEntity user) {
		if ( null == user ) {
			throw new NullPointerException("User could not be null.");
		}
		
		if ( !loginUser.contains(user) ) {
			throw new SecurityServiceException("User(" + user.toString() + ") hasn't logined.");
		}
		
		loginUser.remove(user);

	}

	@Override
	public int sizeOfLoginedUsers () {
		return loginUser.size();
	}

}
