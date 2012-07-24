package cn.amychris.therichcity.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.amychris.therichcity.dao.UserDao;
import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.exception.ExceedingMaxLoginUsersException;
import cn.amychris.therichcity.exception.SecurityServiceException;
import cn.amychris.therichcity.exception.UserNotfoundException;
import cn.amychris.therichcity.service.UserService;

@Scope("singleton")
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	private static final transient Log	log	= LogFactory.getLog( UserServiceImpl.class );

	private List<UserEntity>			loginUser;

	private int							maxLoginUsers;

	@Resource(name = "userDao")
	private UserDao						userDao;

	public UserServiceImpl(int maxLoginUsers) {
		this.maxLoginUsers = maxLoginUsers;
		loginUser = new LinkedList<UserEntity>();
	}

	@Override
	public UserEntity register( UserEntity user ) {
		log.debug( "Enter register(user[" + user + "])..." );

		userDao.insert( user );
		UserEntity result = userDao.getByEmail( user.getEmail() );
		log.debug( "Registered user[" + result + "] successfully." );

		return result;
	}

	@Override
	public UserEntity getUserByEmail( String email ) {
		log.debug( "Enter getByEmail(user[" + email + "])..." );
		UserEntity re = userDao.getByEmail( email );
		log.debug( "Got user[" + re + "] successfully." );
		return re;
	}

	@Override
	public UserEntity updateUser( UserEntity user ) {
		log.debug( "Enter updateUser(user[" + user + "])..." );

		if ( null == userDao.getByEmail( user.getEmail() ) ) {
			throw new UserNotfoundException( user + "not found" );
		}

		userDao.update( user );
		return userDao.getByEmail( user.getEmail() );
	}

	@Override
	public void removeUsers( List<UserEntity> users ) {
		log.debug( "Enter removeUsers()..." );
		if ( null == users ) {
			throw new NullPointerException( "userList is null" );
		}

		List<Long> uuidList = new ArrayList<Long>();
		for ( UserEntity user : users ) {
			uuidList.add( user.getUuid() );
		}

		userDao.delete( uuidList );

		if ( log.isDebugEnabled() ) {
			for ( UserEntity user : users ) {
				log.debug( "Removed user[" + user + "] successfully." );
			}
		}
	}

	@Override
	public UserEntity getUserByName( String name ) {
		log.debug( "Enter getByName(user[" + name + "])..." );
		UserEntity re = userDao.getByName( name );
		log.debug( "Got user[" + re + "] successfully." );
		return re;
	}

	@Override
	public void login( UserEntity user ) {
		if ( null == user ) {
			throw new NullPointerException( "User could not be null." );
		}

		if ( loginUser.contains( user ) ) {
			throw new SecurityServiceException( "User(" + user.toString() + ") has already logined." );
		}

		synchronized ( loginUser ) {
			if ( loginUser.size() == maxLoginUsers ) {
				throw new ExceedingMaxLoginUsersException( "The maximum number of users can login is " + maxLoginUsers );
			}

			loginUser.add( user );
		}
	}

	@Override
	public void logout( UserEntity user ) {
		if ( null == user ) {
			throw new NullPointerException( "User could not be null." );
		}

		if ( !loginUser.contains( user ) ) {
			throw new SecurityServiceException( "User(" + user.toString() + ") hasn't logined." );
		}

		loginUser.remove( user );

	}

	@Override
	public int sizeOfLoginedUsers() {
		return loginUser.size();
	}

	@Override
	public boolean isUserLogined( UserEntity user ) {
		// TODO Auto-generated method stub
		return false;
	}

}
