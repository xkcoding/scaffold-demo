package com.xkcoding.scaffold.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * <p>
 * 系统访问记录
 * </p>
 *
 * @package: com.xkcoding.scaffold.model
 * @description： 系统访问记录
 * @author: yangkai.shen
 * @date: Created in 2018/7/31 上午10:33
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Table(name = "sys_login_log")
public class SysLoginLog {
	/**
	 * 访问ID
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "JDBC")
	private Integer id;

	/**
	 * 登录账号
	 */
	@Column(name = "login_name")
	private String loginName;

	/**
	 * 登录IP地址
	 */
	@Column(name = "ip_address")
	private String ipAddress;

	/**
	 * 登录地点
	 */
	@Column(name = "login_location")
	private String loginLocation;

	/**
	 * 浏览器类型
	 */
	@Column(name = "browser")
	private String browser;

	/**
	 * 操作系统
	 */
	@Column(name = "os")
	private String os;

	/**
	 * 登录状态（0失败 1成功）
	 */
	@Column(name = "status")
	private Integer status;

	/**
	 * 提示消息
	 */
	@Column(name = "msg")
	private String msg;

	/**
	 * 访问时间
	 */
	@Column(name = "login_time")
	private Date loginTime;

	/**
	 * 获取访问ID
	 *
	 * @return id - 访问ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置访问ID
	 *
	 * @param id 访问ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取登录账号
	 *
	 * @return login_name - 登录账号
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * 设置登录账号
	 *
	 * @param loginName 登录账号
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * 获取登录IP地址
	 *
	 * @return ip_address - 登录IP地址
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * 设置登录IP地址
	 *
	 * @param ipAddress 登录IP地址
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * 获取登录地点
	 *
	 * @return login_location - 登录地点
	 */
	public String getLoginLocation() {
		return loginLocation;
	}

	/**
	 * 设置登录地点
	 *
	 * @param loginLocation 登录地点
	 */
	public void setLoginLocation(String loginLocation) {
		this.loginLocation = loginLocation;
	}

	/**
	 * 获取浏览器类型
	 *
	 * @return browser - 浏览器类型
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * 设置浏览器类型
	 *
	 * @param browser 浏览器类型
	 */
	public void setBrowser(String browser) {
		this.browser = browser;
	}

	/**
	 * 获取操作系统
	 *
	 * @return os - 操作系统
	 */
	public String getOs() {
		return os;
	}

	/**
	 * 设置操作系统
	 *
	 * @param os 操作系统
	 */
	public void setOs(String os) {
		this.os = os;
	}

	/**
	 * 获取登录状态（0失败 1成功）
	 *
	 * @return status - 登录状态（0失败 1成功）
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置登录状态（0失败 1成功）
	 *
	 * @param status 登录状态（0失败 1成功）
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取提示消息
	 *
	 * @return msg - 提示消息
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 设置提示消息
	 *
	 * @param msg 提示消息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 获取访问时间
	 *
	 * @return login_time - 访问时间
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * 设置访问时间
	 *
	 * @param loginTime 访问时间
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
}