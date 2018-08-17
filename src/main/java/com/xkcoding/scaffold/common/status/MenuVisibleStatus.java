package com.xkcoding.scaffold.common.status;

import com.xkcoding.scaffold.common.BaseEnum;
import lombok.Getter;

/**
 * <p>
 * 菜单显示状态枚举
 * </p>
 *
 * @package: com.xkcoding.scaffold.common.status
 * @description： 菜单显示状态枚举
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 下午9:56
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Getter
public enum MenuVisibleStatus implements BaseEnum {
	/**
	 * 隐藏
	 */
	HIDE(0, "隐藏"),

	/**
	 * 显示
	 */
	SHOW(1, "显示");

	private Integer code;
	private String msg;

	MenuVisibleStatus(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
