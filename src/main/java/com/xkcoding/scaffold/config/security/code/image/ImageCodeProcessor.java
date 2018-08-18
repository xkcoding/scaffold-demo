package com.xkcoding.scaffold.config.security.code.image;

import com.xkcoding.scaffold.common.status.Status;
import com.xkcoding.scaffold.config.security.code.base.AbstractCodeProcessor;
import com.xkcoding.scaffold.exception.ScaffoldException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 图片验证码处理器
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.code.image
 * @description： 图片验证码处理器
 * @author: yangkai.shen
 * @date: Created in 2018/8/18 上午11:38
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Component("imageCodeProcessor")
public class ImageCodeProcessor extends AbstractCodeProcessor<ImageCode> {

	/**
	 * 发送校验码，由子类实现，图片验证码就是写入 response 中
	 *
	 * @param request {@link ServletWebRequest} 这个类同时封装了request {@link HttpServletRequest} 和 response {@link HttpServletResponse}
	 * @param code    验证码
	 * @throws ScaffoldException 全局异常
	 */
	@Override
	protected void send(ServletWebRequest request, ImageCode code) throws ScaffoldException {
		try {
			ImageIO.write(code.getImage(), "JPEG", request.getResponse().getOutputStream());
		} catch (IOException e) {
			throw new ScaffoldException(Status.CODE_SEND_ERROR);
		}
	}
}
