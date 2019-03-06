package com.xkcoding.scaffold.model.dto;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import com.xkcoding.scaffold.common.status.DeleteStatus;
import com.xkcoding.scaffold.common.status.UserStatus;
import com.xkcoding.scaffold.model.SysMenu;
import com.xkcoding.scaffold.model.SysRole;
import com.xkcoding.scaffold.util.EnumUtil;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * <p>
 * 用户 DTO
 * </p>
 *
 * @package: com.xkcoding.scaffold.model.dto
 * @description： 用户 DTO
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 上午10:18
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
public class SysUserDTO implements UserDetails {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 部门ID
     */
    private Integer deptId;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户类型（00系统用户）
     */
    private String userType;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phonenumber;

    /**
     * 用户性别（0男 1女 2未知）
     */
    private Integer sex;

    /**
     * 头像路径
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 帐号状态（0停用 1正常）
     */
    private Integer status;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private Integer delFlag;

    /**
     * 最后登陆IP
     */
    private String loginIp;

    /**
     * 最后登陆时间
     */
    private Date loginDate;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 角色列表
     */
    private Set<SysRole> roles;

    /**
     * 菜单列表
     */
    private Set<SysMenu> menus;

    /**
     * 权限列表
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = Sets.newHashSet();
        for (SysRole role : roles) {
            if (StrUtil.isNotBlank(role.getRoleKey())) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + StrUtil.trim(role.getRoleKey())));
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return loginName;
    }

    /**
     * 账户是否未过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否未锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        UserStatus userStatus = EnumUtil.getStatusByCode(status, UserStatus.class);
        return ObjectUtil.equal(userStatus, UserStatus.ENABLE);
    }

    /**
     * 密码是否未过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账户是否可用
     */
    @Override
    public boolean isEnabled() {
        DeleteStatus deleteStatus = EnumUtil.getStatusByCode(delFlag, DeleteStatus.class);
        return ObjectUtil.equal(deleteStatus, DeleteStatus.NOT_DELETED);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SysUserDTO)) {
            return false;
        }
        SysUserDTO that = (SysUserDTO) o;
        return Objects.equal(getId(), that.getId()) && Objects.equal(getDeptId(), that.getDeptId()) && Objects.equal(getLoginName(), that
                .getLoginName()) && Objects.equal(userName, that.userName) && Objects.equal(getUserType(), that.getUserType()) && Objects
                .equal(getEmail(), that.getEmail()) && Objects.equal(getPhonenumber(), that.getPhonenumber()) && Objects
                .equal(getSex(), that.getSex()) && Objects.equal(getAvatar(), that.getAvatar()) && Objects.equal(getPassword(), that
                .getPassword()) && Objects.equal(getStatus(), that.getStatus()) && Objects.equal(getDelFlag(), that.getDelFlag()) && Objects
                .equal(getLoginIp(), that.getLoginIp()) && Objects.equal(getLoginDate(), that.getLoginDate()) && Objects
                .equal(getCreateBy(), that.getCreateBy()) && Objects.equal(getCreateTime(), that.getCreateTime()) && Objects
                .equal(getUpdateBy(), that.getUpdateBy()) && Objects.equal(getUpdateTime(), that.getUpdateTime()) && Objects
                .equal(getRemark(), that.getRemark());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getDeptId(), getLoginName(), userName, getUserType(), getEmail(), getPhonenumber(), getSex(), getAvatar(), getPassword(), getStatus(), getDelFlag(), getLoginIp(), getLoginDate(), getCreateBy(), getCreateTime(), getUpdateBy(), getUpdateTime(), getRemark());
    }
}
