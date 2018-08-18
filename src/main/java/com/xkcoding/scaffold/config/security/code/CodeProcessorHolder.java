package com.xkcoding.scaffold.config.security.code;

import com.xkcoding.scaffold.common.status.Status;
import com.xkcoding.scaffold.common.type.CodeType;
import com.xkcoding.scaffold.config.security.code.base.CodeProcessor;
import com.xkcoding.scaffold.exception.ScaffoldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <p>
 * 验证码处理器持有者
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.code
 * @description： 验证码处理器持有者
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 下午12:11
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Component
public class CodeProcessorHolder {
	@Autowired
	private Map<String, CodeProcessor> codeProcessors;

	public CodeProcessor findCodeProcessor(CodeType type) throws ScaffoldException {
		return findCodeProcessor(type.toString().toLowerCase());
	}

	public CodeProcessor findCodeProcessor(String type) throws ScaffoldException {
		String name = type.toLowerCase() + CodeProcessor.class.getSimpleName();
		CodeProcessor processor = codeProcessors.get(name);
		if (processor == null) {
			throw new ScaffoldException(Status.INTERNAL_SERVER_ERROR.getCode(), "验证码生成器" + name + "不存在");
		}
		return processor;
	}

}