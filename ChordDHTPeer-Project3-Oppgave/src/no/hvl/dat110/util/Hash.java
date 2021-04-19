package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

<<<<<<< HEAD
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
=======
>>>>>>> branch 'master' of https://github.com/h586634/dat110-project3-startcode.git
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

<<<<<<< HEAD
public class Hash { 
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity) {		
		
		String resultat = " ";
=======
public class Hash {

	private static BigInteger hashint;

	public static BigInteger hashOf(String entity) {

>>>>>>> branch 'master' of https://github.com/h586634/dat110-project3-startcode.git
		try {

			MessageDigest md5 = MessageDigest.getInstance("MD5");
<<<<<<< HEAD
			byte [] md5HashBytes = md5.digest(entity.getBytes());
			
=======

			byte[] entityBytes = entity.getBytes();

			md5.update(entityBytes);

			byte[] digest = md5.digest();
>>>>>>> branch 'master' of https://github.com/h586634/dat110-project3-startcode.git

			resultat = toHex(md5HashBytes);
			hashint = new BigInteger(resultat, 16);
<<<<<<< HEAD
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
			
=======

>>>>>>> branch 'master' of https://github.com/h586634/dat110-project3-startcode.git
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
<<<<<<< HEAD
		
		return hashint;
=======

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
>>>>>>> branch 'master' of https://github.com/h586634/dat110-project3-startcode.git
	}

	public static int bitSize() {

		int digestlen = 0;
<<<<<<< HEAD
		
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		digestlen = md5.getDigestLength();
	
		return digestlen*8;
=======

		try {
			digestlen = MessageDigest.getInstance("MD5").getDigestLength();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return digestlen * 8;
>>>>>>> branch 'master' of https://github.com/h586634/dat110-project3-startcode.git
	}

	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for (byte b : digest) {
			strbuilder.append(String.format("%02x", b & 0xff));
		}
		return strbuilder.toString();
	}

}
