package com.xkcoding.scaffold.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @package: com.xkcoding.scaffold.model
 * @description： 用户信息表
 * @author: yangkai.shen
 * @date: Created in 2018/7/31 上午10:34
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Table(name = "sys_user")
public class SysUser {
	/**
	 * 用户ID
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "JDBC")
	private Integer id;

	/**
	 * 部门ID
	 */
	@Column(name = "dept_id")
	private Integer deptId;

	/**
	 * 登录账号
	 */
	@Column(name = "login_name")
	private String loginName;

	/**
	 * 用户昵称
	 */
	@Column(name = "user_name")
	private String userName;

	/**
	 * 用户类型（00系统用户）
	 */
	@Column(name = "user_type")
	private String userType;

	/**
	 * 用户邮箱
	 */
	@Column(name = "email")
	private String email;

	/**
	 * 手机号码
	 */
	@Column(name = "phonenumber")
	private String phonenumber;

	/**
	 * 用户性别（0男 1女 2未知）
	 */
	@Column(name = "sex")
	private Boolean sex;

	/**
	 * 头像路径
	 */
	@Column(name = "avatar")
	private String avatar;

	/**
	 * 密码
	 */
	@Column(name = "PASSWORD")
	private String password;

	/**
	 * 帐号状态（0停用 1正常）
	 */
	@Column(name = "status")
	private Boolean status;

	/**
	 * 删除标志（0代表存在 1代表删除）
	 */
	@Column(name = "del_flag")
	private Boolean delFlag;

	/**
	 * 最后登陆IP
	 */
	@Column(name = "login_ip")
	private String loginIp;

	/**
	 * 最后登陆时间
	 */
	@Column(name = "login_date")
	private Date loginDate;

	/**
	 * 创建者
	 */
	@Column(name = "create_by")
	private String createBy;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time")
	private Date createTime;

	/**
	 * 更新者
	 */
	@Column(name = "update_by")
	private String updateBy;

	/**
	 * 更新时间
	 */
	@Column(name = "update_time")
	private Date updateTime;

	/**
	 * 备注
	 */
	@Column(name = "remark")
	private String remark;

	/**
	 * 获取用户ID
	 *
	 * @return id - 用户ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置用户ID
	 *
	 * @param id 用户ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取部门ID
	 *
	 * @return dept_id - 部门ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * 设置部门ID
	 *
	 * @param deptId 部门ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
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
	 * 获取用户昵称
	 *
	 * @return user_name - 用户昵称
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置用户昵称
	 *
	 * @param userName 用户昵称
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取用户类型（00系统用户）
	 *
	 * @return user_type - 用户类型（00系统用户）
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * 设置用户类型（00系统用户）
	 *
	 * @param userType 用户类型（00系统用户）
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * 获取用户邮箱
	 *
	 * @return email - 用户邮箱
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置用户邮箱
	 *
	 * @param email 用户邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取手机号码
	 *
	 * @return phonenumber - 手机号码
	 */
	public String getPhonenumber() {
		return phonenumber;
	}

	/**
	 * 设置手机号码
	 *
	 * @param phonenumber 手机号码
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	/**
	 * 获取用户性别（0男 1女 2未知）
	 *
	 * @return sex - 用户性别（0男 1女 2未知）
	 */
	public Boolean getSex() {
		return sex;
	}

	/**
	 * 设置用户性别（0男 1女 2未知）
	 *
	 * @param sex 用户性别（0男 1女 2未知）
	 */
	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	/**
	 * 获取头像路径
	 *
	 * @return avatar - 头像路径
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * 设置头像路径
	 *
	 * @param avatar 头像路径
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * 获取密码
	 *
	 * @return PASSWORD - 密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码
	 *
	 * @param password 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取帐号状态（0停用 1正常）
	 *
	 * @return status - 帐号状态（0停用 1正常）
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * 设置帐号状态（0停用 1正常）
	 *
	 * @param status 帐号状态（0停用 1正常）
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * 获取删除标志（0代表存在 1代表删除）
	 *
	 * @return del_flag - 删除标志（0代表存在 1代表删除）
	 */
	public Boolean getDelFlag() {
		return delFlag;
	}

	/**
	 * 设置删除标志（0代表存在 1代表删除）
	 *
	 * @param delFlag 删除标志（0代表存在 1代表删除）
	 */
	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * 获取最后登陆IP
	 *
	 * @return login_ip - 最后登陆IP
	 */
	public String getLoginIp() {
		return loginIp;
	}

	/**
	 * 设置最后登陆IP
	 *
	 * @param loginIp 最后登陆IP
	 */
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	/**
	 * 获取最后登陆时间
	 *
	 * @return login_date - 最后登陆时间
	 */
	public Date getLoginDate() {
		return loginDate;
	}

	/**
	 * 设置最后登陆时间
	 *
	 * @param loginDate 最后登陆时间
	 */
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	/**
	 * 获取创建者
	 *
	 * @return create_by - 创建者
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * 设置创建者
	 *
	 * @param createBy 创建者
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * 获取创建时间
	 *
	 * @return create_time - 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 *
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取更新者
	 *
	 * @return update_by - 更新者
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * 设置更新者
	 *
	 * @param updateBy 更新者
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 获取更新时间
	 *
	 * @return update_time - 更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置更新时间
	 *
	 * @param updateTime 更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取备注
	 *
	 * @return remark - 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置备注
	 *
	 * @param remark 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
}