package cn.amychris.therichcity.security.test;

import org.junit.Assert;
import org.junit.Test;

import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.exception.ExceedingMaxLoginUsersException;
import cn.amychris.therichcity.exception.SecurityServiceException;
import cn.amychris.therichcity.service.LoginService;
import cn.amychris.therichcity.service.impl.LoginServiceImpl;

public class LoginServiceImplTest {

	@Test
	public void loginSuccessfully() {
		UserEntity user = new UserEntity();
		user.setUuid(System.currentTimeMillis());
		user.setEmail("not-existing@mail.com");
		user.setName("not-existing");
		user.setPassword("password");
		
		LoginService sm = new LoginServiceImpl(500);
		sm.login(user);
		
		
	}
	
	@Test
	public void loginTwice() {
		UserEntity user = new UserEntity();
		user.setUuid(System.currentTimeMillis());
		LoginService sm = new LoginServiceImpl(500);
		sm.login(user);
		
		try {
			sm.login(user);
		} catch (SecurityServiceException e) {
			Assert.assertFalse( e instanceof ExceedingMaxLoginUsersException );
			return;
		}
		
		Assert.fail();
	}
	
	@Test
	public void meetMaxLoginUsers() {
		UserEntity user = new UserEntity();
		user.setUuid(System.currentTimeMillis());
		LoginService sm = new LoginServiceImpl(1);
		sm.login(user);
		
		UserEntity user2 = new UserEntity();
		user.setUuid(System.currentTimeMillis());
		
		try {
			sm.login(user2);
		} catch (ExceedingMaxLoginUsersException e) {
			return;
		}
		
		Assert.fail();
	}
}
