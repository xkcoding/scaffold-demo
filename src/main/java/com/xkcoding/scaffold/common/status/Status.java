package com.xkcoding.scaffold.common.status;

import com.xkcoding.scaffold.common.BaseEnum;
import lombok.Getter;

/**
 * <p>
 * 状态码枚举
 * </p>
 *
 * @package: com.xkcoding.scaffold.common
 * @description： 状态码枚举
 * @author: yangkai.shen
 * @date: Created in 2018/8/2 下午7:49
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Getter
public enum Status implements BaseEnum {
	/**
	 * 成功
	 */
	SUCCESS(200, "成功"),

	/**
	 * 请求错误
	 */
	BAD_REQUEST(400, "请求错误"),

	/**
	 * 尚未登录
	 */
	UNAUTHORIZED(401, "尚未登录"),

	/**
	 * 权限不够
	 */
	FORBIDDEN(403, "权限不够"),

	/**
	 * 请求不存在
	 */
	REQUEST_NOT_FOUND(404, "请求不存在"),

	/**
	 * 服务器内部错误
	 */
	INTERNAL_SERVER_ERROR(500, "服务器内部错误"),

	/**
	 * 用户名或密码错误
	 */
	USERNAME_OR_PASSWORD_ERROR(50000, "用户名或密码错误"),

	/**
	 * 用户不存在
	 */
	USER_NOT_EXIST(50001, "账号不存在"),

	/**
	 * 用户已被禁用
	 */
	USER_DISABLE(50002, "账号已被禁用"),

	/**
	 * 账号已删除
	 */
	USER_DELETED(50003, "账号已删除"),

	/**
	 * 验证码错误
	 */
	VERIFY_CODE_ERROR(50004, "验证码错误"),

	/**
	 * 登录成功
	 */
	LOGIN_SUCCESS(50005, "登录成功"),

	/**
	 * 退出成功
	 */
	LOGOUT_SUCCESS(50006, "退出成功");

	private Integer code;
	private String msg;

	Status(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
