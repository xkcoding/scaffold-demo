package com.xkcoding.scaffold.common.status;

import com.xkcoding.scaffold.common.BaseEnum;
import lombok.Getter;

/**
 * <p>
 * 用户状态枚举
 * </p>
 *
 * @package: com.xkcoding.scaffold.common.status
 * @description： 用户状态枚举
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 上午10:26
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Getter
public enum UserStatus implements BaseEnum {
    /**
     * 启用
     */
    ENABLE(1, "启用"),

    /**
     * 禁用
     */
    DISABLE(0, "禁用");

    private Integer code;
    private String msg;

    UserStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }}
