package com.sq.platform.txj.modules.indexModule.config;

import com.sq.platform.txj.modules.indexModule.service.MyRealm;
import com.sq.platform.txj.modules.indexModule.service.UserService;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lijiang
 * @version 1.0
 * @date 2016/4/5 20:19
 */
@Configuration
public class ShiroConfiguration {

    @Bean
    public MyRealm myRealm(UserService userService) {
        MyRealm myRealm = new MyRealm();
        myRealm.setUserService(userService);
        PasswordMatcher passwordMatcher = new PasswordMatcher();
        passwordMatcher.setPasswordService(new DefaultPasswordService());
        myRealm.setCredentialsMatcher(passwordMatcher);
        return myRealm;
    }

    @Bean
    public EhCacheManager getEhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
        return em;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(MyRealm myRealm, EhCacheManager ehCacheManager) {
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        dwsm.setRealm(myRealm);
        // 用户授权/认证信息Cache, 采用EhCache 缓存
        dwsm.setCacheManager(ehCacheManager);
        return dwsm;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setLoginUrl("/login");
        shiroFilter.setSuccessUrl("/welcome");
        shiroFilter.setUnauthorizedUrl("/forbidden");
        Map<String, String> filterChainDefinitionMapping = new HashMap<>();
        filterChainDefinitionMapping.put("/*", "authc");
        filterChainDefinitionMapping.put("/login", "anon");
        filterChainDefinitionMapping.put("/welcome", "anon");
        filterChainDefinitionMapping.put("/logout", "authc");
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMapping);
        shiroFilter.setSecurityManager(securityManager);
        return shiroFilter;
    }

}
