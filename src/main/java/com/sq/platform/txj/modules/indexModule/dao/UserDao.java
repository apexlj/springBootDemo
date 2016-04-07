package com.sq.platform.txj.modules.indexModule.dao;

import com.sq.platform.txj.modules.indexModule.model.User;
import org.springframework.stereotype.Component;

/**
 * @author lijiang
 * @version 1.0
 * @date 2016/4/5 19:20
 */
@Component
public interface UserDao {
    User selectUserByName(String username);
}