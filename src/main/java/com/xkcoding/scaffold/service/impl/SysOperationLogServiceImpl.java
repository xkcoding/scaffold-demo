package com.xkcoding.scaffold.service.impl;

import com.xkcoding.scaffold.mapper.SysOperationLogMapper;
import com.xkcoding.scaffold.model.SysOperationLog;
import com.xkcoding.scaffold.service.SysOperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统操作日志接口
 * </p>
 *
 * @package: com.xkcoding.scaffold.service.impl
 * @description： 系统操作日志接口
 * @author: yangkai.shen
 * @date: Created in 2018/8/6 下午5:44
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Service
public class SysOperationLogServiceImpl implements SysOperationLogService {
	@Autowired
	private SysOperationLogMapper sysOperationLogMapper;

	/**
	 * 新增一条操作记录
	 *
	 * @param operationLog 操作记录对象
	 */
	@Override
	public void insert(SysOperationLog operationLog) {
		sysOperationLogMapper.insertUseGeneratedKeys(operationLog);
	}
}
