package cn.amychris.therichcity.test;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTestCase {

	protected ApplicationContext appContext;
	
	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"classpath:applicationContext-test.xml");
	}
}
