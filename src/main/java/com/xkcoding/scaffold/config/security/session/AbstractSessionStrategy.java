package com.xkcoding.scaffold.config.security.session;

import com.xkcoding.scaffold.common.Api;
import com.xkcoding.scaffold.common.status.Status;
import com.xkcoding.scaffold.util.ServletUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * session 策略基类
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.session
 * @description： session 策略基类
 * @author: yangkai.shen
 * @date: Created in 2018/8/9 下午2:36
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Slf4j
public class AbstractSessionStrategy {

	protected void onSessionInvalid(HttpServletResponse response) {
		log.debug("【Session】session 已失效");
		if (isConcurrency()) {
			ServletUtil.renderJson(response, Api.of(Status.SESSION_INVALID.getCode(), Status.SESSION_INVALID.getMsg() + "，可能高并发引起的", null));
		} else {
			ServletUtil.renderJson(response, Api.ofStatus(Status.SESSION_INVALID));
		}

	}

	/**
	 * session失效是否是并发导致的
	 */
	protected boolean isConcurrency() {
		return false;
	}

}
