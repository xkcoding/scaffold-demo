package com.xkcoding.scaffold.config.security.code.base;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 验证码基类
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.code.base
 * @description： 验证码基类
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 上午10:52
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
public class Code {
	/**
	 * 验证码
	 */
	private String code;

	/**
	 * 过期时间
	 */
	private LocalDateTime expireTime;

	public Code() {
	}

	public Code(String code, int expireIn) {
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
	}

	public Code(String code, LocalDateTime expireTime) {
		this.code = code;
		this.expireTime = expireTime;
	}

	/**
	 * 是否过期
	 */
	public boolean isExpried() {
		return LocalDateTime.now().isAfter(expireTime);
	}
}
