package com.xkcoding.scaffold.config.security;

import com.xkcoding.scaffold.common.constant.ScaffoldConst;
import com.xkcoding.scaffold.config.security.handler.*;
import com.xkcoding.scaffold.config.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

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
	private ScaffoldAccessDeniedHandler accessDeniedHandler;

	@Autowired
	private ScaffoldLogoutSuccessHandler logoutSuccessHandler;

	@Autowired
	private ScaffoldAccessDecisionManager accessDecisionManager;

	@Autowired
	private ScaffoldFilterInvocationSecurityMetadataSource securityMetadataSource;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

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
	 * 自定义数据库账号认证
	 *
	 * @return {@link ScaffoldDaoAuthenticationProvider}
	 */
	@Bean
	public ScaffoldDaoAuthenticationProvider scaffoldDaoAuthenticationProvider() {
		ScaffoldDaoAuthenticationProvider scaffoldDaoAuthenticationProvider = new ScaffoldDaoAuthenticationProvider();
		scaffoldDaoAuthenticationProvider.setHideUserNotFoundExceptions(false);
		scaffoldDaoAuthenticationProvider.setUserDetailsService(userDetailsService);
		scaffoldDaoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return scaffoldDaoAuthenticationProvider;
	}

	/**
	 * 启用自定义认证器
	 *
	 * @param auth 认证管理器
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(scaffoldDaoAuthenticationProvider());
	}

	@Override
	public void configure(WebSecurity web) {
		// 忽略指定资源
		web.ignoring().antMatchers(ScaffoldConst.AUTHENTICATION_LOGIN_PAGE, ScaffoldConst.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*");
	}

	/**
	 * 自定义 Spring Security 配置
	 *
	 * @param http http 配置
	 * @throws Exception 异常
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 允许iframe 嵌套
		http.headers().frameOptions().disable();

		// 配置 登录成功、登录失败、退出登录 处理器
		http.formLogin().loginPage(ScaffoldConst.AUTHENTICATION_LOGIN_PAGE).loginProcessingUrl("/authentication/login").successHandler(successHandler).failureHandler(failureHandler).and().logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler).deleteCookies("JSESSIONID").permitAll();

		// 一个自定义的filter，必须包含 authenticationManager,accessDecisionManager,securityMetadataSource三个属性，
		// 我们的所有控制将在这三个类中实现，解释详见具体配置
		http.authorizeRequests().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
			@Override
			public <O extends FilterSecurityInterceptor> O postProcess(O object) {
				object.setSecurityMetadataSource(securityMetadataSource);
				object.setAccessDecisionManager(accessDecisionManager);
				return object;
			}
		});

		// 关闭 csrf
		http.csrf().disable();

		// 拒绝访问 处理器
		http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);

		// session管理
		http.sessionManagement().maximumSessions(1).sessionRegistry(getSessionRegistry());

	}


	@Bean
	public SessionRegistry getSessionRegistry() {
		return new SessionRegistryImpl();
	}
}
