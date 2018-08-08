package com.xkcoding.scaffold.service;

import com.xkcoding.scaffold.model.SysRole;

import java.util.List;

/**
 * <p>
 * 系统角色 Service
 * </p>
 *
 * @package: com.xkcoding.scaffold.service
 * @description： 系统角色 Service
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 下午4:37
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public interface SysRoleService {

	/**
	 * 根据用户 id 获取角色列表
	 *
	 * @param userId 用户 id
	 * @return 角色列表
	 */
	List<SysRole> listSysRolesByUserId(Integer userId);
}
