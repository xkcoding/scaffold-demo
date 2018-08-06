package com.xkcoding.scaffold.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * <p>
 * 角色信息表
 * </p>
 *
 * @package: com.xkcoding.scaffold.model
 * @description： 角色信息表
 * @author: yangkai.shen
 * @date: Created in 2018/7/31 上午10:34
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Table(name = "sys_role")
public class SysRole {
	/**
	 * 角色ID
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "JDBC")
	private Integer id;

	/**
	 * 角色名称
	 */
	@Column(name = "role_name")
	private String roleName;

	/**
	 * 角色权限字符串
	 */
	@Column(name = "role_key")
	private String roleKey;

	/**
	 * 显示顺序
	 */
	@Column(name = "role_sort")
	private Integer roleSort;

	/**
	 * 角色状态（0停用 1正常）
	 */
	@Column(name = "status")
	private Integer status;

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
	 * 获取角色ID
	 *
	 * @return id - 角色ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置角色ID
	 *
	 * @param id 角色ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取角色名称
	 *
	 * @return role_name - 角色名称
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * 设置角色名称
	 *
	 * @param roleName 角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * 获取角色权限字符串
	 *
	 * @return role_key - 角色权限字符串
	 */
	public String getRoleKey() {
		return roleKey;
	}

	/**
	 * 设置角色权限字符串
	 *
	 * @param roleKey 角色权限字符串
	 */
	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

	/**
	 * 获取显示顺序
	 *
	 * @return role_sort - 显示顺序
	 */
	public Integer getRoleSort() {
		return roleSort;
	}

	/**
	 * 设置显示顺序
	 *
	 * @param roleSort 显示顺序
	 */
	public void setRoleSort(Integer roleSort) {
		this.roleSort = roleSort;
	}

	/**
	 * 获取角色状态（0停用 1正常）
	 *
	 * @return status - 角色状态（0停用 1正常）
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置角色状态（0停用 1正常）
	 *
	 * @param status 角色状态（0停用 1正常）
	 */
	public void setStatus(Integer status) {
		this.status = status;
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