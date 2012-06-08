package cn.amychris.therichcity.util;

import java.util.Random;

public class UUIDUtil {

	public static final int UUID_LENGTH = 32;

	public static String generateRandomUUID() {
		Random random = new Random(System.currentTimeMillis()^System.nanoTime());
		StringBuilder sb = new StringBuilder(UUID_LENGTH);

		for (int i = 0; i < UUID_LENGTH; ++i) {
			int r = random.nextInt(62);
			
			if ( r < 10 ) {
				sb.append( (char)((int)'0' + r) );
			} else if ( r < 36 ) {
				sb.append( (char)((int)'a' + (r - 10)) );
			} else {
				sb.append( (char)((int)'A' + (r - 36)) );
			}
		}

		return sb.toString();
	}

	public static boolean isUUID(String uuid) {
		if (null == uuid || uuid.length() != UUID_LENGTH) {
			return false;
		}

		for (int i = 0; i < UUIDUtil.UUID_LENGTH; ++i) {
			char c = uuid.charAt(i);
			
			if ( ! (Character.isDigit(c) || Character.isLetter(c)) ) {
				return false;
			}
		}

		return true;
	}

}
