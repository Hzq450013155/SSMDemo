package com.ssm.security.controller;

import com.ssm.common.exception.BaseException;
import com.ssm.common.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Copyright (c) 2019. Hand Enterprise Solution Company. All right reserved.
 *
 * @version 1.0
 * @description
 * @date 2019-12-08
 * @Author zongqi.hao@hand-china.com
 */
@Controller
public class LoginController {

    @Autowired
    private MessageSource messageSource;

    /**
     * 显示登陆界面.
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return view
     */
    @RequestMapping(value = "login")
    public ModelAndView loginView(final HttpServletRequest request, final HttpServletResponse response) {
        ModelAndView view = new ModelAndView("/login");
        Boolean error = (Boolean) request.getAttribute("error");
        Throwable exception = (Exception) request.getAttribute("exception");

        while (exception != null && exception.getCause() != null) {
            exception = exception.getCause();
        }
        String code = UserException.ERROR_USER_PASSWORD;
        if (exception instanceof BaseException) {
            code = ((BaseException) exception).getDescriptionKey();
        }

        if (error != null && error) {
            //根据错误代码从消息源获取报错信息，返回给前台
            String msg = messageSource.getMessage(new DefaultMessageSourceResolvable(code), RequestContextUtils.getLocale(request));
            view.addObject("msg", msg);
        }
        return view;
    }

    /**
     * 显示主界面.
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return view
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView indexView(final HttpServletRequest request, final HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
//            Long roleId = (Long) session.getAttribute(Role.FIELD_ROLE_ID);
//            if (roleId == null) {
//                return new ModelAndView("redirect:/");
//            }
        }

        ModelAndView view = new ModelAndView("index");
//        fillContextLanguagesData(view);
        return view;
    }
}
