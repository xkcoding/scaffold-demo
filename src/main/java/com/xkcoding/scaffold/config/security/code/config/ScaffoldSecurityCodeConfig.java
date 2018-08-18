package com.xkcoding.scaffold.config.security.code.config;

import com.xkcoding.scaffold.config.security.code.CodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 验证码配置类
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.code.config
 * @description： 验证码配置类
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 下午12:24
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Component("scaffoldSecurityCodeConfig")
public class ScaffoldSecurityCodeConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
	@Autowired
	private CodeFilter codeFilter;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(codeFilter, AbstractPreAuthenticatedProcessingFilter.class);
	}
}
