package com.xkcoding.scaffold.config.security.code.base;

import cn.hutool.core.util.StrUtil;
import com.xkcoding.scaffold.common.status.Status;
import com.xkcoding.scaffold.common.type.CodeType;
import com.xkcoding.scaffold.exception.ScaffoldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * <p>
 * 抽象验证码处理接口
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.code.base
 * @description： 抽象验证码处理接口
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 上午11:39
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public abstract class AbstractCodeProcessor<C extends Code> implements CodeProcessor {
	/**
	 * 操作session的工具类
	 */
	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

	/**
	 * 收集系统中所有的 {@link CodeGenerator} 接口的实现。
	 */
	@Autowired
	private Map<String, CodeGenerator> codeGenerators;

	/**
	 * 创建校验码
	 *
	 * @param request {@link ServletWebRequest} 这个类同时封装了request {@link javax.servlet.http.HttpServletRequest} 和 response {@link javax.servlet.http.HttpServletResponse}
	 */
	@Override
	public void create(ServletWebRequest request) throws ScaffoldException {
		C validateCode = generate(request);
		save(request, validateCode);
		send(request, validateCode);
	}

	/**
	 * 生成验证码
	 *
	 * @param request {@link ServletWebRequest} 这个类同时封装了request {@link javax.servlet.http.HttpServletRequest} 和 response {@link javax.servlet.http.HttpServletResponse}
	 * @return 验证码
	 * @throws ScaffoldException 全局异常
	 */
	private C generate(ServletWebRequest request) throws ScaffoldException {
		String type = getCodeType().toString().toLowerCase();
		String generatorName = type + CodeGenerator.class.getSimpleName();
		CodeGenerator validateCodeGenerator = codeGenerators.get(generatorName);
		if (validateCodeGenerator == null) {
			throw new ScaffoldException(Status.INTERNAL_SERVER_ERROR.getCode(), "验证码生成器" + generatorName + "不存在");
		}
		return (C) validateCodeGenerator.generate(request);
	}

	/**
	 * 保存验证码
	 *
	 * @param request      {@link ServletWebRequest} 这个类同时封装了request {@link javax.servlet.http.HttpServletRequest} 和 response {@link javax.servlet.http.HttpServletResponse}
	 * @param validateCode 验证码
	 */
	private void save(ServletWebRequest request, C validateCode) {
		sessionStrategy.setAttribute(request, getSessionKey(), validateCode);
	}

	/**
	 * 构建验证码放入session时的key
	 *
	 * @return sessionKey
	 */
	private String getSessionKey() {
		return SESSION_KEY_PREFIX + getCodeType().toString().toUpperCase();
	}

	/**
	 * 发送校验码，由子类实现
	 *
	 * @param request      {@link ServletWebRequest} 这个类同时封装了request {@link javax.servlet.http.HttpServletRequest} 和 response {@link javax.servlet.http.HttpServletResponse}
	 * @param code 验证码
	 * @throws ScaffoldException 全局异常
	 */
	protected abstract void send(ServletWebRequest request, C code) throws ScaffoldException;

	/**
	 * 根据请求的url获取校验码的类型
	 *
	 * @return 验证码类型
	 */
	private CodeType getCodeType() {
		String type = StrUtil.subBefore(getClass().getSimpleName(), "CodeProcessor", true);
		return CodeType.valueOf(type.toUpperCase());
	}

	/**
	 * 校验验证码
	 *
	 * @param request {@link ServletWebRequest} 这个类同时封装了request {@link javax.servlet.http.HttpServletRequest} 和 response {@link javax.servlet.http.HttpServletResponse}
	 * @throws ScaffoldException 全局异常
	 */
	@Override
	public void validate(ServletWebRequest request) throws ScaffoldException {

		CodeType processorType = getCodeType();
		String sessionKey = getSessionKey();

		C codeInSession = (C) sessionStrategy.getAttribute(request, sessionKey);

		String codeInRequest;
		try {
			codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), processorType.getParamNameOnValidate());
		} catch (ServletRequestBindingException e) {
			throw new ScaffoldException(Status.CODE_GET_ERROR);
		}

		if (StrUtil.isEmpty(codeInRequest)) {
			throw new ScaffoldException(Status.CODE_VALUE_NOT_NULL);
		}

		if (codeInSession == null) {
			throw new ScaffoldException(Status.CODE_NOT_FOUND);
		}

		if (codeInSession.isExpried()) {
			sessionStrategy.removeAttribute(request, sessionKey);
			throw new ScaffoldException(Status.CODE_IS_EXPIRED);
		}

		if (!StrUtil.equals(codeInSession.getCode(), codeInRequest)) {
			throw new ScaffoldException(Status.CODE_NOT_MATCH);
		}

		sessionStrategy.removeAttribute(request, sessionKey);
	}
}
