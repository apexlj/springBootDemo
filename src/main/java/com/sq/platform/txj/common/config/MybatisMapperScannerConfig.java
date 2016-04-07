package com.sq.platform.txj.common.config;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置mybatis自动扫描mapper：需要在MybatisAutoConfiguration之后配置
 *
 * @author lijiang
 * @version 1.0
 * @date 2016/4/5 17:30
 */
@Configuration
@AutoConfigureAfter(MybatisAutoConfiguration.class)
public class MybatisMapperScannerConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.sq.platform.txj.modules.indexModule.dao");
        return mapperScannerConfigurer;
    }
}
