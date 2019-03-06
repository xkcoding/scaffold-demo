package com.xkcoding.scaffold.common.property;

import lombok.Data;

/**
 * <p>
 * 通用配置
 * </p>
 *
 * @package: com.xkcoding.scaffold.common.property
 * @description： 通用配置
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 上午11:23
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
public class CommonProperties {
    /**
     * 应用名
     */
    private String name;

    /**
     * 应用版本
     */
    private String version;

    /**
     * 版权年份
     */
    private String copyrightYear;

    /**
     * 开发者
     */
    private String developer;
}
