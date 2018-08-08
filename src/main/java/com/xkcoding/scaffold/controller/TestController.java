package com.xkcoding.scaffold.controller;

import cn.hutool.core.util.ObjectUtil;
import com.xkcoding.scaffold.aspectj.annotation.Log;
import com.xkcoding.scaffold.aspectj.constant.ActionType;
import com.xkcoding.scaffold.common.Api;
import com.xkcoding.scaffold.common.status.Status;
import com.xkcoding.scaffold.exception.ScaffoldException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 测试 Controller
 * </p>
 *
 * @package: com.xkcoding.scaffold.controller
 * @description： 测试 Controller
 * @author: yangkai.shen
 * @date: Created in 2018/8/6 下午6:37
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

	/**
	 * 测试 AOP 记录操作日志
	 *
	 * @param hasError 是否有错误
	 * @return {@link Api}
	 * @throws ScaffoldException 全局异常
	 */
	@Log(title = "测试日志", action = ActionType.OTHER)
	@GetMapping("/operate/log")
	public Api testOperateLog(Boolean hasError) throws ScaffoldException {
		log.info("【测试】AOP 记录操作日志");
		if (ObjectUtil.isNotNull(hasError) && hasError) {
			simulateException();
		}
		return Api.ofSuccess();
	}

	/**
	 * 模拟异常
	 *
	 * @throws ScaffoldException 全局异常{@link Status#INTERNAL_SERVER_ERROR}
	 */
	private void simulateException() throws ScaffoldException {
		log.error("【测试】AOP 记录操作日志，发生异常！");
		throw new ScaffoldException(Status.INTERNAL_SERVER_ERROR);
	}
}
