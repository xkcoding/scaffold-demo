package com.xkcoding.scaffold.mapper;

import com.xkcoding.scaffold.common.MyMapper;
import com.xkcoding.scaffold.model.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色信息Mapper
 * </p>
 *
 * @package: com.xkcoding.scaffold.mapper
 * @description： 角色信息Mapper
 * @author: yangkai.shen
 * @date: Created in 2018/7/31 上午10:51
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Repository
public interface SysRoleMapper extends MyMapper<SysRole> {

    /**
     * 根据角色 id 列表查询角色列表
     *
     * @param roleIdList 用户 id 列表
     * @return 角色列表
     */
    List<SysRole> selectSysRoleByRoleList(@Param("roleIdList") List<Integer> roleIdList);
}