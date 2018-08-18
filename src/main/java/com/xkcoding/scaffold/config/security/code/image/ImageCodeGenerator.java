package com.xkcoding.scaffold.config.security.code.image;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.xkcoding.scaffold.common.property.ScaffoldProperties;
import com.xkcoding.scaffold.config.security.code.base.Code;
import com.xkcoding.scaffold.config.security.code.base.CodeGenerator;
import lombok.Data;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * <p>
 * 图片验证码生成器
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.code.image
 * @description： 图片验证码生成器
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 上午11:08
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
public class ImageCodeGenerator implements CodeGenerator {
	private ScaffoldProperties scaffoldProperties;

	/**
	 * 验证码生成器接口
	 *
	 * @param request {@link ServletWebRequest} 这个类同时封装了request {@link HttpServletRequest} 和 response {@link HttpServletResponse}
	 * @return 验证码
	 */
	@Override
	public Code generate(ServletWebRequest request) {
		// 获取请求中的验证码宽高
		int width = ServletRequestUtils.getIntParameter(request.getRequest(), "width", scaffoldProperties.getSecurity().getCode().getImage().getWidth());
		int height = ServletRequestUtils.getIntParameter(request.getRequest(), "height", scaffoldProperties.getSecurity().getCode().getImage().getHeight());

		// 生成随机验证码
		int length = scaffoldProperties.getSecurity().getCode().getImage().getLength();
		String randomCode = "";
		for (int i = 0; i < length; i++) {
			randomCode = StrUtil.concat(true, randomCode, String.valueOf(RandomUtil.randomChar()));
		}
		BufferedImage image = (BufferedImage) CaptchaUtil.createLineCaptcha(width, height, length, 0).createImage(randomCode);
		return new ImageCode(image, randomCode, scaffoldProperties.getSecurity().getCode().getImage().getExpireIn());
	}
}
