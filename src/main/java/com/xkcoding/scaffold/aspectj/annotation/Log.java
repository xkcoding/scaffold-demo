package com.xkcoding.scaffold.aspectj.annotation;

import java.lang.annotation.*;

/**
 * <p>
 * 操作记录日志注解
 * </p>
 *
 * @package: com.xkcoding.scaffold.aspectj.annotation
 * @description： 操作记录日志注解
 * @author: yangkai.shen
 * @date: Created in 2018/8/6 下午1:58
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
	/**
	 * 模块名
	 */
	String title() default "" ;

	/**
	 * 功能
	 */
	String action() default "" ;

	/**
	 * 是否保存请求参数
	 */
	boolean keepRequestData() default true;
}
