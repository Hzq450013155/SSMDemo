package com.ssm.common.controller;

import com.ssm.common.dto.ResponseData;
import com.ssm.common.exception.BaseException;
import com.ssm.security.DefaultConfiguration;
import org.apache.ibatis.ognl.OgnlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Copyright (c) 2019. Hand Enterprise Solution Company. All right reserved.
 *
 * @version 1.0
 * @description
 * @date 2019-12-16
 * @Author zongqi.hao@hand-china.com
 */
@RestController
public class BaseController {

    protected static final String DEFAULT_VIEW_HOME = "";
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
    @Autowired
    MessageSource messageSource;

    @Autowired
    private DefaultConfiguration configuration;

    protected String getViewPath() {
        if (configuration != null) {
            return configuration.getDefaultViewPath();
        }
        return DEFAULT_VIEW_HOME;
    }

    /**
     * 处理控制层所有异常.
     *
     * @param exception 未捕获的异常
     * @param request   HttpServletRequest
     * @return ResponseData(BaseException 被处理) 或者 ModelAndView(其他 exception
     * ,500错误)
     */
    @ExceptionHandler(value = {Exception.class})
    public Object exceptionHandler(Exception exception, HttpServletRequest request) {
        LOGGER.error(exception.getMessage(), exception);
        Throwable thr = getRootCause(exception);
        ResponseData res = new ResponseData(false);
        if (thr instanceof BaseException) {
            BaseException be = (BaseException) thr;
            Locale locale = RequestContextUtils.getLocale(request);
            String messageKey = be.getDescriptionKey();
            String message = messageSource.getMessage(messageKey, be.getParameters(), messageKey, locale);
            res.setCode(be.getCode());
            res.setMessage(message);
        } else {
            res.setMessage(thr.getMessage());
        }
        return res;
    }


    private Throwable getRootCause(Throwable throwable) {
        while (throwable.getCause() != null) {
            throwable = throwable.getCause();
        }
        if (throwable instanceof OgnlException && ((OgnlException) throwable).getReason() != null) {
            return getRootCause(((OgnlException) throwable).getReason());
        }
        return throwable;
    }

    @RequestMapping(value = "/{name}.html")
    public ModelAndView renderView(@PathVariable String name, Model model) {
        return new ModelAndView(name);
    }

    @RequestMapping(value = "/{folder1}/{name}.html")
    public ModelAndView renderFolder1View(@PathVariable String folder1, @PathVariable String name, Model model) {
        return new ModelAndView(
                new StringBuilder(getViewPath()).append("/").append(folder1).append("/").append(name).toString());
    }

    @RequestMapping(value = "/{folder1}/{folder2}/{name}.html")
    public ModelAndView renderFolder2View(@PathVariable String folder1, @PathVariable String folder2,
                                          @PathVariable String name, Model model) {
        return new ModelAndView(new StringBuilder(getViewPath()).append("/").append(folder1).append("/").append(folder2)
                .append("/").append(name).toString());
    }

    @RequestMapping(value = "/{folder1}/{folder2}/{folder3}/{name}.html")
    public ModelAndView renderFolder3View(@PathVariable String folder1, @PathVariable String folder2,
                                          @PathVariable String folder3, @PathVariable String name, Model model) {
        return new ModelAndView(new StringBuilder(getViewPath()).append("/").append(folder1).append("/").append(folder2)
                .append("/").append(folder3).append("/").append(name).toString());
    }


}
