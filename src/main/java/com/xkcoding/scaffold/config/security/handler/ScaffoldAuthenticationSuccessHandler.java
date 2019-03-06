package com.xkcoding.scaffold.config.security.handler;

import com.xkcoding.scaffold.common.Api;
import com.xkcoding.scaffold.common.status.LogStatus;
import com.xkcoding.scaffold.common.status.Status;
import com.xkcoding.scaffold.mapper.SysUserMapper;
import com.xkcoding.scaffold.model.SysUser;
import com.xkcoding.scaffold.model.dto.SysUserDTO;
import com.xkcoding.scaffold.util.LoginLogUtil;
import com.xkcoding.scaffold.util.SecurityUtil;
import com.xkcoding.scaffold.util.ServletUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * <p>
 * 自定义认证成功处理器
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security
 * @description： 自定义认证成功处理器
 * @author: yangkai.shen
 * @date: Created in 2018/8/7 下午8:12
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Component
@Slf4j
public class ScaffoldAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 认证成功时触发
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        log.info("【登录认证】{} 登录成功！", authentication.getPrincipal());

        // 保存登录成功日志
        LoginLogUtil.saveLog(authentication.getName(), Status.LOGIN_SUCCESS, LogStatus.SUCCESS);

        // 登录成功修改用户表登录ip和登录时间
        SysUserDTO principal = (SysUserDTO) authentication.getPrincipal();
        SysUser sysUser = modelMapper.map(principal, SysUser.class);
        sysUser.setLoginIp(SecurityUtil.getIp());
        sysUser.setLoginDate(new Date());
        sysUserMapper.updateByPrimaryKeySelective(sysUser);

        ServletUtil.renderJson(response, Api.ofMessage(Status.LOGIN_SUCCESS.getMsg()));
    }
}
