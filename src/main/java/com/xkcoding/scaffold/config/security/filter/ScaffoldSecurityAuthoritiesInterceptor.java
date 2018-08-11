package com.xkcoding.scaffold.config.security.filter;

import com.xkcoding.scaffold.config.security.handler.ScaffoldAccessDecisionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * <p>
 * 自定义拦截器
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.filter
 * @description： 自定义拦截器
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 下午9:29
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Component
public class ScaffoldSecurityAuthoritiesInterceptor extends AbstractSecurityInterceptor implements Filter {
	@Autowired
	private ScaffoldFilterInvocationSecurityMetadataSource securityMetadataSource;

	@Autowired
	public void setAccessDecisionManager(ScaffoldAccessDecisionManager accessDecisionManager) {
		super.setAccessDecisionManager(accessDecisionManager);
	}

	@Override
	public void init(FilterConfig filterConfig) {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		FilterInvocation filterInvocation = new FilterInvocation(request, response, chain);
		invoke(filterInvocation);
	}

	private void invoke(FilterInvocation filterInvocation) throws IOException, ServletException {
		// filterInvocation 里面有一个被拦截的url
		// 调用MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法获取 filterInvocation 对应的所有权限
		// 再调用 MyAccessDecisionManager 的 decide 方法来校验用户的权限是否足够
		InterceptorStatusToken token = super.beforeInvocation(filterInvocation);
		try {
			//执行下一个拦截器
			filterInvocation.getChain().doFilter(filterInvocation.getRequest(), filterInvocation.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
	}

	@Override
	public void destroy() {

	}

	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;
	}
}
