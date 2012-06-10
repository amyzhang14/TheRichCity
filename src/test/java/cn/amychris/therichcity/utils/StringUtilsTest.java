package cn.amychris.therichcity.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import cn.amychris.therichcity.util.StringUtil;

public class StringUtilsTest {

	@Test
	public void generateRandomUUID() {
		List<String> uuids = new ArrayList<String>();

		for (int i = 0; i < 1000; ++i) {
			String uuid = StringUtil.generateRandomUUID();
			System.out.println(uuid);
			Assert.assertFalse(uuids.contains(uuid));
			Assert.assertTrue(StringUtil.isUUID(uuid));
			uuids.add(uuid);
		}
	}

	@Test
	public void isEmailAddress() {

		Assert.assertTrue(StringUtil.isEmailAddress("zhang24@136.com"));
		Assert.assertTrue(StringUtil.isEmailAddress("amy.zhang24@136.com"));
		Assert.assertTrue(StringUtil.isEmailAddress("amy.zhang.24@136.com"));
		Assert.assertTrue(StringUtil.isEmailAddress("amy.zhang.24@136.com.cn"));
		
		Assert.assertFalse(StringUtil.isEmailAddress("@136.com"));
		Assert.assertFalse(StringUtil.isEmailAddress("zhang@@136.com"));
		Assert.assertFalse(StringUtil.isEmailAddress("zhang136.com"));
		Assert.assertFalse(StringUtil.isEmailAddress("zhang@136..com"));
		Assert.assertFalse(StringUtil.isEmailAddress("zhang..@136.com"));
		Assert.assertFalse(StringUtil.isEmailAddress("zhang@163com"));
		Assert.assertFalse(StringUtil.isEmailAddress("?zhang@163.com"));
		Assert.assertFalse(StringUtil.isEmailAddress("zhang@?163.com"));
		Assert.assertFalse(StringUtil.isEmailAddress("zhang\n@163.com"));
		Assert.assertFalse(StringUtil.isEmailAddress("zhang*@163.com"));
		Assert.assertFalse(StringUtil.isEmailAddress("zhang@."));
		Assert.assertFalse(StringUtil.isEmailAddress("zhangÎÒ@163.com"));
		
		

	}

}
