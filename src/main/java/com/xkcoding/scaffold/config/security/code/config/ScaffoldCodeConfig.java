package com.xkcoding.scaffold.config.security.code.config;

import com.xkcoding.scaffold.common.property.ScaffoldProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 配置类
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.code.config
 * @description： 配置类
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 下午12:24
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Configuration
@EnableConfigurationProperties(ScaffoldProperties.class)
public class ScaffoldCodeConfig {
}
