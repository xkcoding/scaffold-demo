package com.xkcoding.scaffold.model;

import javax.persistence.*;

/**
 * <p>
 * 角色和菜单关联表  角色1-N菜单
 * </p>
 *
 * @package: com.xkcoding.scaffold.model
 * @description： 角色和菜单关联表  角色1-N菜单
 * @author: yangkai.shen
 * @date: Created in 2018/7/31 上午10:34
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Table(name = "sys_role_menu")
public class SysRoleMenu {
    /**
     * 角色ID
     */
    @Id
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 菜单ID
     */
    @Id
    @Column(name = "menu_id")
    private Integer menuId;

    /**
     * 获取角色ID
     *
     * @return role_id - 角色ID
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取菜单ID
     *
     * @return menu_id - 菜单ID
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单ID
     *
     * @param menuId 菜单ID
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}