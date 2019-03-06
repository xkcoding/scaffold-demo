package com.xkcoding.scaffold.mapper;

import com.xkcoding.scaffold.common.MyMapper;
import com.xkcoding.scaffold.model.SysMenu;
import com.xkcoding.scaffold.model.dto.SysMenuDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 菜单权限Mapper
 * </p>
 *
 * @package: com.xkcoding.scaffold.mapper
 * @description： 菜单权限Mapper
 * @author: yangkai.shen
 * @date: Created in 2018/7/31 上午10:51
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Repository
public interface SysMenuMapper extends MyMapper<SysMenu> {

    /**
     * 根据角色 id 列表查询菜单列表
     *
     * @param roleIdList 用户 id 列表
     * @return 菜单列表
     */
    List<SysMenu> selectSysMenuByRoleList(@Param("roleIdList") List<Integer> roleIdList);

    /**
     * 所有菜单列表，包含权限基础信息
     *
     * @param visible 菜单是否可见
     * @return 所有菜单列表，包含权限基础信息
     */
    List<SysMenuDTO> selectSysMenuList(@Param("visible") Integer visible);
}