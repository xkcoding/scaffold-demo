package com.xkcoding.scaffold.service;

import com.xkcoding.scaffold.model.SysOperationLog;

/**
 * <p>
 * 系统操作日志接口
 * </p>
 *
 * @package: com.xkcoding.scaffold.service
 * @description： 系统操作日志接口
 * @author: yangkai.shen
 * @date: Created in 2018/8/6 下午5:42
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public interface SysOperationLogService {
    /**
     * 新增一条操作记录
     *
     * @param operationLog 操作记录对象
     */
    void insert(SysOperationLog operationLog);
}
