package com.xkcoding.scaffold.config.security.handler;

import cn.hutool.core.util.ObjectUtil;
import com.xkcoding.scaffold.common.status.LogStatus;
import com.xkcoding.scaffold.common.status.Status;
import com.xkcoding.scaffold.util.LoginLogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 自定义认证
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security
 * @description： 自定义认证
 * @author: yangkai.shen
 * @date: Created in 2018/8/10 下午1:51
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Slf4j
public class ScaffoldDaoAuthenticationProvider extends DaoAuthenticationProvider {

    /**
     * 校验密码，如果登录失败，记录日志
     *
     * @param userDetails    数据库保存的用户信息
     * @param authentication 表单提交的用户信息
     */
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if (ObjectUtil.isNull(authentication.getCredentials())) {
            LoginLogUtil.saveLog(authentication.getName(), Status.USERNAME_OR_PASSWORD_ERROR, LogStatus.ERROR);
            throw new BadCredentialsException(Status.USERNAME_OR_PASSWORD_ERROR.getCode() + "");
        }

        String presentedPassword = authentication.getCredentials().toString();

        if (!getPasswordEncoder().matches(presentedPassword, userDetails.getPassword())) {
            LoginLogUtil.saveLog(authentication.getName(), Status.USERNAME_OR_PASSWORD_ERROR, LogStatus.ERROR);
            throw new BadCredentialsException(Status.USERNAME_OR_PASSWORD_ERROR.getCode() + "");
        }
    }

}
