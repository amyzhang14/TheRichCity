package cn.therichcity.dao.hbm.test;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.therichcity.dao.UserDao;
import cn.therichcity.entity.UserEntity;

public class UserDaoHbmTest extends TestCase {

	private ApplicationContext appContext;

	public void setUp() throws Exception {
		super.setUp();

		appContext = new ClassPathXmlApplicationContext(
				"classpath:applicationContext-test.xml");
	}

	@Test
	public void testGetByEmailSuccessfully() {
		UserDao dao = (UserDao) appContext.getBean("userDao");
		String email = "zhangyanxia14@163.com";
		UserEntity user = dao.getByEmail(email);
		UserDaoHbmTest.assertEquals(email, user.getEmail());
	}

	@Test
	public void testGetByEmailFailed() {
		UserDao dao = (UserDao) appContext.getBean("userDao");
		String email = "zhangyanxia@163.com";
		UserEntity user = dao.getByEmail(email);
		UserDaoHbmTest.assertNull(user);
	}

	@Test
	public void testGetByEmailNullParameter() {
		UserDao dao = (UserDao) appContext.getBean("userDao");
		try {
			dao.getByEmail(null);
		} catch (Exception e) {
			UserDaoHbmTest.assertTrue(e instanceof NullPointerException);
			return;
		}

		UserDaoHbmTest.fail("It should throw out a NullPointerException.");
	}

}
