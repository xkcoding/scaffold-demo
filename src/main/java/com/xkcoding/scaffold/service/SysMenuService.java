package com.xkcoding.scaffold.service;

import com.xkcoding.scaffold.model.SysMenu;
import com.xkcoding.scaffold.model.SysRole;
import com.xkcoding.scaffold.model.dto.SysMenuDTO;

import java.util.List;

/**
 * <p>
 * 系统菜单 Service
 * </p>
 *
 * @package: com.xkcoding.scaffold.service
 * @description： 系统菜单 Service
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 下午4:37
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public interface SysMenuService {

	/**
	 * 根据角色 id 获取菜单列表
	 *
	 * @param roleId 角色 id
	 * @return 菜单列表
	 */
	List<SysMenu> listSysMenusByRoleId(Integer roleId);

	/**
	 * 根据角色列表获取菜单列表
	 *
	 * @param roleList 角色列表
	 * @return 菜单列表
	 */
	List<SysMenu> listSysMenusByRoleList(List<SysRole> roleList);

	/**
	 * 菜单列表 包含权限基础信息
	 *
	 * @param visible 菜单是否可见
	 * @return 菜单列表
	 */
	List<SysMenuDTO> listAllSysMenu(Integer visible);
}
