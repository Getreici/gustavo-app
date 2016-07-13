package com.gustavo.web.security;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.web.servlet.LocaleResolver;

public class ApplicationAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Resource
	LocaleResolver localeResolver;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		localeResolver.setLocale(request, response, SpringSecurityHelper.getLocale());
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
