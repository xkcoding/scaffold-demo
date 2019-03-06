package com.xkcoding.scaffold.util;

import com.xkcoding.scaffold.common.BaseEnum;

/**
 * <p>
 * 状态工具类
 * </p>
 *
 * @package: com.xkcoding.scaffold.util
 * @description： 状态工具类
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 上午10:25
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public class EnumUtil {

    /**
     * 根据状态码获取状态枚举
     *
     * @param code      状态码
     * @param enumClass 枚举类
     * @param <T>       泛型 {@link BaseEnum}
     * @return 状态枚举
     */
    public static <T extends BaseEnum> T getStatusByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
