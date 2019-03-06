package com.xkcoding.scaffold.config.security.code.image;

import com.xkcoding.scaffold.config.security.code.base.Code;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * <p>
 * 图片验证码
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.code.image
 * @description： 图片验证码
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 上午10:56
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ImageCode extends Code {
    /**
     * 验证码图片
     */
    private BufferedImage image;

    public ImageCode(BufferedImage image) {
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.image = image;
    }
}
