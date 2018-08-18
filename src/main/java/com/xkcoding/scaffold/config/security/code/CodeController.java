package com.xkcoding.scaffold.config.security.code;

import com.xkcoding.scaffold.exception.ScaffoldException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class CodeController {
	private static final String IMAGE_CODE_SESSION_KEY = "SCAFFOLD_IMAGE_CODE_SESSION_KEY";

	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

	@Autowired
	private CodeProcessorHolder codeProcessorHolder;

	@GetMapping("/{type}")
	public void createImageCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws ScaffoldException {
		codeProcessorHolder.findCodeProcessor(type).create(new ServletWebRequest(request, response));
	}

}
