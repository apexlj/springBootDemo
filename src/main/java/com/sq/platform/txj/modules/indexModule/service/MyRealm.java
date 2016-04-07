package com.sq.platform.txj.modules.indexModule.service;

import com.sq.platform.txj.modules.indexModule.model.Permission;
import com.sq.platform.txj.modules.indexModule.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author lijiang
 * @version 1.0
 * @date 2016/4/5 20:21
 */
@Component
public class MyRealm extends AuthorizingRealm {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("start to authorize");
        String userName = (String) super.getAvailablePrincipal(principals);
        User user = userService.getUser(userName);
        if (user != null) {
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            authorizationInfo.addRole(user.getRole().getName());
            for (Permission permission : user.getRole().getPermissions()) {
                authorizationInfo.addStringPermission(permission.getPermissionName());
            }
            return authorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("start to authenticate");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
        User user = userService.getUser(usernamePasswordToken.getUsername());
        if (user != null)
            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
            return new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());
        return null;
    }
}
