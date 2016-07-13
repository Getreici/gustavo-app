/*
 * COPYRIGHT © 2014. FocalTec.
 * ALL RIGHTS RESERVED.
 *
 * This software is confidential and proprietary information of FocalTec
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the company policy.
 */
/*package com.gustavo.web.security;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class PasswordEncrypt {

	
	public static Password encrypt(final String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String salt = getSalt(6);
		ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder();
		Password pwd = new Password();
		pwd.setSalt(salt);
		pwd.setPasskey(passwordEncoder.encodePassword(password, salt));
		
		return pwd;
	}

	private static String getSalt(final int saltSize) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		SecureRandom sec;
		sec = SecureRandom.getInstance("SHA1PRNG");
		byte[] seed = sec.generateSeed(saltSize);
		sec = null;
		return new String(Base64.encode(seed), "UTF8");
	}

	public static void main(String[] args) {
		try {
			Password pwd = encrypt("mente");
			System.out.println(pwd.getPasskey());
			System.out.println(pwd.getSalt());
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}*/
