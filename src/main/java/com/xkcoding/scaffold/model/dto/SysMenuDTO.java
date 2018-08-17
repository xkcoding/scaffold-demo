package com.xkcoding.scaffold.model.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * <p>
 * 菜单 DTO
 * </p>
 *
 * @package: com.xkcoding.scaffold.model.dto
 * @description： 菜单 DTO
 * @author: yangkai.shen
 * @date: Created in 2018/8/17 上午10:39
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
public class SysMenuDTO {
	/**
	 * 菜单ID
	 */
	private Integer id;

	/**
	 * 菜单名称
	 */
	private String menuName;

	/**
	 * 父菜单ID
	 */
	private Integer parentId;

	/**
	 * 显示顺序
	 */
	private Integer orderNum;

	/**
	 * 请求地址
	 */
	private String url;

	/**
	 * 菜单类型（0目录 1菜单 2按钮）
	 */
	private Integer menuType;

	/**
	 * 菜单状态（0隐藏 1显示）
	 */
	private Integer visible;

	/**
	 * vue路由
	 */
	@Column(name = "path")
	private String path;

	/**
	 * vue组件
	 */
	@Column(name = "component")
	private String component;

	/**
	 * 菜单图标
	 */
	private String icon;

	/**
	 * 创建者
	 */
	private String createBy;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新者
	 */
	private String updateBy;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 角色Id列表字符串
	 */
	private String roleId;

	/**
	 * 角色名称列表字符串
	 */
	private String roleName;

	/**
	 * 角色键列表字符串
	 */
	private String roleKey;
}
