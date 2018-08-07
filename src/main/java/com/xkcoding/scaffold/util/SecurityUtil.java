package com.xkcoding.scaffold.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 * <p>
 * Spring Security 工具类
 * </p>
 *
 * @package: com.xkcoding.scaffold.util
 * @description： Spring Security 工具类
 * @author: yangkai.shen
 * @date: Created in 2018/8/7 下午9:24
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public class SecurityUtil {
	/**
	 * 获取当前上下文的认证信息
	 *
	 * @return 获取当前上下文的认证信息
	 */
	public static Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	/**
	 * 获取当前上下文的认证信息的细节
	 *
	 * @return 获取当前上下文的认证信息的细节
	 */
	public static WebAuthenticationDetails getWebAuthenticationDetails() {
		return (WebAuthenticationDetails) getAuthentication().getDetails();
	}

	/**
	 * 获取登录用户的 SessionId
	 *
	 * @return SessionId
	 */
	public static String getSessionId() {
		return getWebAuthenticationDetails().getSessionId();
	}

	/**
	 * 获取登录用户的 IP
	 *
	 * @return IP
	 */
	public static String getIp() {
		return getWebAuthenticationDetails().getRemoteAddress();
	}

	/**
	 * 获取当前登录用户
	 *
	 * @return 当前登录用户
	 */
	public static UserDetails getCurrentUser() {
		Object principal = getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return (UserDetails) principal;
		}
		return null;
	}
}
