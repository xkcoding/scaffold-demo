package com.xkcoding.scaffold.util;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <p>
 * IP 工具类
 * </p>
 *
 * @package: com.xkcoding.scaffold.util
 * @description： IP 工具类
 * @author: yangkai.shen
 * @date: Created in 2018/8/10 下午4:59
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Slf4j
public class IpUtil {

    /**
     * 本机回环地址
     */
    public static final String LOCAL_INNER_LOOP_IP = "0:0:0:0:0:0:0:1";

    /**
     * 本机IP地址
     */
    public static final String LOCAL_IP = "127.0.0.1";

    /**
     * 取外网IP
     */
    public static String getRemoteIp(HttpServletRequest request) {
        String ip = request.getHeader("x-real-ip");
        if (ip == null) {
            ip = request.getRemoteAddr();
        }

        //过滤反向代理的ip
        String[] stemps = ip.split(",");
        if (stemps != null && stemps.length >= 1) {
            //得到第一个IP，即客户端真实IP
            ip = stemps[0];
        }

        ip = ip.trim();
        if (ip.length() > 23) {
            ip = ip.substring(0, 23);
        }

        return ip;
    }

    /**
     * 获取用户的真实ip
     */
    public static String getUserIP(HttpServletRequest request) {

        // 优先取X-Real-IP
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (LOCAL_INNER_LOOP_IP.equals(ip)) {
                ip = LOCAL_IP;
            }
        }

        if ("unknown".equalsIgnoreCase(ip)) {
            ip = LOCAL_IP;
            return ip;
        }

        int pos = ip.indexOf(',');
        if (pos >= 0) {
            ip = ip.substring(0, pos);
        }

        return ip;
    }

    public static String getLastIpSegment(HttpServletRequest request) {
        String ip = getUserIP(request);
        if (ip != null) {
            ip = ip.substring(ip.lastIndexOf('.') + 1);
        } else {
            ip = "0";
        }
        return ip;
    }

    public static boolean isValidIP(HttpServletRequest request) {
        String ip = getUserIP(request);
        return isValidIP(ip);
    }

    /**
     * 判断我们获取的ip是否是一个符合规则ip
     */
    public static boolean isValidIP(String ip) {
        if (StrUtil.isBlank(ip)) {
            return false;
        }

        return Validator.isIpv4(ip);
    }

    public static String getLastServerIpSegment() {
        String ip = getServerIP();
        if (ip != null) {
            ip = ip.substring(ip.lastIndexOf('.') + 1);
        } else {
            ip = "0";
        }
        return ip;
    }

    public static String getServerIP() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            log.error("获取服务器 IP 发生异常！", e);
        }
        return LOCAL_IP;
    }
}
