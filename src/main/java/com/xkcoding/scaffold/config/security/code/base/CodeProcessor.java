package com.xkcoding.scaffold.config.security.code.base;

import com.xkcoding.scaffold.exception.ScaffoldException;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * <p>
 * 验证码处理器，封装不同验证码的处理逻辑
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.code.base
 * @description： 验证码处理器，封装不同验证码的处理逻辑
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 上午11:05
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public interface CodeProcessor {
	/**
	 * 验证码放入session时的前缀
	 */
	String SESSION_KEY_PREFIX = "SCAFFOLD_SESSION_KEY_FOR_CODE_";

	/**
	 * 创建校验码
	 *
	 * @param request {@link ServletWebRequest} 这个类同时封装了request {@link javax.servlet.http.HttpServletRequest} 和 response {@link javax.servlet.http.HttpServletResponse}
	 * @throws ScaffoldException 全局异常
	 */
	void create(ServletWebRequest request) throws ScaffoldException;

	/**
	 * 校验验证码
	 *
	 * @param request {@link ServletWebRequest} 这个类同时封装了request {@link javax.servlet.http.HttpServletRequest} 和 response {@link javax.servlet.http.HttpServletResponse}
	 * @throws ScaffoldException 全局异常
	 */
	void validate(ServletWebRequest request) throws ScaffoldException;
}
