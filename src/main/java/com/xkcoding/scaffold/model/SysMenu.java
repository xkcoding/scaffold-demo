package com.xkcoding.scaffold.model;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @package: com.xkcoding.scaffold.model
 * @description： 菜单权限表
 * @author: yangkai.shen
 * @date: Created in 2018/7/31 上午10:33
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Table(name = "sys_menu")
public class SysMenu {
    /**
     * 菜单ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 父菜单ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 显示顺序
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 请求地址
     */
    @Column(name = "url")
    private String url;

    /**
     * 菜单类型（0目录 1菜单 2按钮）
     */
    @Column(name = "menu_type")
    private Integer menuType;

    /**
     * 菜单状态（0隐藏 1显示）
     */
    @Column(name = "visible")
    private Integer visible;

    /**
     * vue路由
     */
    @Column(name = "path")
    private String path;

    /**
     * vue组件
     */
    @Column(name = "component")
    private String component;

    /**
     * 菜单图标
     */
    @Column(name = "icon")
    private String icon;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 获取菜单ID
     *
     * @return id - 菜单ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置菜单ID
     *
     * @param id 菜单ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取菜单名称
     *
     * @return menu_name - 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 获取父菜单ID
     *
     * @return parent_id - 父菜单ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父菜单ID
     *
     * @param parentId 父菜单ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取显示顺序
     *
     * @return order_num - 显示顺序
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 设置显示顺序
     *
     * @param orderNum 显示顺序
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取请求地址
     *
     * @return url - 请求地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置请求地址
     *
     * @param url 请求地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取菜单类型（0目录 1菜单 2按钮）
     *
     * @return menu_type - 菜单类型（0目录 1菜单 2按钮）
     */
    public Integer getMenuType() {
        return menuType;
    }

    /**
     * 设置菜单类型（0目录 1菜单 2按钮）
     *
     * @param menuType 菜单类型（0目录 1菜单 2按钮）
     */
    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    /**
     * 获取菜单状态（0隐藏 1显示）
     *
     * @return visible - 菜单状态（0隐藏 1显示）
     */
    public Integer getVisible() {
        return visible;
    }

    /**
     * 设置菜单状态（0隐藏 1显示）
     *
     * @param visible 菜单状态（0隐藏 1显示）
     */
    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    /**
     * 获取vue路由
     *
     * @return path - vue路由
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置vue路由
     *
     * @param path vue路由
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取权限标识
     *
     * @return component - 权限标识
     */
    public String getComponent() {
        return component;
    }

    /**
     * 设置vue组件
     *
     * @param component vue组件
     */
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * 获取菜单图标
     *
     * @return icon - 菜单图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置菜单图标
     *
     * @param icon 菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SysMenu)) {
            return false;
        }
        SysMenu sysMenu = (SysMenu) o;
        return Objects.equal(getId(), sysMenu.getId()) && Objects.equal(getMenuName(), sysMenu.getMenuName()) && Objects
                .equal(getParentId(), sysMenu.getParentId()) && Objects.equal(getOrderNum(), sysMenu.getOrderNum()) && Objects
                .equal(getUrl(), sysMenu.getUrl()) && Objects.equal(getMenuType(), sysMenu.getMenuType()) && Objects.equal(getVisible(), sysMenu
                .getVisible()) && Objects.equal(getComponent(), sysMenu.getComponent()) && Objects.equal(getIcon(), sysMenu
                .getIcon()) && Objects.equal(getCreateBy(), sysMenu.getCreateBy()) && Objects.equal(getCreateTime(), sysMenu
                .getCreateTime()) && Objects.equal(getUpdateBy(), sysMenu.getUpdateBy()) && Objects.equal(getUpdateTime(), sysMenu
                .getUpdateTime()) && Objects.equal(getRemark(), sysMenu.getRemark());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getMenuName(), getParentId(), getOrderNum(), getUrl(), getMenuType(), getVisible(), getComponent(), getIcon(), getCreateBy(), getCreateTime(), getUpdateBy(), getUpdateTime(), getRemark());
    }
}