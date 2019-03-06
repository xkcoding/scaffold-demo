package com.xkcoding.scaffold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @package: com.xkcoding.scaffold
 * @description： 启动类
 * @author: yangkai.shen
 * @date: Created in 2018/7/27 下午2:36
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.xkcoding.scaffold.mapper"})
public class ScaffoldApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScaffoldApplication.class, args);
        System.out.println("\n(♥◠‿◠)ﾉﾞ scaffold 启动成功 ლ(´ڡ`ლ)ﾞ\n");
    }
}
