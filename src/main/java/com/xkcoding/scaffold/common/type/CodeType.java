package com.xkcoding.scaffold.common.type;

import com.xkcoding.scaffold.common.constant.ScaffoldConst;

/**
 * <p>
 * 验证码类型
 * </p>
 *
 * @package: com.xkcoding.scaffold.common.type
 * @description： 验证码类型
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 上午11:44
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public enum CodeType {
    /**
     * 短信验证码
     */
    SMS {
        @Override
        public String getParamNameOnValidate() {
            return ScaffoldConst.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }
    },
    /**
     * 图片验证码
     */
    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return ScaffoldConst.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };

    /**
     * 校验时从请求中获取的参数的名字
     *
     * @return 参数名
     */
    public abstract String getParamNameOnValidate();}
