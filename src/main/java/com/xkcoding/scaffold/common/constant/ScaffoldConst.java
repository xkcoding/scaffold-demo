package com.xkcoding.scaffold.common.constant;

/**
 * <p>
 * Scaffold 常量池
 * </p>
 *
 * @package: com.xkcoding.scaffold.common.constant
 * @description： Scaffold 常量池
 * @author: yangkai.shen
 * @date: Created in 2018/8/17 上午10:05
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public interface ScaffoldConst {
	/**
	 * 逗号
	 */
	String COMMA = ",";

	/**
	 * 默认的处理验证码的url前缀
	 */
	String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";

	/**
	 * 登录页面地址
	 */
	String AUTHENTICATION_LOGIN_PAGE = "/authentication/require";

	/**
	 * 默认的用户名密码登录请求处理url
	 */
	String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authentication/login";

	/**
	 * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
	 */
	String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";

	/**
	 * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
	 */
	String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
}
