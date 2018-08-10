package com.xkcoding.scaffold.config.security.handler;

import cn.hutool.core.convert.Convert;
import com.xkcoding.scaffold.common.Api;
import com.xkcoding.scaffold.common.status.Status;
import com.xkcoding.scaffold.util.EnumUtil;
import com.xkcoding.scaffold.util.ServletUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * <p>
 * 自定义认证失败处理器
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security
 * @description： 自定义认证失败处理器
 * @author: yangkai.shen
 * @date: Created in 2018/8/7 下午7:48
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Component
@Slf4j
public class ScaffoldAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	/**
	 * 认证失败时触发
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
		log.error("【登录认证】登录失败！", exception);
		Integer errorCode = Convert.toInt(exception.getMessage(), 500);
		Status status = EnumUtil.getStatusByCode(errorCode, Status.class);
		ServletUtil.renderJson(response, Api.ofStatus(Objects.requireNonNull(status)));
	}
}
