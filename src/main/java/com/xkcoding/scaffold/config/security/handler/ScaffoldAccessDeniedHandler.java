package com.xkcoding.scaffold.config.security.handler;

import com.xkcoding.scaffold.common.Api;
import com.xkcoding.scaffold.common.status.Status;
import com.xkcoding.scaffold.util.ServletUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 自定义拒绝访问处理器
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.handler
 * @description： 自定义拒绝访问处理器
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 下午6:54
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Component
@Slf4j
public class ScaffoldAccessDeniedHandler implements AccessDeniedHandler {

    /**
     * 权限不够时触发
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception) {
        log.error("【鉴权操作】权限不够！", exception);
        ServletUtil.renderJson(response, Api.ofStatus(Status.FORBIDDEN));
    }
}
