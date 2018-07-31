package com.xkcoding.scaffold.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * <p>
 * 字典类型表
 * </p>
 *
 * @package: com.xkcoding.scaffold.model
 * @description： 字典类型表
 * @author: yangkai.shen
 * @date: Created in 2018/7/31 上午10:31
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Table(name = "sys_dict_type")
public class SysDictType {
	/**
	 * 字典主键
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "JDBC")
	private Integer id;

	/**
	 * 字典名称
	 */
	@Column(name = "dict_name")
	private String dictName;

	/**
	 * 字典类型
	 */
	@Column(name = "dict_type")
	private String dictType;

	/**
	 * 状态（0停用 1正常）
	 */
	@Column(name = "status")
	private Boolean status;

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
	 * 获取字典主键
	 *
	 * @return id - 字典主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置字典主键
	 *
	 * @param id 字典主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取字典名称
	 *
	 * @return dict_name - 字典名称
	 */
	public String getDictName() {
		return dictName;
	}

	/**
	 * 设置字典名称
	 *
	 * @param dictName 字典名称
	 */
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	/**
	 * 获取字典类型
	 *
	 * @return dict_type - 字典类型
	 */
	public String getDictType() {
		return dictType;
	}

	/**
	 * 设置字典类型
	 *
	 * @param dictType 字典类型
	 */
	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	/**
	 * 获取状态（0停用 1正常）
	 *
	 * @return status - 状态（0停用 1正常）
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * 设置状态（0停用 1正常）
	 *
	 * @param status 状态（0停用 1正常）
	 */
	public void setStatus(Boolean status) {
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