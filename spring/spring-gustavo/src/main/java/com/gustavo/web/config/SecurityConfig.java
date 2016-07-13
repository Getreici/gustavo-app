package com.gustavo.web.config;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import com.gustavo.web.security.ApplicationAuthenticationSuccessHandler;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//@Resource(name = "authService")
	private UserDetailsService userDetailsService;

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		ShaPasswordEncoder encoder = new ShaPasswordEncoder();
		ReflectionSaltSource rss = new ReflectionSaltSource();
		rss.setUserPropertyToUse("salt");
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setSaltSource(rss);
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(encoder);
		auth.authenticationProvider(provider);
	}

	@Bean
	public ApplicationAuthenticationSuccessHandler successHandler() {
		ApplicationAuthenticationSuccessHandler successHandler = new ApplicationAuthenticationSuccessHandler();
		return successHandler;
	}

	// @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/favicon.ico", "/static/**","/css/**","/errors/**","/api/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.exceptionHandling()
				.authenticationEntryPoint(new AjaxAwareAuthenticationEntryPoint("/login"))
				.and()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.defaultSuccessUrl("/")
				.failureUrl("/login?error=true").permitAll()
				.successHandler(successHandler())
				.and()
			.logout()
				.logoutSuccessUrl("/login").permitAll()
				.and()
			.headers().disable()
			.csrf().disable();
		
		http.exceptionHandling().authenticationEntryPoint(new AjaxAwareAuthenticationEntryPoint("/login"));
	}
	
    
    public class AjaxAwareAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint     
    {
        public AjaxAwareAuthenticationEntryPoint(String loginUrl) {
            super(loginUrl);
        }

        @Override
        public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException)
            throws IOException, ServletException {
            String ajaxHeader = ((HttpServletRequest) request).getHeader("X-Requested-With");
            boolean isAjax = "XMLHttpRequest".equals(ajaxHeader);
            if (isAjax) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Ajax REquest Denied (Session Expired)");
            } else {
                super.commence(request, response, authException);
            }
        }
    }
	// @formatter:on
}
