package com.sq.platform.txj.controller;

import com.sq.platform.txj.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

/**
 * @author lijiang
 * @version 1.0
 * @date 2016/3/30 14:19
 */
@Controller
@SessionAttributes("user")
public class TestWebController {

    private static final Logger logger = LoggerFactory.getLogger(TestWebController.class);

    @Value("${application.message}")
    private String welcomeMsg;

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid @ModelAttribute("user")User user, BindingResult result, Model model) {
        logger.info("start to login");
        if (result.hasErrors()) {
            model.addAttribute("error", "不符合输入验证条件，请重新输入！");
            return "login";
        } else {
            // 存入session
            model.addAttribute("user", user);
            return "welcome";
        }
    }
}