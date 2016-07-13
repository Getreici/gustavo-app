/*
 * COPYRIGHT © 2014. FocalTec.
 * ALL RIGHTS RESERVED.
 *
 * This software is confidential and proprietary information of FocalTec
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the company policy.
 */
package com.gustavo.web.security;


public class Password {

    
    private String salt;
    
    private String passkey;

    
    public String getSalt() {
        return salt;
    }

    
    public void setSalt(String salt) {
        this.salt = salt;
    }

    
    public String getPasskey() {
        return passkey;
    }

    
    public void setPasskey(String passkey) {
        this.passkey = passkey;
    }
    
    
}
