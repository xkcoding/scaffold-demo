package com.xkcoding.scaffold.controller;

import com.xkcoding.scaffold.common.Api;
import com.xkcoding.scaffold.common.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 认证 Controller
 * </p>
 *
 * @package: com.xkcoding.scaffold.controller
 * @description： 认证 Controller
 * @author: yangkai.shen
 * @date: Created in 2018/8/7 下午8:06
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

	/**
	 * 需要授权
	 *
	 * @return {@link Status#UNAUTHORIZED}
	 */
	@GetMapping("/require")
	public Api require() {
		return Api.ofStatus(Status.UNAUTHORIZED);
	}
}
