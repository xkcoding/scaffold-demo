package com.xkcoding.scaffold.common.property;

import lombok.Data;

/**
 * <p>
 * 验证码配置
 * </p>
 *
 * @package: com.xkcoding.scaffold.common.property
 * @description： 验证码配置
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 上午11:11
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
public class CodeProperties {
    /**
     * 图片验证码配置
     */
    private ImageCodeProperties image = new ImageCodeProperties();

    /**
     * 短信验证码配置
     */
    private SmsCodeProperties sms = new SmsCodeProperties();
}
