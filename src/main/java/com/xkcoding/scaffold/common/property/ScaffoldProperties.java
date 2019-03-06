package com.xkcoding.scaffold.common.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 * Scaffold配置类
 * </p>
 *
 * @package: com.xkcoding.scaffold.common.property
 * @description： Scaffold配置类
 * @author: yangkai.shen
 * @date: Created in 2018/8/17 上午10:09
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@ConfigurationProperties(prefix = "scaffold")
@Data
public class ScaffoldProperties {
    /**
     * Common 配置
     */
    private CommonProperties common = new CommonProperties();

    /**
     * Security 配置
     */
    private ScaffoldSecurityProperties security = new ScaffoldSecurityProperties();

}
