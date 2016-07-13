/*
 * COPYRIGHT © 2014. FocalTec.
 * ALL RIGHTS RESERVED.
 *
 * This software is confidential and proprietary information of FocalTec
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the company policy.
 */
package com.gustavo.web.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.gustavo.web.model.User;

@Slf4j
public class ServerSideUser implements UserDetails {

	private static final long serialVersionUID = 2406521337725238486L;

	private final User user=null;

	
	public User getUser() {
		return user;
	}

	public Integer getUserId() {
		return user.getIdUser();
	}

	public Locale getLocale() {
		if (user != null) {
			try {
				return org.springframework.util.StringUtils.parseLocaleString(user.getFirstName());
			} catch (Exception ex) {
				log.error("The user '" + user.getEmail() + "' has a wrong locale.");
			}
		}
		return Locale.ENGLISH;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.userdetails.UserDetails#getPassword()
	 */
	public String getPassword() {
		return user.getPassword();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.userdetails.UserDetails#getUsername()
	 */
	public String getUsername() {
		return user.getEmail();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.userdetails.UserDetails#isAccountNonExpired
	 * ()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.userdetails.UserDetails#isAccountNonLocked()
	 */
	public boolean isAccountNonLocked() {
		return isAccountNonExpired();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.userdetails.UserDetails#isCredentialsNonExpired
	 * ()
	 */
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.userdetails.UserDetails#isEnabled()
	 */
	

	/**
	 * Gets the salt.
	 * 
	 * @return the salt
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.userdetails.UserDetails#getAuthorities()
	 */
	
	public void setAuthorities(final GrantedAuthority[] authorities) {

	}

	/**
	 * Returns {@code true} if the supplied object is a {@code User} instance
	 * with the same {@code username} value.
	 * <p>
	 * In other words, the objects are equal if they have the same username,
	 * representing the same principal.
	 */
	@Override
	public boolean equals(Object rhs) {
		if (rhs instanceof ServerSideUser && ((ServerSideUser) rhs).getUser() != null) {
			return user.getEmail().equals(((ServerSideUser) rhs).getUser().getEmail());
		}
		return false;
	}

	/**
	 * Returns the hashcode of the {@code username}.
	 */
	@Override
	public int hashCode() {
		return user.getEmail().hashCode();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
