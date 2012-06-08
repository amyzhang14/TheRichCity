package cn.amychris.therichcity.utils;

import java.util.ArrayList;
import java.util.List;


import org.junit.Assert;
import org.junit.Test;

import cn.amychris.therichcity.util.UUIDUtil;



public class UUIDUtilsTest {

	@Test
	public void GenerateRandomUUID() {
		List<String> uuids = new ArrayList<String>();
		
		for ( int i = 0; i < 1000; ++i ) {
			String uuid = UUIDUtil.generateRandomUUID();
			System.out.println(uuid);
			Assert.assertFalse( uuids.contains(uuid) );
			Assert.assertTrue( UUIDUtil.isUUID(uuid) );
			uuids.add( uuid );
		}
	}
	
	

}
