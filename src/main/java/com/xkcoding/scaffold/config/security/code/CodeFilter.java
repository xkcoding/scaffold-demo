package com.xkcoding.scaffold.config.security.code;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Maps;
import com.xkcoding.scaffold.common.constant.ScaffoldConst;
import com.xkcoding.scaffold.common.property.ScaffoldProperties;
import com.xkcoding.scaffold.common.property.ServerProperties;
import com.xkcoding.scaffold.common.type.CodeType;
import com.xkcoding.scaffold.config.security.handler.ScaffoldAuthenticationFailureHandler;
import com.xkcoding.scaffold.exception.ScaffoldException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 验证码拦截器
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.code
 * @description： 验证码拦截器
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 下午9:29
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Component("codeFilter")
@Slf4j
public class CodeFilter extends OncePerRequestFilter implements InitializingBean {

	/**
	 * 验证码校验失败处理器
	 */
	@Autowired
	private ScaffoldAuthenticationFailureHandler scaffoldAuthenticationFailureHandler;

	/**
	 * 系统中的验证码处理器
	 */
	@Autowired
	private CodeProcessorHolder codeProcessorHolder;

	/**
	 * 系统配置信息
	 */
	@Autowired
	private ScaffoldProperties scaffoldProperties;

	/**
	 * 服务器配置
	 */
	@Autowired
	private ServerProperties serverProperties;

	@Autowired
	private Environment env;

	/**
	 * 存放所有需要校验验证码的url
	 */
	private Map<String, CodeType> urlMap = Maps.newHashMap();

	/**
	 * 验证请求url与配置的url是否匹配的工具类
	 */
	private AntPathMatcher pathMatcher = new AntPathMatcher();

	/**
	 * 配置项设置完毕，初始化要拦截的url配置信息
	 */
	@Override
	public void afterPropertiesSet() throws ServletException {
		super.afterPropertiesSet();

		urlMap.put(serverProperties.getContextPath() + ScaffoldConst.DEFAULT_LOGIN_PROCESSING_URL_FORM, CodeType.IMAGE);
		addUrlToMap(scaffoldProperties.getSecurity().getCode().getImage().getUrl(), CodeType.IMAGE);

	}

	/**
	 * 将系统中配置的需要校验验证码的URL根据校验的类型放入map
	 *
	 * @param urlString url
	 * @param type      验证码类型
	 */
	protected void addUrlToMap(String urlString, CodeType type) {
		if (StrUtil.isNotEmpty(urlString)) {
			String[] urls = StrUtil.split(urlString, ",");
			for (String url : urls) {
				urlMap.put(serverProperties.getContextPath() + url, type);
			}
		}
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		CodeType type = getCodeType(request);
		if (type != null) {
			log.info("校验请求(" + request.getRequestURI() + ")中的验证码,验证码类型" + type);
			try {
				codeProcessorHolder.findCodeProcessor(type).validate(new ServletWebRequest(request, response));
				log.info("验证码校验通过");
			} catch (ScaffoldException exception) {
				scaffoldAuthenticationFailureHandler.onAuthenticationFailure(request, response, new BadCredentialsException(exception.getCode() + ""));
				return;
			}
		}

		filterChain.doFilter(request, response);
	}

	/**
	 * 获取校验码的类型，如果当前请求不需要校验，则返回null
	 *
	 * @param request HttpServletRequest
	 * @return 验证码类型
	 */
	private CodeType getCodeType(HttpServletRequest request) {
		CodeType result = null;
		if (!StrUtil.equalsIgnoreCase(request.getMethod(), HttpMethod.GET.name())) {
			Set<String> urls = urlMap.keySet();
			for (String url : urls) {
				if (pathMatcher.match(request.getRequestURI(), url)) {
					result = urlMap.get(url);
				}
			}
		}
		return result;
	}
}
