package com.sq.platform.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import redis.clients.jedis.JedisPoolConfig;

import javax.sql.DataSource;

/**
 * 配置spring session
 *
 * @author lijiang
 * @version 1.0
 * @date 2016/3/30 14:46
 */
@EnableRedisHttpSession
public class ApplicationContext {

    @Autowired
    public DataSource dataSource;

    @Bean
    public JedisConnectionFactory connectionFactory() {
        // 配置redis连接池
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        JedisPoolConfig poolConfig = jedisConnectionFactory.getPoolConfig();
        jedisConnectionFactory.setHostName("172.16.8.91");
        jedisConnectionFactory.setDatabase(2);
        poolConfig.setMaxTotal(500);
        return jedisConnectionFactory;
    }

    /**
     * 配置静态资源缓存破坏过滤器
     * @return
     */
    @Bean
    public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
        return new ResourceUrlEncodingFilter();
    }
}
