package com.xkcoding.scaffold.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * 用户与岗位关联表  用户1-N岗位
 * </p>
 *
 * @package: com.xkcoding.scaffold.model
 * @description： 用户与岗位关联表  用户1-N岗位
 * @author: yangkai.shen
 * @date: Created in 2018/7/31 上午10:35
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Table(name = "sys_user_work")
public class SysUserWork {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 岗位ID
     */
    @Id
    @Column(name = "work_id")
    private String workId;

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取岗位ID
     *
     * @return work_id - 岗位ID
     */
    public String getWorkId() {
        return workId;
    }

    /**
     * 设置岗位ID
     *
     * @param workId 岗位ID
     */
    public void setWorkId(String workId) {
        this.workId = workId;
    }
}