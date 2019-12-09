package com.ssm.core.controller;

import com.ssm.core.entity.User;
import com.ssm.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "getList")
    public ModelAndView getList(HttpServletRequest request, HttpServletResponse response, User model) {
        List list = userService.getList(model);
        request.setAttribute("list", list);
        return new ModelAndView("userList");
    }

    @RequestMapping(value = "getUser")
    @ResponseBody
    public User getUser(HttpServletRequest request, HttpServletResponse response, User model) {
        model.setUserId((Long) request.getSession().getAttribute("userId"));
        List<User> list = userService.getList(model);
        return list.get(0);
    }


    @RequestMapping(value = "insert")
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response, User model) {
        userService.insert(model);
        return getList(request, response, new User());
    }

    @RequestMapping(value = "update")
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response, User model) {
        model.setUserId((Long) request.getSession().getAttribute("userId"));
        model.setLastUpdateDate(new Date());
        userService.update(model);
        return new ModelAndView("infoMaintenance");
    }

    @RequestMapping(value = "delete")
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, User model) {
        userService.delete(model);
        return getList(request, response, new User());
    }


}
