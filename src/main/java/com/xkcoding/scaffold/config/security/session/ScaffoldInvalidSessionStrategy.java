package com.xkcoding.scaffold.config.security.session;

import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * Session 失效策略
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.session
 * @description： Session 失效策略
 * @author: yangkai.shen
 * @date: Created in 2018/8/9 下午2:45
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Component
public class ScaffoldInvalidSessionStrategy extends AbstractSessionStrategy implements InvalidSessionStrategy {
	@Override
	public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) {
		onSessionInvalid(response);
	}
}
