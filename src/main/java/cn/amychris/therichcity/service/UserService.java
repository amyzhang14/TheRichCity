package cn.amychris.therichcity.service;

import java.util.List;

import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.exception.ExceedingMaxLoginUsersException;
import cn.amychris.therichcity.exception.SecurityServiceException;

public interface UserService {

	UserEntity register ( UserEntity user );

	UserEntity getUserByEmail ( String email );

	UserEntity updateUser ( UserEntity user );

	void removeUsers ( List<UserEntity> users );

	UserEntity getUserByName ( String name );
	
	/*
	 * Login a user.
	 * 
	 * @param user {@link cn.amychris.therichcity.entity.UserEntity}
	 */
	void login( UserEntity user ) throws ExceedingMaxLoginUsersException, SecurityServiceException;

	/*
	 * Logout a user {@link cn.amychris.therichcity.entity.UserEntity}
	 * 
	 * @param user {@link cn.amychris.therichcity.entity.UserEntity}
	 */
	void logout( UserEntity user );

	int sizeOfLoginedUsers();

	boolean isUserLogined( UserEntity user );

}
