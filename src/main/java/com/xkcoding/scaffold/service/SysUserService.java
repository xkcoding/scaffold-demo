package com.xkcoding.scaffold.service;

import com.xkcoding.scaffold.model.SysUser;

/**
 * <p>
 * 系统用户 Service
 * </p>
 *
 * @package: com.xkcoding.scaffold.service
 * @description： 系统用户 Service
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 下午3:49
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public interface SysUserService {

    /**
     * 根据用户名（登录名）获取用户信息
     *
     * @param loginName 登录名
     * @return 用户对象
     */
    SysUser getUserByLoginName(String loginName);
}
