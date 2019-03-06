package com.xkcoding.scaffold.service.impl;

import com.xkcoding.scaffold.mapper.SysRoleMapper;
import com.xkcoding.scaffold.mapper.SysUserRoleMapper;
import com.xkcoding.scaffold.model.SysRole;
import com.xkcoding.scaffold.model.SysUserRole;
import com.xkcoding.scaffold.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统角色 Service
 * </p>
 *
 * @package: com.xkcoding.scaffold.service.impl
 * @description： 系统角色 Service
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 下午4:43
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 根据用户 id 获取角色列表
     *
     * @param userId 用户 id
     * @return 角色列表
     */
    @Override
    public List<SysRole> listSysRolesByUserId(Integer userId) {
        // 根据 userId 查 user-role 的对应关系
        SysUserRole query = new SysUserRole();
        query.setUserId(userId);
        List<SysUserRole> relations = sysUserRoleMapper.select(query);

        // 根据对应关系，获取角色 id 列表，查询所有role
        List<Integer> roleIdList = relations.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        List<SysRole> sysRoleList = sysRoleMapper.selectSysRoleByRoleList(roleIdList);

        return sysRoleList;
    }
}
