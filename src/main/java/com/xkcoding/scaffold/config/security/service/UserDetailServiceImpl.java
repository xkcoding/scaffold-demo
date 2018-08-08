package com.xkcoding.scaffold.config.security.service;

import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Sets;
import com.xkcoding.scaffold.model.SysMenu;
import com.xkcoding.scaffold.model.SysRole;
import com.xkcoding.scaffold.model.SysUser;
import com.xkcoding.scaffold.model.dto.SysUserDTO;
import com.xkcoding.scaffold.service.SysMenuService;
import com.xkcoding.scaffold.service.SysRoleService;
import com.xkcoding.scaffold.service.SysUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 自定义用户验证
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.service
 * @description： 自定义用户验证
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 下午3:59
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysMenuService sysMenuService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 根据登录名查询用户
		SysUser loginUser = sysUserService.getUserByLoginName(username);
		if (ObjectUtil.isNull(loginUser)) {
			return new SysUserDTO();
		}

		// 根据用户查询对应角色
		List<SysRole> sysRoleList = sysRoleService.listSysRolesByUserId(loginUser.getId());

		// 根据角色查询对应菜单
		List<SysMenu> sysMenuList = sysMenuService.listSysMenusByRoleList(sysRoleList);

		// 对象转换
		SysUserDTO sysUserDTO = modelMapper.map(loginUser, SysUserDTO.class);
		sysUserDTO.setRoles(Sets.newHashSet(sysRoleList));
		sysUserDTO.setMenus(Sets.newHashSet(sysMenuList));
		return sysUserDTO;
	}
}
