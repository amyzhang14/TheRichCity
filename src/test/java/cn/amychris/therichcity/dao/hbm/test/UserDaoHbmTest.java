package cn.amychris.therichcity.dao.hbm.test;

import junit.framework.Assert;

import org.junit.Test;

import cn.amychris.therichcity.dao.UserDao;
import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.test.BaseTestCase;

public class UserDaoHbmTest extends BaseTestCase {

	@Test
	public void getByEmailSuccessfully() {
		UserDao dao = (UserDao) appContext.getBean("userDao");
		String email = "zhangyanxia14@163.com";
		UserEntity user = dao.getByEmail(email);
		Assert.assertEquals(email, user.getEmail());
	}

	@Test
	public void getByEmailFailed() {
		UserDao dao = (UserDao) appContext.getBean("userDao");
		String email = "not-existing@163.com";
		UserEntity user = dao.getByEmail(email);
		Assert.assertNull(user);
	}

	@Test
	public void getByEmailNullParameter() {
		UserDao dao = (UserDao) appContext.getBean("userDao");
		try {
			dao.getByEmail(null);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof NullPointerException);
			return;
		}

		Assert.fail("It should throw out a NullPointerException.");
	}

	@Test
	public void insertSuccessfully() {
		UserDao dao = (UserDao) appContext.getBean("userDao");
		UserEntity userexpected = new UserEntity();
		userexpected.setEmail(System.currentTimeMillis()+"@163.com");
		userexpected.setName(Long.toString(System.currentTimeMillis()));
		userexpected.setPassword("123");
		
		Long id = dao.insert(userexpected);
		Assert.assertNotNull( id );
		UserEntity useractual = dao.getByEmail(userexpected.getEmail());
		
		Assert.assertNotNull(useractual.getRegisterDate());
		Assert.assertNotNull(useractual.getLastUpdateTime());

		Assert.assertEquals(userexpected.getEmail(), useractual.getEmail());
		Assert.assertEquals(userexpected.getPassword(), useractual.getPassword());
		Assert.assertEquals(userexpected.getName(), useractual.getName());
		Assert.assertEquals(id, useractual.getUuid());
	}

}
