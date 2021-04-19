package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	private static BigInteger hashint;

	public static BigInteger hashOf(String entity) {

		try {

			MessageDigest md5 = MessageDigest.getInstance("MD5");

			byte[] entityBytes = entity.getBytes();

			md5.update(entityBytes);

			byte[] digest = md5.digest();

			String resultat = toHex(digest);
			hashint = new BigInteger(resultat, 16);

		} catch (NoSuchAlgorithmException e) {
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

	public static int bitSize() {

		int digestlen = 0;

		try {
			digestlen = MessageDigest.getInstance("MD5").getDigestLength();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return digestlen * 8;
	}

	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for (byte b : digest) {
			strbuilder.append(String.format("%02x", b & 0xff));
		}
		return strbuilder.toString();
	}

}
