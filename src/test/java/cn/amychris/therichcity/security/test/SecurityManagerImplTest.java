package cn.amychris.therichcity.security.test;

import org.junit.Assert;
import org.junit.Test;

import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.exception.ExceedingMaxLoginUsersException;
import cn.amychris.therichcity.exception.SecurityServiceException;
import cn.amychris.therichcity.security.SecurityService;
import cn.amychris.therichcity.security.SecurityServiceImpl;
import cn.amychris.therichcity.security.Session;
import cn.amychris.therichcity.util.UUIDUtil;

public class SecurityManagerImplTest {

	@Test
	public void loginSuccessfully() {
		UserEntity user = new UserEntity();
		user.setUuid(System.currentTimeMillis());
		user.setEmail("not-existing@mail.com");
		user.setName("not-existing");
		user.setPassword("password");
		
		SecurityService sm = new SecurityServiceImpl(500);
		Session session = sm.login(user);
		
		Assert.assertNotNull(session);
		Assert.assertEquals(user, session.getUser());
		Assert.assertNotNull(session.getStartTime());
		Assert.assertTrue(UUIDUtil.isUUID(session.getSessionID()));
	}
	
	@Test
	public void loginTwice() {
		UserEntity user = new UserEntity();
		user.setUuid(System.currentTimeMillis());
		SecurityService sm = new SecurityServiceImpl(500);
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
		SecurityService sm = new SecurityServiceImpl(1);
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
