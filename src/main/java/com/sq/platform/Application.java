package com.sq.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * 入口类：需要继承自SpringBootServletInitializer
 * 本地开发时加上exclude = SessionAutoConfiguration.class，采用本地session
 * 生产环境可去掉exclude = SessionAutoConfiguration.class，采用redis分布式session
 */
@SpringBootApplication(exclude = SessionAutoConfiguration.class)
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
