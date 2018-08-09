package com.xkcoding.scaffold.config.security.session;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Session 过期策略
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.session
 * @description： Session 过期策略
 * @author: yangkai.shen
 * @date: Created in 2018/8/9 下午2:43
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Component
public class ScaffoldExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {
	@Override
	public void onExpiredSessionDetected(SessionInformationExpiredEvent event) {
		onSessionInvalid(event.getResponse());
	}

	@Override
	protected boolean isConcurrency() {
		return true;
	}
}
