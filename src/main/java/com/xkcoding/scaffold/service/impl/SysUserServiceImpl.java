package com.xkcoding.scaffold.service.impl;

import com.xkcoding.scaffold.mapper.SysUserMapper;
import com.xkcoding.scaffold.model.SysUser;
import com.xkcoding.scaffold.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 Service
 * </p>
 *
 * @package: com.xkcoding.scaffold.service.impl
 * @description： 系统用户 Service
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 下午3:53
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserMapper sysUserMapper;

	/**
	 * 根据用户名（登录名）获取用户信息
	 *
	 * @param loginName 登录名
	 * @return 用户对象
	 */
	@Override
	public SysUser getUserByLoginName(String loginName) {
		SysUser query = new SysUser();
		query.setLoginName(loginName);
		return sysUserMapper.selectOne(query);
	}
}
