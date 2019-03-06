package com.xkcoding.scaffold.common.constant;

import lombok.Getter;

/**
 * <p>
 * 常用Content-Type类型枚举
 * </p>
 *
 * @package: com.xkcoding.scaffold.common.constant
 * @description： 常用Content-Type类型枚举
 * @author: yangkai.shen
 * @date: Created in 2018/8/6 下午4:40
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Getter
public enum ContentType {

    /**
     * 标准表单编码，当action为get时候，浏览器用x-www-form-urlencoded的编码方式把form数据转换成一个字串（name1=value1&name2=value2…）
     */
    FORM_URLENCODED("application/x-www-form-urlencoded"),

    /**
     * 文件上传编码，浏览器会把整个表单以控件为单位分割，并为每个部分加上Content-Disposition，并加上分割符(boundary)
     */
    MULTIPART("multipart/form-data"),

    /**
     * Rest请求JSON编码
     */
    JSON("application/json"),

    /**
     * Rest请求XML编码
     */
    XML("application/xml"),

    /**
     * JS ajax 提交
     */
    XML_HTTP_REQUEST("XMLHttpRequest");

    private String value;

    ContentType(String value) {
        this.value = value;
    }}
