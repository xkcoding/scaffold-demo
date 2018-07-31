package com.xkcoding.scaffold.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * <p>
 * 操作日志记录
 * </p>
 *
 * @package: com.xkcoding.scaffold.model
 * @description： 操作日志记录
 * @author: yangkai.shen
 * @date: Created in 2018/7/31 上午10:33
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Table(name = "sys_operation_log")
public class SysOperationLog {
	/**
	 * 日志主键
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "JDBC")
	private Integer id;

	/**
	 * 模块标题
	 */
	@Column(name = "title")
	private String title;

	/**
	 * 功能请求
	 */
	@Column(name = "action")
	private String action;

	/**
	 * 方法名称
	 */
	@Column(name = "method")
	private String method;

	/**
	 * 操作人员
	 */
	@Column(name = "oper_name")
	private String operName;

	/**
	 * 部门名称
	 */
	@Column(name = "dept_name")
	private String deptName;

	/**
	 * 请求URL
	 */
	@Column(name = "oper_url")
	private String operUrl;

	/**
	 * 主机地址
	 */
	@Column(name = "oper_ip")
	private String operIp;

	/**
	 * 操作地点
	 */
	@Column(name = "oper_location")
	private String operLocation;

	/**
	 * 请求参数
	 */
	@Column(name = "oper_param")
	private String operParam;

	/**
	 * 操作状态（0异常 1正常）
	 */
	@Column(name = "status")
	private Boolean status;

	/**
	 * 错误消息
	 */
	@Column(name = "error_msg")
	private String errorMsg;

	/**
	 * 操作时间
	 */
	@Column(name = "oper_time")
	private Date operTime;

	/**
	 * 获取日志主键
	 *
	 * @return id - 日志主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置日志主键
	 *
	 * @param id 日志主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取模块标题
	 *
	 * @return title - 模块标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置模块标题
	 *
	 * @param title 模块标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取功能请求
	 *
	 * @return action - 功能请求
	 */
	public String getAction() {
		return action;
	}

	/**
	 * 设置功能请求
	 *
	 * @param action 功能请求
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * 获取方法名称
	 *
	 * @return method - 方法名称
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * 设置方法名称
	 *
	 * @param method 方法名称
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * 获取操作人员
	 *
	 * @return oper_name - 操作人员
	 */
	public String getOperName() {
		return operName;
	}

	/**
	 * 设置操作人员
	 *
	 * @param operName 操作人员
	 */
	public void setOperName(String operName) {
		this.operName = operName;
	}

	/**
	 * 获取部门名称
	 *
	 * @return dept_name - 部门名称
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * 设置部门名称
	 *
	 * @param deptName 部门名称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * 获取请求URL
	 *
	 * @return oper_url - 请求URL
	 */
	public String getOperUrl() {
		return operUrl;
	}

	/**
	 * 设置请求URL
	 *
	 * @param operUrl 请求URL
	 */
	public void setOperUrl(String operUrl) {
		this.operUrl = operUrl;
	}

	/**
	 * 获取主机地址
	 *
	 * @return oper_ip - 主机地址
	 */
	public String getOperIp() {
		return operIp;
	}

	/**
	 * 设置主机地址
	 *
	 * @param operIp 主机地址
	 */
	public void setOperIp(String operIp) {
		this.operIp = operIp;
	}

	/**
	 * 获取操作地点
	 *
	 * @return oper_location - 操作地点
	 */
	public String getOperLocation() {
		return operLocation;
	}

	/**
	 * 设置操作地点
	 *
	 * @param operLocation 操作地点
	 */
	public void setOperLocation(String operLocation) {
		this.operLocation = operLocation;
	}

	/**
	 * 获取请求参数
	 *
	 * @return oper_param - 请求参数
	 */
	public String getOperParam() {
		return operParam;
	}

	/**
	 * 设置请求参数
	 *
	 * @param operParam 请求参数
	 */
	public void setOperParam(String operParam) {
		this.operParam = operParam;
	}

	/**
	 * 获取操作状态（0异常 1正常）
	 *
	 * @return status - 操作状态（0异常 1正常）
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * 设置操作状态（0异常 1正常）
	 *
	 * @param status 操作状态（0异常 1正常）
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * 获取错误消息
	 *
	 * @return error_msg - 错误消息
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * 设置错误消息
	 *
	 * @param errorMsg 错误消息
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * 获取操作时间
	 *
	 * @return oper_time - 操作时间
	 */
	public Date getOperTime() {
		return operTime;
	}

	/**
	 * 设置操作时间
	 *
	 * @param operTime 操作时间
	 */
	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}
}