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
		
	
		try {
			
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte [] md5HashBytes = md5.digest(entity.getBytes());
			
			md5.update(md5HashBytes);
			
			byte[] digest = md5.digest();

			String resultat = toHex(digest);
			hashint = new BigInteger(resultat, 16);
			
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		MessageDigest md; 
		
		try {
			 
			md = MessageDigest.getInstance("MD5");
			int length = md.getDigestLength();
			int numBit = length * 8; 
			BigInteger svar = new BigInteger("2").pow(numBit);
			return svar; 
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static int bitSize() throws NoSuchAlgorithmException {
		
		int digestlen = 0;
		
		digestlen = MessageDigest.getInstance("MD5").getDigestLength();
		
	
		return digestlen * 8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
