package utils;

import java.util.Base64;

/**
 * This class is responsible for giving out decoded value of encoded passwords if needed 
 * (as we can't expose passwords in production runs)
 */
public final class DecodeUtils {
	
	
	private DecodeUtils() {}
	
	
	public static String getDecodedString(String encodedString) {
		return new String(Base64.getDecoder().decode(encodedString.getBytes()));
	}

}
