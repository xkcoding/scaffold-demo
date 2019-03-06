package com.xkcoding.scaffold.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 分页格式封装
 * </p>
 *
 * @package: com.xkcoding.scaffold.common
 * @description： 分页格式封装
 * @author: yangkai.shen
 * @date: Created in 2018/8/2 下午7:52
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> implements Serializable {

    private static final long serialVersionUID = 7829232095276966115L;

    /**
     * 数据总条数
     */
    private Long total;

    /**
     * 数据列表
     */
    private List<T> list;
}
