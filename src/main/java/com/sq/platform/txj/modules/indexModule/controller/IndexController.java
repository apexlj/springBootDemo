package com.sq.platform.txj.modules.indexModule.controller;

import com.sq.platform.txj.modules.indexModule.exception.UserServiceErrorCode;
import com.sq.platform.txj.modules.indexModule.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

/**
 * @author lijiang
 * @version 1.0
 * @date 2016/3/30 14:19
 */
@Controller
@SessionAttributes("user")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private MessageSource messageSource;

    @Value("${application.message}")
    private String welcomeMsg;

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/login")
    public String main(Model model) {
        if (model.containsAttribute("user"))
            return "redirect:" + "/welcome";

        model.addAttribute("userInfo", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid @ModelAttribute("userInfo") User user, BindingResult result, Model model) {
        logger.info("start to login");
        if (result.hasErrors()) {
            model.addAttribute("error", messageSource.getMessage(UserServiceErrorCode.INPUT_ERROR, null, null));
            return "login";
        }

        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        logger.info("对用户{}进行登陆验证..开始", user.getName());
        try {
            currentUser.login(token);
            logger.info("对用户{}进行登陆验证..通过", user.getName());
            // 存入session
            model.addAttribute("user", user);
        } catch (AuthenticationException e) {
            logger.info("对用户{}进行登陆验证..失败", user.getName());
            model.addAttribute("error", messageSource.getMessage(UserServiceErrorCode.AUTH_ERROR, null, null));
            return "login";
        }
        return "welcome";
    }

    @RequestMapping("/logout")
    public String logout(SessionStatus status) {
        // 删除session数据
        status.setComplete();
        // shiro退出登录
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }
}