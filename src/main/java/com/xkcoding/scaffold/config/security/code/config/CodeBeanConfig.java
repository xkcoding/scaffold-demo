package com.xkcoding.scaffold.config.security.code.config;

import com.xkcoding.scaffold.common.property.ScaffoldProperties;
import com.xkcoding.scaffold.config.security.code.base.CodeGenerator;
import com.xkcoding.scaffold.config.security.code.image.ImageCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 验证码 Bean 配置类
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.code.config
 * @description： 验证码 Bean 配置类
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 下午12:17
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Configuration
public class CodeBeanConfig {
	@Autowired
	private ScaffoldProperties scaffoldProperties;

	@Bean
	@ConditionalOnMissingBean(name = "imageGenerator")
	public CodeGenerator imageCodeGenerator() {
		ImageCodeGenerator imageCodeGenerator = new ImageCodeGenerator();
		imageCodeGenerator.setScaffoldProperties(scaffoldProperties);
		return imageCodeGenerator;
	}

}
