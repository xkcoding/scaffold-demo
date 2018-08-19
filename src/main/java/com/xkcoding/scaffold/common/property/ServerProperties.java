package com.xkcoding.scaffold.common.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 服务器配置
 * </p>
 *
 * @package: com.xkcoding.scaffold.common.property
 * @description： 服务器配置
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 下午10:18
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Configuration
@Data
public class ServerProperties {
	/**
	 * 上下文路径
	 */
	@Value("${server.servlet.context-path:/}")
	private String contextPath;

	/**
	 * 端口号
	 */
	@Value("${server.port:8080}")
	private String port;
}
