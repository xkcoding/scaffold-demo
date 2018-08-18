package com.xkcoding.scaffold.common.property;

import lombok.Data;

/**
 * <p>
 * 短信验证码配置
 * </p>
 *
 * @package: com.xkcoding.scaffold.common.property
 * @description： 短信验证码配置
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 上午11:13
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
public class SmsCodeProperties {
	/**
	 * 长度，默认长度为6位
	 */
	private int length = 6;

	/**
	 * 过期时间，默认过期时间 60s
	 */
	private int expireIn = 60;

	/**
	 * url
	 */
	private String url;
}
