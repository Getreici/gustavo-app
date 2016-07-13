/*
 * COPYRIGHT © 2014. FocalTec.
 * ALL RIGHTS RESERVED.
 *
 * This software is confidential and proprietary information of FocalTec
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the company policy.
 */
/*package com.gustavo.web.security;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.focaltec.enjoy.model.ApplicationOption;
import com.focaltec.enjoy.model.User;
import com.focaltec.enjoy.repositories.ApplicationOptionRepository;
import com.focaltec.enjoy.services.LanguageService;
import com.focaltec.enjoy.services.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class UserDetailsServiceImpl.
 */
/*@Slf4j
@Service("authService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Resource
	private UserService userService;
	
	@Resource
	private LanguageService languageService;
	


	@Resource
	private ApplicationOptionRepository optionRepository;

	@Resource
	private MessageSource messageSource;

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.springframework.security.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	/*public ServerSideUser loadUserByUsername(final String username) throws UsernameNotFoundException,
			DataAccessException {
		try {
			User user = userService.readByEmail(username);
			if (user != null) {
				List<ApplicationOption> options = optionRepository.findByRolesIdRoleOrderByOptionOrderAsc(user.getIdRole());

				Locale locale = StringUtils.parseLocaleString(user.getLanguage().getLocale());
				for (ApplicationOption option : options) {
					String menuText = messageSource.getMessage(option.getName(), null, locale);
					option.setName(menuText);
				}
				return new ServerSideUser(user, options);
			} else {
				log.error("An error occured validating user: " + username);
				throw new UsernameNotFoundException("An error occured validating user: " + username);
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new UsernameNotFoundException("An error occured validating user: " + username, ex);
		}

	}

}*/
