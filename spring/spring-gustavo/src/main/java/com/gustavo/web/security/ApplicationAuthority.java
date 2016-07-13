/*
 * COPYRIGHT © 2014. FocalTec.
 * ALL RIGHTS RESERVED.
 *
 * This software is confidential and proprietary information of FocalTec
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the company policy.
 */
package com.gustavo.web.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * The Class ApplicationAuthority.
 */
public class ApplicationAuthority implements GrantedAuthority {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4052520225455987372L;

    /** The authority. */
    private String authority;

    /**
     * Instantiates a new application authority.
     * @param auth the auth
     */
    public ApplicationAuthority(final String auth) {
        this.authority = auth;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.security.GrantedAuthority#getAuthority()
     */
    public String getAuthority() {
        return authority;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    /**
     * Compare to.
     * @param arg0 the arg0
     * @return the int
     */
    public int compareTo(Object arg0) {
        return 0;
    }

}
