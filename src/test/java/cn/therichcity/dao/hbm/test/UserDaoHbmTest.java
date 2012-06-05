package cn.therichcity.dao.hbm.test;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.therichcity.dao.UserDao;
import cn.therichcity.entity.UserEntity;

public class UserDaoHbmTest extends TestCase {

	private ApplicationContext appContext;

	@Before
	public void setUp() throws Exception {
		super.setUp();

		appContext = new ClassPathXmlApplicationContext(
				"classpath:applicationContext-test.xml");
	}

	@Test
	public void getByEmailSuccessfully() {
		UserDao dao = (UserDao) appContext.getBean("userDao");
		String email = "zhangyanxia14@163.com";
		UserEntity user = dao.getByEmail(email);
		UserDaoHbmTest.assertEquals(email, user.getEmail());
	}

	@Test
	public void getByEmailFailed() {
		UserDao dao = (UserDao) appContext.getBean("userDao");
		String email = "zhangyanxia@163.com";
		UserEntity user = dao.getByEmail(email);
		UserDaoHbmTest.assertNull(user);
	}

	@Test
	public void getByEmailNullParameter() {
		UserDao dao = (UserDao) appContext.getBean("userDao");
		try {
			dao.getByEmail(null);
		} catch (Exception e) {
			UserDaoHbmTest.assertTrue(e instanceof NullPointerException);
			return;
		}

		UserDaoHbmTest.fail("It should throw out a NullPointerException.");
	}

	@Test
	public void testInsertSuccessfully() {
		UserDao dao = (UserDao) appContext.getBean("userDao");
		UserEntity userexpected = new UserEntity();
		userexpected.setEmail(System.currentTimeMillis()+"@163.com");
		userexpected.setName(Long.toString(System.currentTimeMillis()));
		userexpected.setPassword("123");
		UserDaoHbmTest.assertEquals(1, dao.insert(userexpected));

		UserEntity useractual = dao.getByEmail(userexpected.getEmail());
		UserDaoHbmTest.assertNotNull(useractual.getUuid());
		UserDaoHbmTest.assertNotNull(useractual.getRegisterDate());
		UserDaoHbmTest.assertNotNull(useractual.getLastUpdateTime());

		UserDaoHbmTest.assertEquals(userexpected.getEmail(),
				useractual.getEmail());
		UserDaoHbmTest.assertEquals(userexpected.getPassword(),
				useractual.getPassword());
		UserDaoHbmTest.assertEquals(userexpected.getName(),
				useractual.getName());
	}

}
