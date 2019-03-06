package com.xkcoding.scaffold.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * <p>
 * 参数配置表
 * </p>
 *
 * @package: com.xkcoding.scaffold.model
 * @description： 参数配置表
 * @author: yangkai.shen
 * @date: Created in 2018/7/31 上午10:27
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Table(name = "sys_config")
public class SysConfig {
    /**
     * 参数主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 参数名称
     */
    @Column(name = "config_name")
    private String configName;

    /**
     * 参数键名
     */
    @Column(name = "config_key")
    private String configKey;

    /**
     * 参数键值
     */
    @Column(name = "config_value")
    private String configValue;

    /**
     * 系统内置（0否 1是）
     */
    @Column(name = "config_type")
    private Integer configType;

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
     * 获取参数主键
     *
     * @return id - 参数主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置参数主键
     *
     * @param id 参数主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取参数名称
     *
     * @return config_name - 参数名称
     */
    public String getConfigName() {
        return configName;
    }

    /**
     * 设置参数名称
     *
     * @param configName 参数名称
     */
    public void setConfigName(String configName) {
        this.configName = configName;
    }

    /**
     * 获取参数键名
     *
     * @return config_key - 参数键名
     */
    public String getConfigKey() {
        return configKey;
    }

    /**
     * 设置参数键名
     *
     * @param configKey 参数键名
     */
    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    /**
     * 获取参数键值
     *
     * @return config_value - 参数键值
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * 设置参数键值
     *
     * @param configValue 参数键值
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    /**
     * 获取系统内置（0否 1是）
     *
     * @return config_type - 系统内置（0否 1是）
     */
    public Integer getConfigType() {
        return configType;
    }

    /**
     * 设置系统内置（0否 1是）
     *
     * @param configType 系统内置（0否 1是）
     */
    public void setConfigType(Integer configType) {
        this.configType = configType;
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
}