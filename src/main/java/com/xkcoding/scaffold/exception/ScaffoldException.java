package com.xkcoding.scaffold.exception;

import com.xkcoding.scaffold.common.status.Status;
import lombok.Getter;

/**
 * <p>
 * 通用全局异常
 * </p>
 *
 * @package: com.xkcoding.scaffold.exception
 * @description： 通用全局异常
 * @author: yangkai.shen
 * @date: Created in 2018/8/2 下午7:59
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Getter
public class ScaffoldException extends Exception {
	/**
	 * 模块名称
	 */
	private String module;

	/**
	 * 异常码
	 */
	private Integer code;

	/**
	 * 返回内容
	 */
	private Object data;

	public ScaffoldException(Integer code, String msg) {
		super(msg);
		this.code = code;
	}

	public ScaffoldException(Integer code, String msg, Object data) {
		super(msg);
		this.code = code;
		this.data = data;
	}


	public ScaffoldException(String module, String msg, Integer code, Object data) {
		super(msg);
		this.module = module;
		this.code = code;
		this.data = data;
	}

	public ScaffoldException(Status status) {
		super(status.getMsg());
		this.code = status.getCode();
	}

	public ScaffoldException(Status status, Object data) {
		super(status.getMsg());
		this.code = status.getCode();
		this.data = data;
	}
}
