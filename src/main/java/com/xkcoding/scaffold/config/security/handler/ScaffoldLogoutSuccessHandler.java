package com.xkcoding.scaffold.config.security.handler;

import cn.hutool.core.util.ObjectUtil;
import com.xkcoding.scaffold.common.Api;
import com.xkcoding.scaffold.common.status.LogStatus;
import com.xkcoding.scaffold.common.status.Status;
import com.xkcoding.scaffold.util.LoginLogUtil;
import com.xkcoding.scaffold.util.ServletUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 自定义登出成功处理器
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security
 * @description： 自定义登出成功处理器
 * @author: yangkai.shen
 * @date: Created in 2018/8/7 下午9:12
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Component
@Slf4j
public class ScaffoldLogoutSuccessHandler implements LogoutSuccessHandler {

	/**
	 * 登出成功时触发
	 */
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		if (ObjectUtil.isNotNull(authentication)){
			log.info("【退出登录】{} 登出成功！", ((UserDetails) authentication.getPrincipal()).getUsername());
			LoginLogUtil.saveLog(authentication.getName(), Status.LOGOUT_SUCCESS, LogStatus.SUCCESS);
			ServletUtil.renderJson(response, Api.ofMessage(Status.LOGOUT_SUCCESS.getMsg()));
		}else {
			ServletUtil.renderJson(response, Api.ofStatus(Status.UNAUTHORIZED));
		}
	}
}
