package com.xkcoding.scaffold.config.security.service;

import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Sets;
import com.xkcoding.scaffold.common.status.DeleteStatus;
import com.xkcoding.scaffold.common.status.LogStatus;
import com.xkcoding.scaffold.common.status.Status;
import com.xkcoding.scaffold.common.status.UserStatus;
import com.xkcoding.scaffold.model.SysMenu;
import com.xkcoding.scaffold.model.SysRole;
import com.xkcoding.scaffold.model.SysUser;
import com.xkcoding.scaffold.model.dto.SysUserDTO;
import com.xkcoding.scaffold.service.SysMenuService;
import com.xkcoding.scaffold.service.SysRoleService;
import com.xkcoding.scaffold.service.SysUserService;
import com.xkcoding.scaffold.util.EnumUtil;
import com.xkcoding.scaffold.util.LoginLogUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
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
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysMenuService sysMenuService;

	/**
	 * 根据登录名查询用户信息，账号异常时保存日志信息
	 *
	 * @param username 用户名
	 * @return {@link SysUserDTO}
	 * @throws UsernameNotFoundException 账号不存在
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 根据登录名查询用户
		SysUser loginUser = sysUserService.getUserByLoginName(username);

		// 账号不存在
		if (ObjectUtil.isNull(loginUser)) {
			throw new UsernameNotFoundException(Status.USER_NOT_EXIST.getCode() + "");
		}

		// 账号逻辑删除
		DeleteStatus deleteStatus = EnumUtil.getStatusByCode(loginUser.getDelFlag(), DeleteStatus.class);
		if (ObjectUtil.equal(deleteStatus, DeleteStatus.DELETED)) {
			LoginLogUtil.saveLog(username, Status.USER_DELETED, LogStatus.ERROR);
			throw new DisabledException(Status.USER_DELETED.getCode() + "");
		}

		// 账号禁用
		UserStatus userStatus = EnumUtil.getStatusByCode(loginUser.getStatus(), UserStatus.class);
		if (ObjectUtil.equal(userStatus, UserStatus.DISABLE)) {
			LoginLogUtil.saveLog(username, Status.USER_DISABLE, LogStatus.ERROR);
			throw new LockedException(Status.USER_DISABLE.getCode() + "");
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
