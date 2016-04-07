package com.sq.platform.txj.common.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;

/**
 * @author lijiang
 * @version 1.0
 * @date 2016/4/7 9:30
 */
@EnableCaching(proxyTargetClass = true)
@EnableTransactionManagement(proxyTargetClass = true)
@Configuration
public class ApplicationContext {

    /**
     * 配置静态资源缓存破坏过滤器
     * @return
     */
    @Bean
    public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
        return new ResourceUrlEncodingFilter();
    }
}
