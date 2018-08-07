package com.xkcoding.scaffold.config;

import com.xkcoding.scaffold.config.security.ScaffoldAuthenticationFailureHandler;
import com.xkcoding.scaffold.config.security.ScaffoldAuthenticationSuccessHandler;
import com.xkcoding.scaffold.config.security.ScaffoldLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <p>
 * Spring Security 配置类
 * </p>
 *
 * @package: com.xkcoding.scaffold.config
 * @description： Spring Security 配置类
 * @author: yangkai.shen
 * @date: Created in 2018/8/7 下午6:36
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private ScaffoldAuthenticationSuccessHandler successHandler;

	@Autowired
	private ScaffoldAuthenticationFailureHandler failureHandler;

	@Autowired
	private ScaffoldLogoutSuccessHandler logoutSuccessHandler;

	/**
	 * 构造一个 BCryptPasswordEncoder，放入 Spring 容器
	 *
	 * @return {@link BCryptPasswordEncoder}
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * 自定义 Spring Security 配置
	 *
	 * @param http http 配置
	 * @throws Exception 异常
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/authentication/require").loginProcessingUrl("/authentication/login").successHandler(successHandler).failureHandler(failureHandler).and().logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler).deleteCookies("JSESSIONID").permitAll().and().authorizeRequests().antMatchers("/authentication/require").permitAll().anyRequest().authenticated().and().csrf().disable();
	}
}
