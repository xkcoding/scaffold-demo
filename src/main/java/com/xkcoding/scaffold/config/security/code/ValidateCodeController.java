package com.xkcoding.scaffold.config.security.code;

import cn.hutool.captcha.CaptchaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * <p>
 * 验证码 Controller
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.code
 * @description： 验证码 Controller
 * @author: yangkai.shen
 * @date: Created in 2018/8/13 上午10:42
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@RestController
@RequestMapping("/code")
@Slf4j
public class ValidateCodeController {
	private static final String IMAGE_CODE_SESSION_KEY = "SCAFFOLD_IMAGE_CODE_SESSION_KEY";

	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

	@GetMapping("/image")
	public void createImageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedImage image = (BufferedImage)CaptchaUtil.createLineCaptcha(200, 100).createImage("12345");
		sessionStrategy.setAttribute(new ServletWebRequest(request), IMAGE_CODE_SESSION_KEY, image);
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

}
