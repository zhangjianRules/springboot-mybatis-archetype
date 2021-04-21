package com.rules.vueshop;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;

@SpringBootApplication
@EnableSwaggerBootstrapUI
@MapperScan("com.rules.vueshop.mapper")
@PropertySource(value = {"classpath:config/server.properties", "classpath:config/server.local.properties"}, ignoreResourceNotFound = true)
public class VueShopApiApplication {
    private static final Logger logger = LoggerFactory.getLogger(VueShopApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(VueShopApiApplication.class, args);
        logger.info("server startup {}..........", Arrays.toString(args));
    }

}
