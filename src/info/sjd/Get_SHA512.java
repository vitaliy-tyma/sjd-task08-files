package info.sjd;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;





public class Get_SHA512 {
	
	
	/** Get current time in milliseconds. */
	public static long curTime() {
		return System.currentTimeMillis();
	}
	
	
	/** Get random 9-digits DEC number. */
	public static String randomSession9dec(int seed) {

		long cur_time = curTime();

		/** Get SHA-512 (128 bytes long) HASH with SALT. */
		String cur_time_string = Long.toString(cur_time);
		String hash = Get_SHA512.get_SHA_512_SecurePassword(
					  cur_time_string,
					  Integer.toString(seed));
		
		int k = cur_time_string.charAt(cur_time_string.length() - 1) - '0';
		hash = Long.toString(
				   Long.parseUnsignedLong(
				   hash.substring(k, k+10), 16));
		
		/** Trim HASH to 9 digits. */
		return hash.substring(0, 9);
	}

	
	
	/** Get random IP IN DEC.DEC.DEC.DEC format.*/
	public static String randomIPhex(int seed) {
		
		long cur_time = curTime();
		
		/** Get SHA-512 (128 bytes long) HASH with SALT.*/
		String cur_time_string = Long.toString(cur_time);
		String hash = Get_SHA512.get_SHA_512_SecurePassword(
					  cur_time_string,
					  Integer.toString(seed));
		
		int k = cur_time_string.charAt(cur_time_string.length()-1)-'0';
		hash = hash.substring(k, k+8);

		/** Process string of 8 in HEX to array of 4 DECs.*/
		String[] ip = new String[4];
		for (int i = 0; i < 4; i++ ) {
			ip[i] = Integer.toString(
					Integer.parseUnsignedInt(
					hash.substring(i*2, i*2+2), 16));
		}
		/* Not sure about 0 in the first octet - it is possible now.*/
		return ip[0] + '.' + ip[1] + '.' + ip[2] + '.' +ip[3];
	}
	
	
	/** Copy-Paste*/	
	public static String get_SHA_512_SecurePassword(String passwordToHash, String salt){
		String generatedPassword = null;
		    try {
		         MessageDigest md = MessageDigest.getInstance("SHA-512");
		         md.update(salt.getBytes(StandardCharsets.UTF_8));
		         byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
		         StringBuilder sb = new StringBuilder();
		         for(int i=0; i< bytes.length ;i++){
		            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		         }
		         generatedPassword = sb.toString();
		        } 
		       catch (NoSuchAlgorithmException e){
		        e.printStackTrace();
		       }
		    return generatedPassword;
		}
}
