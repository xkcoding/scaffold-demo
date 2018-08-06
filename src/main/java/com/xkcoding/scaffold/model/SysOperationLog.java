package com.xkcoding.scaffold.model;

import java.util.Date;
import javax.persistence.*;

/**
 * <p>
 * 操作日志记录
 * </p>
 *
 * @package: com.xkcoding.scaffold.model
 * @description： 操作日志记录
 * @author: yangkai.shen
 * @date: Created in 2018/7/31 上午10:33
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Table(name = "sys_operation_log")
public class SysOperationLog {
    /**
     * 日志主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 模块标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 功能请求
     */
    @Column(name = "action")
    private String action;

    /**
     * 方法名称
     */
    @Column(name = "method")
    private String method;

    /**
     * 操作人员
     */
    @Column(name = "operation_name")
    private String operationName;

    /**
     * 部门名称
     */
    @Column(name = "dept_name")
    private String deptName;

    /**
     * 请求URL
     */
    @Column(name = "operation_url")
    private String operationUrl;

    /**
     * 主机地址
     */
    @Column(name = "operation_ip")
    private String operationIp;

    /**
     * 操作地点
     */
    @Column(name = "operation_location")
    private String operationLocation;

    /**
     * 请求参数
     */
    @Column(name = "operation_param")
    private String operationParam;

    /**
     * 操作状态（0异常 1正常）
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 错误消息
     */
    @Column(name = "error_msg")
    private String errorMsg;

    /**
     * 操作时间
     */
    @Column(name = "operation_time")
    private Date operationTime;

    /**
     * 获取日志主键
     *
     * @return id - 日志主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置日志主键
     *
     * @param id 日志主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取模块标题
     *
     * @return title - 模块标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置模块标题
     *
     * @param title 模块标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取功能请求
     *
     * @return action - 功能请求
     */
    public String getAction() {
        return action;
    }

    /**
     * 设置功能请求
     *
     * @param action 功能请求
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * 获取方法名称
     *
     * @return method - 方法名称
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置方法名称
     *
     * @param method 方法名称
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取操作人员
     *
     * @return oper_name - 操作人员
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * 设置操作人员
     *
     * @param operationName 操作人员
     */
    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    /**
     * 获取部门名称
     *
     * @return dept_name - 部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置部门名称
     *
     * @param deptName 部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取请求URL
     *
     * @return oper_url - 请求URL
     */
    public String getOperationUrl() {
        return operationUrl;
    }

    /**
     * 设置请求URL
     *
     * @param operationUrl 请求URL
     */
    public void setOperationUrl(String operationUrl) {
        this.operationUrl = operationUrl;
    }

    /**
     * 获取主机地址
     *
     * @return oper_ip - 主机地址
     */
    public String getOperationIp() {
        return operationIp;
    }

    /**
     * 设置主机地址
     *
     * @param operationIp 主机地址
     */
    public void setOperationIp(String operationIp) {
        this.operationIp = operationIp;
    }

    /**
     * 获取操作地点
     *
     * @return oper_location - 操作地点
     */
    public String getOperationLocation() {
        return operationLocation;
    }

    /**
     * 设置操作地点
     *
     * @param operationLocation 操作地点
     */
    public void setOperationLocation(String operationLocation) {
        this.operationLocation = operationLocation;
    }

    /**
     * 获取请求参数
     *
     * @return oper_param - 请求参数
     */
    public String getOperationParam() {
        return operationParam;
    }

    /**
     * 设置请求参数
     *
     * @param operationParam 请求参数
     */
    public void setOperationParam(String operationParam) {
        this.operationParam = operationParam;
    }

    /**
     * 获取操作状态（0异常 1正常）
     *
     * @return status - 操作状态（0异常 1正常）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置操作状态（0异常 1正常）
     *
     * @param status 操作状态（0异常 1正常）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取错误消息
     *
     * @return error_msg - 错误消息
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 设置错误消息
     *
     * @param errorMsg 错误消息
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * 获取操作时间
     *
     * @return oper_time - 操作时间
     */
    public Date getOperationTime() {
        return operationTime;
    }

    /**
     * 设置操作时间
     *
     * @param operationTime 操作时间
     */
    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
}