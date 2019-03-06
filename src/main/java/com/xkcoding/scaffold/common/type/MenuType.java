package com.xkcoding.scaffold.common.type;

import com.xkcoding.scaffold.common.BaseEnum;
import lombok.Getter;

/**
 * <p>
 * 菜单类型枚举
 * </p>
 *
 * @package: com.xkcoding.scaffold.common.status
 * @description： 菜单类型枚举
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 下午9:56
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Getter
public enum MenuType implements BaseEnum {
    /**
     * 目录
     */
    directory(0, "目录"),

    /**
     * 菜单
     */
    menu(1, "菜单"),

    /**
     * 按钮
     */
    button(2, "按钮");

    private Integer code;
    private String msg;

    MenuType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }}
