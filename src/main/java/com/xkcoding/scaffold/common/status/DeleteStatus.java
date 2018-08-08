package com.xkcoding.scaffold.common.status;

import com.xkcoding.scaffold.common.BaseEnum;
import lombok.Getter;

/**
 * <p>
 * 逻辑删除状态枚举
 * </p>
 *
 * @package: com.xkcoding.scaffold.common.status
 * @description： 逻辑删除状态枚举
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 上午10:42
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Getter
public enum DeleteStatus implements BaseEnum {
	/**
	 * 已删除
	 */
	DELETED(1, "已删除"),

	/**
	 * 未删除
	 */
	NOT_DELETED(0, "未删除");

	private Integer code;
	private String msg;

	DeleteStatus(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
