package com.xkcoding.scaffold.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * <p>
 * 岗位信息表
 * </p>
 *
 * @package: com.xkcoding.scaffold.model
 * @description： 岗位信息表
 * @author: yangkai.shen
 * @date: Created in 2018/7/31 上午10:35
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Table(name = "sys_work")
public class SysWork {
	/**
	 * 岗位ID
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "JDBC")
	private Integer id;

	/**
	 * 岗位编码
	 */
	@Column(name = "job_code")
	private String jobCode;

	/**
	 * 岗位名称
	 */
	@Column(name = "job_name")
	private String jobName;

	/**
	 * 显示顺序
	 */
	@Column(name = "job_sort")
	private Integer jobSort;

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
	 * 获取岗位ID
	 *
	 * @return id - 岗位ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置岗位ID
	 *
	 * @param id 岗位ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取岗位编码
	 *
	 * @return job_code - 岗位编码
	 */
	public String getJobCode() {
		return jobCode;
	}

	/**
	 * 设置岗位编码
	 *
	 * @param jobCode 岗位编码
	 */
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	/**
	 * 获取岗位名称
	 *
	 * @return job_name - 岗位名称
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * 设置岗位名称
	 *
	 * @param jobName 岗位名称
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * 获取显示顺序
	 *
	 * @return job_sort - 显示顺序
	 */
	public Integer getJobSort() {
		return jobSort;
	}

	/**
	 * 设置显示顺序
	 *
	 * @param jobSort 显示顺序
	 */
	public void setJobSort(Integer jobSort) {
		this.jobSort = jobSort;
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