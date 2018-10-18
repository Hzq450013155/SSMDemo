package com.ssm.core.controller;

import com.ssm.core.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name LoginController
 * @description 登录验证控制器
 * @date 2018-10-11
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/loginShiro", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
//    @ResponseBody
    public String loginShiro(User model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(model.getUserName(), model.getPassword());
        try {
            subject.login(token);
        } catch (Exception e) {
            return e.getMessage();
        }
        if (subject.hasRole("admin")) {
            return "index";
        }
        return "";
    }

    @RequiresPermissions("login")
    public ModelAndView login() {
        return new ModelAndView("index");
    }

//    @RequiresRoles("admin")
//    @RequestMapping("tsetRoles")
//    @ResponseBody
//    public String testRoles() {
//        return "success";
//    }
//
//    @RequiresRoles("admin")
//    @RequiresPermissions("admin:select")
//    @RequestMapping("tsetRoles1")
//    @ResponseBody
//    public String testRoles1() {
//        return "success111";
//    }


//    @RequestMapping("/logout")
//    public String logout(HttpServletRequest request) {
//        Subject subject = SecurityUtils.getSubject();
//        subject.logout();
//        return "redirect:/login.html";
//    }
}