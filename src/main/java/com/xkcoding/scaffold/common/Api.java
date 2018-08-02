package com.xkcoding.scaffold.common;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * API 统一返回格式封装
 * </p>
 *
 * @package: com.xkcoding.scaffold.common
 * @description： API 统一返回格式封装
 * @author: yangkai.shen
 * @date: Created in 2018/8/2 下午6:15
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
public class Api implements Serializable {

	private static final long serialVersionUID = 1672493411204459264L;

	/**
	 * 返回码
	 */
	private Integer code;

	/**
	 * 返回信息
	 */
	private String msg;

	/**
	 * 返回数据
	 */
	private Object data;

	/**
	 * 默认构造
	 */
	public Api() {
		this.code = Status.SUCCESS.getCode();
		this.msg = Status.SUCCESS.getMsg();
	}

	/**
	 * 构造 API 返回对象
	 *
	 * @param code 返回码
	 * @param msg  返回信息
	 * @param data 数据
	 */
	public Api(Integer code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * 通用构造包含返回信息的 Api <br>
	 * 主要用于只包含返回信息，不包含数据时的返回
	 *
	 * @param code 状态码
	 * @param msg  信息
	 * @return Api
	 */
	public static Api of(int code, String msg, Object data) {
		return new Api(code, msg, data);
	}

	/**
	 * 通用构造包含返回信息的 Api <br>
	 * 主要用于只包含返回信息，不包含数据时的返回
	 *
	 * @param code 状态码
	 * @param msg  信息
	 * @return Api
	 */
	public static Api ofMessage(int code, String msg) {
		return new Api(code, msg, null);
	}

	/**
	 * 通用构造包含返回信息的 Api <br>
	 * 主要用于只包含返回信息，不包含数据时的返回
	 *
	 * @param msg 信息
	 * @return Api
	 */
	public static Api ofMessage(String msg) {
		return new Api(Status.SUCCESS.getCode(), msg, null);
	}

	/**
	 * 通用构造包含返回数据的 Api <br>
	 * 主要用于操作成功时的返回(不带数据)
	 *
	 * @return Api
	 */
	public static Api ofSuccess() {
		return new Api(Status.SUCCESS.getCode(), Status.SUCCESS.getMsg(), null);
	}

	/**
	 * 通用构造包含返回数据的 Api <br>
	 * 主要用于操作成功时的返回
	 *
	 * @param data 操作成功时需要返回的数据
	 * @return Api
	 */
	public static Api ofSuccess(Object data) {
		return new Api(Status.SUCCESS.getCode(), Status.SUCCESS.getMsg(), data);
	}

	/**
	 * 通过 Status 构造 Api <br>
	 * 主要用于出现异常时的返回
	 *
	 * @param status {@link Status}
	 * @return Api
	 */
	public static Api ofStatus(Status status) {
		return new Api(status.getCode(), status.getMsg(), null);
	}

}
