package com.rules.vueshop.configuration;

import com.rules.vueshop.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BeanConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
            .addPathPatterns("/**")
            .excludePathPatterns("/")
            .excludePathPatterns("/v{spring:[0-9]+}/user/**")
            .excludePathPatterns("/webjars/**")
            .excludePathPatterns("/swagger.json")
            .excludePathPatterns("/swagger-ui.html")
            .excludePathPatterns("/swagger-resources/**")
            .excludePathPatterns("/error")
            .excludePathPatterns("/csrf")
            .excludePathPatterns("/favicon.*");
    }
}
