package cn.amychris.therichcity.service;

import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.exception.ExceedingMaxLoginUsersException;
import cn.amychris.therichcity.exception.SecurityServiceException;

/*
 * @author Chen Haoming
 */
public interface LoginService {
	
	/*
	 * Login a user.
	 * @param user <code>UserEntity</code>
	 * 
	 */
	void login(UserEntity user) throws ExceedingMaxLoginUsersException, SecurityServiceException;
	
	/*
	 * Logout and end the <code>Session</code>
	 * @param user <code>UserEntity</code>
	 */
	void logout(UserEntity user);
	
	int sizeOfLoginedUsers();
}
