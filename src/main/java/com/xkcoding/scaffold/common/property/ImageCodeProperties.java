package com.xkcoding.scaffold.common.property;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 图片验证码配置
 * </p>
 *
 * @package: com.xkcoding.scaffold.common.property
 * @description： 图片验证码配置
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 上午11:12
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ImageCodeProperties extends SmsCodeProperties {
    /**
     * 宽度
     */
    private int width = 100;

    /**
     * 高度
     */
    private int height = 40;

    /**
     * 默认长度为4位
     */
    public ImageCodeProperties() {
        setLength(4);
    }
}
