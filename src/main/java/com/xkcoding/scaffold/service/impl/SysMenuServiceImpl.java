package com.xkcoding.scaffold.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.google.common.collect.Lists;
import com.xkcoding.scaffold.mapper.SysMenuMapper;
import com.xkcoding.scaffold.mapper.SysRoleMenuMapper;
import com.xkcoding.scaffold.model.SysMenu;
import com.xkcoding.scaffold.model.SysRole;
import com.xkcoding.scaffold.model.SysRoleMenu;
import com.xkcoding.scaffold.model.dto.SysMenuDTO;
import com.xkcoding.scaffold.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统菜单 Service
 * </p>
 *
 * @package: com.xkcoding.scaffold.service.impl
 * @description： 系统菜单 Service
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 下午5:09
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenuMapper sysMenuMapper;

	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;

	/**
	 * 根据角色 id 获取菜单列表
	 *
	 * @param roleId 角色 id
	 * @return 菜单列表
	 */
	@Override
	public List<SysMenu> listSysMenusByRoleId(Integer roleId) {
		// 根据 roleId 查 menu-role 的对应关系
		SysRoleMenu query = new SysRoleMenu();
		query.setRoleId(roleId);
		List<SysRoleMenu> relations = sysRoleMenuMapper.select(query);

		// 根据对应关系，获取角色 id 列表，查询所有role
		return getMenusByRelations(relations);
	}

	/**
	 * 根据角色列表获取菜单列表
	 *
	 * @param roleList 角色列表
	 * @return 菜单列表
	 */
	@Override
	public List<SysMenu> listSysMenusByRoleList(List<SysRole> roleList) {
		List<Integer> roleIdList = roleList.stream().map(SysRole::getId).collect(Collectors.toList());

		// 根据角色 id 列表查询 menu-role 的对应关系
		List<SysRoleMenu> relations = Lists.newArrayList();
		if (CollUtil.isNotEmpty(roleIdList)) {
			relations.addAll(sysRoleMenuMapper.selectSysRoleMenuByRoleIdList(roleIdList));
		}

		// 根据对应关系，获取角色 id 列表，查询所有role
		return getMenusByRelations(relations);
	}

	/**
	 * 菜单列表 包含权限基础信息
	 *
	 * @param visible 菜单是否可见
	 * @return 菜单列表
	 */
	@Override
	public List<SysMenuDTO> listAllSysMenu(Integer visible) {
		return sysMenuMapper.selectSysMenuList(visible);
	}

	/**
	 * 根据 role-menu 的对应关系获取菜单列表
	 *
	 * @param relations 对应关系
	 * @return 菜单列表
	 */
	private List<SysMenu> getMenusByRelations(List<SysRoleMenu> relations) {
		if (CollUtil.isEmpty(relations)) {
			return Lists.newArrayList();
		}
		// 根据对应关系，获取角色 id 列表，查询所有role
		List<Integer> menuIdList = relations.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
		return sysMenuMapper.selectSysMenuByRoleList(menuIdList);
	}
}
