package com.xkcoding.scaffold.util;

import cn.hutool.core.util.ObjectUtil;
import com.xkcoding.scaffold.common.status.LogStatus;
import com.xkcoding.scaffold.common.status.Status;
import com.xkcoding.scaffold.mapper.SysLoginLogMapper;
import com.xkcoding.scaffold.model.SysLoginLog;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * <p>
 * 日志操作任务创建工厂
 * </p>
 *
 * @package: com.xkcoding.scaffold.util.log.factory
 * @description： 日志操作任务创建工厂
 * @author: yangkai.shen
 * @date: Created in 2018/8/9 下午7:23
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Slf4j
public class LoginLogUtil {

	private static SysLoginLogMapper sysLoginLogMapper = SpringContextHolderUtil.getBean(SysLoginLogMapper.class);

	public static void saveLog(String username, Status message, LogStatus status) {
		try {
			UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtil.getRequest().getHeader("User-Agent"));
			// 获取客户端操作系统
			String os = userAgent.getOperatingSystem().getName();
			// 获取客户端浏览器
			String browser = userAgent.getBrowser().getName();

			SysLoginLog sysLoginLog = new SysLoginLog();
			sysLoginLog.setLoginName(username);
			sysLoginLog.setStatus(status.getCode());
			if (ObjectUtil.equal(status, LogStatus.ERROR) || ObjectUtil.equal(message, Status.LOGOUT_SUCCESS)) {
				sysLoginLog.setIpAddress(ServletUtil.getIp());
				sysLoginLog.setLoginLocation(Ip2AddressUtil.getAddressInLocal(ServletUtil.getIp()));
			} else {
				sysLoginLog.setIpAddress(SecurityUtil.getIp());
				sysLoginLog.setLoginLocation(Ip2AddressUtil.getAddressInLocal(SecurityUtil.getIp()));
			}
			sysLoginLog.setBrowser(browser);
			sysLoginLog.setOs(os);
			sysLoginLog.setMsg(message.getMsg());
			sysLoginLog.setLoginTime(new Date());
			sysLoginLogMapper.insertUseGeneratedKeys(sysLoginLog);
		} catch (Exception e) {
			log.error("创建登录日志异常!", e);
		}
	}

}
