/*
 * COPYRIGHT © 2014. FocalTec.
 * ALL RIGHTS RESERVED.
 *
 * This software is confidential and proprietary information of FocalTec
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the company policy.
 */
package com.gustavo.web.security;

import java.util.List;
import java.util.Locale;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;


import com.gustavo.web.model.User;

public class SpringSecurityHelper {

	public static boolean hasRole(String role) {
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user.getAuthorities().contains(new SimpleGrantedAuthority(role));
	}

	public static User getUser() {
		return getServerSideUSer().getUser();
	}

	public static String getName() {
		return getServerSideUSer().getUsername();
	}

	public static Integer getIdUser() {
		return getServerSideUSer().getUserId();
	}



	public static Locale getLocale() {
		return getServerSideUSer().getLocale();
	}

	private static ServerSideUser getServerSideUSer() {
		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof String) {
			User user = new User();
			user.setIdUser(1);
			return new ServerSideUser();
		}
		return (ServerSideUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

}
