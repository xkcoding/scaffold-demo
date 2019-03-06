package com.xkcoding.scaffold.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * ModelMapper 配置类
 * </p>
 *
 * @package: com.xkcoding.scaffold.config
 * @description： ModelMapper 配置类
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 下午4:28
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
