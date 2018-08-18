package com.xkcoding.scaffold.config.security.code.base;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * <p>
 * 验证码生成器
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.code.base
 * @description： 验证码生成器
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 上午10:59
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public interface CodeGenerator {
	/**
	 * 验证码生成器接口
	 *
	 * @param request {@link ServletWebRequest} 这个类同时封装了request {@link javax.servlet.http.HttpServletRequest} 和 response {@link javax.servlet.http.HttpServletResponse}
	 * @return 验证码
	 */
	Code generate(ServletWebRequest request);
}
