package cn.amychris.therichcity.dao.hbm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.amychris.therichcity.dao.UserDao;
import cn.amychris.therichcity.entity.UserEntity;

/*
 * @author Amy Zhang
 * 
 * Implementation of <code>UserDao</code>, using Hibernate framework.
 */

@Scope ( "singleton" )
@Repository ( "userDao" )
public class UserDaoHbm implements UserDao {

	@Resource ( name = "hibernateTemplate" )
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings ( "unchecked" )
	@Override
	public UserEntity getByEmail ( String email ) {

		if ( null == email ) {
			throw new NullPointerException( "email cann't be null." );
		}

		UserEntity user = new UserEntity();
		user.setEmail( email );
		List<UserEntity> list = (List<UserEntity>) this.hibernateTemplate.findByExample( user );

		return list.isEmpty() ? null : list.get( 0 );
	}

	@Override
	public Long insert ( UserEntity user ) {
		if ( null == user.getEmail() || null == user.getName() || null == user.getPassword() ) {
			throw new NullPointerException( "email and name and password cann't be null." );
		}

		user.setUuid( null );
		user.setRegisterDate( new Date() );
		return (Long) this.hibernateTemplate.save( user );
	}

	@Override
	public void delete ( List<Long> uuids ) {
		if ( null == uuids ) {
			throw new NullPointerException( "Uuids couldn't be null." );
		}

		if ( uuids.isEmpty() ) {
			return;
		}

		List<UserEntity> entities = new ArrayList<UserEntity>();

		for ( Long uuid : uuids ) {
			UserEntity user = new UserEntity();
			user.setUuid( uuid );
			entities.add( user );
		}

		this.hibernateTemplate.deleteAll( entities );
	}

	@Override
	public void update ( UserEntity user ) {
		user.setLastUpdateTime( null );
		user.setRegisterDate( null );
		this.hibernateTemplate.update( user );
	}

	@Override
	public UserEntity getByName ( String name ) {
		if ( null == name ) {
			throw new NullPointerException( "name cann't be null." );
		}

		UserEntity user = new UserEntity();
		user.setName( name );
		@SuppressWarnings ( "unchecked" )
		List<UserEntity> list = (List<UserEntity>) this.hibernateTemplate.findByExample( user );

		return list.isEmpty() ? null : list.get( 0 );
	}

}
