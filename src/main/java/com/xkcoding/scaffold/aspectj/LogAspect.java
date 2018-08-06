package com.xkcoding.scaffold.aspectj;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.xkcoding.scaffold.aspectj.annotation.Log;
import com.xkcoding.scaffold.aspectj.constant.OperateStatus;
import com.xkcoding.scaffold.model.SysOperationLog;
import com.xkcoding.scaffold.model.SysUser;
import com.xkcoding.scaffold.service.SysOperationLogService;
import com.xkcoding.scaffold.util.ServletUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * <p>
 * 操作日志记录处理切面
 * </p>
 *
 * @package: com.xkcoding.scaffold.aspectj
 * @description： 操作日志记录处理切面
 * @author: yangkai.shen
 * @date: Created in 2018/8/6 下午2:06
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Aspect
@Component
@EnableAsync
@Slf4j
public class LogAspect {
	@Autowired
	private SysOperationLogService sysOperationLogService;

	/**
	 * 切入点
	 */
	@Pointcut("@annotation(com.xkcoding.scaffold.aspectj.annotation.Log)")
	public void logPointCut() {

	}

	/**
	 * 前置通知 用于拦截操作
	 *
	 * @param joinPoint 切入点
	 */
	@AfterReturning(pointcut = "logPointCut()")
	public void doBefore(JoinPoint joinPoint) {
		handleLog(joinPoint, null);
	}

	/**
	 * 拦截异常操作
	 *
	 * @param joinPoint 切入点
	 * @param e         异常
	 */
	@AfterThrowing(pointcut = "logPointCut()", throwing = "e")
	public void doAfter(JoinPoint joinPoint, Exception e) {
		handleLog(joinPoint, e);
	}

	/**
	 * 记录处理日志信息
	 *
	 * @param joinPoint 切入点
	 * @param e         异常
	 */
	@Async
	protected void handleLog(JoinPoint joinPoint, Exception e) {
		Log controllerLog = getAnnotationLog(joinPoint);

		// 如果没有 @Log，不记录操作日志
		if (ObjectUtil.isNull(controllerLog)) {
			return;
		}

		// TODO: 根据 Spring Security 获取登录用户
		SysUser currentUser = new SysUser();

		// 构造操作日志对象
		SysOperationLog operationLog = new SysOperationLog();
		operationLog.setStatus(OperateStatus.SUCCESS);

		// TODO: 获取当前用户登录 IP
		String ip = "127.0.0.1" ;
		operationLog.setOperationIp(ip);
		// TODO: 根据 IP 查地址
		operationLog.setOperationLocation("");
		operationLog.setOperationUrl(ServletUtil.getRequest().getRequestURI());
		if (currentUser != null) {
			operationLog.setOperationName(currentUser.getLoginName());
			if (ObjectUtil.isNotNull(currentUser.getDeptId())) {
				// TODO: 根据 deptId 查询 Dept
				operationLog.setDeptName("");
			}
		}

		if (e != null) {
			operationLog.setStatus(OperateStatus.FAIL);
			operationLog.setErrorMsg(StrUtil.sub(e.getMessage(), 0, 2000));
		}
		// 设置方法名称
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		operationLog.setMethod(className + "." + methodName + "()");
		// 处理设置注解上的参数
		getControllerMethodDescription(controllerLog, operationLog);
		// 保存数据库
		sysOperationLogService.insert(operationLog);
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 *
	 * @param controllerLog Controller 层 @Log 注解
	 * @param operationLog  操作日志对象
	 */
	private void getControllerMethodDescription(Log controllerLog, SysOperationLog operationLog) {
		// 设置模块名
		operationLog.setTitle(controllerLog.title());
		// 设置功能请求
		operationLog.setAction(controllerLog.action());
		if (controllerLog.keepRequestData()) {
			setRequestData(operationLog);
		}

	}

	/**
	 * 获取请求的参数，放到操作日志中
	 *
	 * @param operationLog 操作日志对象
	 */
	private void setRequestData(SysOperationLog operationLog) {
		Map<String, String[]> map = ServletUtil.getRequest().getParameterMap();
		String params = JSONUtil.toJsonStr(map);
		operationLog.setOperationParam(StrUtil.sub(params, 0, 255));
	}

	/**
	 * 是否存在 @Log，存在就获取 Log，不存在就返回
	 *
	 * @param joinPoint 切入点
	 * @return Log 注解
	 */
	private Log getAnnotationLog(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();
		if (ObjectUtil.isNotNull(method)) {
			return method.getAnnotation(Log.class);
		}
		return null;
	}

}
