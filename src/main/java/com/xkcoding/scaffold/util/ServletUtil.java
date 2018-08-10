package com.xkcoding.scaffold.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.xkcoding.scaffold.common.constant.ContentType;
import com.xkcoding.scaffold.common.constant.FileSuffix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <p>
 * Servlet 工具类
 * </p>
 *
 * @package: com.xkcoding.scaffold.util
 * @description： Servlet 工具类
 * @author: yangkai.shen
 * @date: Created in 2018/8/6 下午4:18
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Slf4j
public class ServletUtil {
	/**
	 * 获取当前请求的 RequestAttributes
	 */
	public static ServletRequestAttributes getRequestAttributes() {
		RequestAttributes attributes = RequestContextHolder.currentRequestAttributes();
		return (ServletRequestAttributes) attributes;
	}

	/**
	 * 获取 IP
	 */
	public static String getIp() {
		return IpUtil.getUserIP(getRequest());
	}

	/**
	 * 获取 Request
	 */
	public static HttpServletRequest getRequest() {
		return getRequestAttributes().getRequest();
	}

	/**
	 * 获取 Response
	 */
	public static HttpServletResponse getResponse() {
		return getRequestAttributes().getResponse();
	}

	/**
	 * 获取 Session
	 */
	public static HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * 获取String参数
	 */
	public static String getParameter(String name) {
		return getRequest().getParameter(name);
	}

	/**
	 * 获取String参数
	 */
	public static String getParameter(String name, String defaultValue) {
		return Convert.toStr(getRequest().getParameter(name), defaultValue);
	}

	/**
	 * 获取Integer参数
	 */
	public static Integer getParameterToInt(String name) {
		return Convert.toInt(getRequest().getParameter(name));
	}

	/**
	 * 获取Integer参数
	 */
	public static Integer getParameterToInt(String name, Integer defaultValue) {
		return Convert.toInt(getRequest().getParameter(name), defaultValue);
	}

	/**
	 * 使用 Response 渲染 json 数据到客户端
	 *
	 * @param response 输出流
	 * @param data     渲染数据
	 */
	public static void renderJson(HttpServletResponse response, Object data) {
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			JSONObject jsonData = JSONUtil.parseObj(data, false);
			String json = JSONUtil.toJsonStr(jsonData);
			response.getWriter().print(json);
		} catch (IOException e) {
			log.error("【JSON 渲染】使用 Response 渲染 json 数据到客户端，[json]：{}", JSONUtil.toJsonStr(data));
			log.error("【JSON 渲染】发生异常！", e);
		}
	}

	/**
	 * 是否是Ajax异步请求
	 *
	 * @param request 请求
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {

		String accept = request.getHeader("accept");
		if (StrUtil.containsIgnoreCase(accept, ContentType.JSON.getValue())) {
			return true;
		}

		String xRequestedWith = request.getHeader("X-Requested-With");
		if (StrUtil.containsIgnoreCase(xRequestedWith, ContentType.XML_HTTP_REQUEST.getValue())) {
			return true;
		}

		String uri = request.getRequestURI();
		if (StrUtil.containsAnyIgnoreCase(uri, FileSuffix.JSON.getValue(), FileSuffix.XML.getValue())) {
			return true;
		}

		String ajax = request.getParameter("__ajax");
		if (StrUtil.containsAnyIgnoreCase(ajax, FileSuffix.JSON.getValue(), FileSuffix.XML.getValue())) {
			return true;
		}

		return false;
	}
}
