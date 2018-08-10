package com.xkcoding.scaffold.common.status;

import com.xkcoding.scaffold.common.BaseEnum;
import lombok.Getter;

/**
 * <p>
 * 日志状态枚举
 * </p>
 *
 * @package: com.xkcoding.scaffold.common.status
 * @description： 日志状态枚举
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 上午10:26
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Getter
public enum LogStatus implements BaseEnum {
	/**
	 * 成功
	 */
	SUCCESS(1, "成功"),

	/**
	 * 失败
	 */
	ERROR(0, "失败");

	private Integer code;
	private String msg;

	LogStatus(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
