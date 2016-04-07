package com.sq.platform.txj.modules.indexModule.service;

import com.sq.platform.txj.modules.indexModule.dao.UserDao;
import com.sq.platform.txj.modules.indexModule.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author lijiang
 * @version 1.0
 * @date 2016/4/6 14:35
 */
@Component
@CacheConfig
public class UserService {

    @Autowired
    private UserDao userDao;

    @Cacheable(cacheNames = "user", key = "#name")
    public User getUser(String name) {
        System.out.println("开始用户查询");
        User user = userDao.selectUserByName(name);
        System.out.println("存入缓存");
        return user;
    }
}
