package com.evan.wj;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author wang.hz
 * @Date 2018/7/4
 * <p>解决springboot打成war包，部署tomcat后访问404问题</p>
 */
public class BackendInTomcatApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WjApplication.class);
    }

}