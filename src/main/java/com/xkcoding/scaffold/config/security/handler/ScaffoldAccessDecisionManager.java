package com.xkcoding.scaffold.config.security.handler;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.xkcoding.scaffold.common.status.Status;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.CountDownLatch;

/**
 * <p>
 * 自定义鉴权决策管理
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.handler
 * @description： 自定义鉴权决策管理
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 下午8:36
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Component
public class ScaffoldAccessDecisionManager implements AccessDecisionManager {
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
		if (CollUtil.isEmpty(configAttributes)) {
			return;
		}
		for (ConfigAttribute configAttribute : configAttributes) {
			String needPermission = configAttribute.getAttribute();
			Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
			for (GrantedAuthority authority : authorities) {
				if (StrUtil.equals(StrUtil.trim(needPermission), authority.getAuthority())) {
					return;
				}
			}
		}
		throw new AccessDeniedException(Status.FORBIDDEN.getMsg());
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
}
