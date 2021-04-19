package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity) {		
		
		try {
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(entity.getBytes());
			String hex = toHex(messageDigest);
			hashint = new BigInteger(hex, 16);
			
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				int length = md.getDigestLength();
				int bits = length * 8;
				BigInteger exp = new BigInteger("2");
				exp = exp.pow(bits);
				return exp;
				
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		MessageDigest md;
		
		try {
				md = MessageDigest.getInstance("MD5");
				digestlen = md.getDigestLength();
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
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
