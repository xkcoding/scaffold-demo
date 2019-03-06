package com.xkcoding.scaffold.mapper;

import com.xkcoding.scaffold.common.MyMapper;
import com.xkcoding.scaffold.model.SysRoleMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色和菜单关联Mapper
 * </p>
 *
 * @package: com.xkcoding.scaffold.mapper
 * @description： 角色和菜单关联Mapper
 * @author: yangkai.shen
 * @date: Created in 2018/7/31 上午10:52
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Repository
public interface SysRoleMenuMapper extends MyMapper<SysRoleMenu> {

    /**
     * 根据角色 id 列表查询角色菜单关系列表
     *
     * @param roleIdList 角色 id 列表
     * @return 角色菜单关系列表
     */
    List<SysRoleMenu> selectSysRoleMenuByRoleIdList(@Param("roleIdList") List<Integer> roleIdList);
}