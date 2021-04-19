package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity) {		
		
		String resultat = " ";
		try {
			
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte [] md5HashBytes = md5.digest(entity.getBytes());
			

			resultat = toHex(md5HashBytes);
			hashint = new BigInteger(resultat, 16);
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		try {
			 
			int numberBits = bitSize();
			double addSize = Math.pow(2, numberBits);
			hashint = BigDecimal.valueOf(addSize).toBigInteger();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return hashint;
	}
	
	public static int bitSize() throws NoSuchAlgorithmException {
		
		int digestlen = 0;
		
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		digestlen = md5.getDigestLength();
	
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
