package com.xkcoding.scaffold.handler;

import com.xkcoding.scaffold.common.Api;
import com.xkcoding.scaffold.common.status.Status;
import com.xkcoding.scaffold.exception.ScaffoldException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 全局异常处理
 * </p>
 *
 * @package: com.xkcoding.scaffold.handler
 * @description： 全局异常处理
 * @author: yangkai.shen
 * @date: Created in 2018/8/2 下午8:05
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Api handlerException(Exception e) {
		if (e instanceof ScaffoldException) {
			log.error("【全局异常拦截】ScaffoldException: 状态码 {}, 异常信息 {}", ((ScaffoldException) e).getCode(), e.getMessage());
			return new Api(((ScaffoldException) e).getCode(), e.getMessage(), ((ScaffoldException) e).getData());
		} else if (e instanceof AccessDeniedException) {
			log.error("【全局异常拦截】AccessDeniedException: 异常信息 {}", ((AccessDeniedException) e).getMessage());
			return Api.ofStatus(Status.FORBIDDEN);
		}
		log.error("【全局异常拦截】: 异常信息 {} ", e.getMessage());
		return Api.ofStatus(Status.INTERNAL_SERVER_ERROR);
	}
}
