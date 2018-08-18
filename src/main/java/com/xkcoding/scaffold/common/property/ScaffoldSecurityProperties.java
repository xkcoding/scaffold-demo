package com.xkcoding.scaffold.common.property;

import lombok.Data;

/**
 * <p>
 * Security 配置
 * </p>
 *
 * @package: com.xkcoding.scaffold.common.property
 * @description： Security 配置
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 上午11:21
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
public class ScaffoldSecurityProperties {
	/**
	 * 验证码配置
	 */
	private CodeProperties code = new CodeProperties();
}
