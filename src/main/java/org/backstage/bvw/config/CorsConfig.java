package org.backstage.bvw.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //允许跨域访问的路径
                .allowedOriginPatterns("*") //允许跨域方法的源
                .allowedMethods("POST", "GET", "PUT", "DELETE", "OPTIONS") //允许的请求方式
                .maxAge(3000) //预检间隔事件
                .allowedHeaders("*") //允许头部设置
                .allowCredentials(true);//是否发送cookie
    }
}
