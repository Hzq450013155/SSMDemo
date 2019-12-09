package com.ssm.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright (c) 2019. Hand Enterprise Solution Company. All right reserved.
 *
 * @version 1.0
 * @description
 * @date 2019-12-08
 * @Author zongqi.hao@hand-china.com
 */
public class LoginFailureHandler implements AuthenticationFailureHandler {
    private static final Logger log = LoggerFactory.getLogger(LoginFailureHandler.class);

    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException exception) throws IOException, ServletException {
        if (log.isDebugEnabled()) {
            log.debug("login failed");
        }
        httpServletRequest.setAttribute("error", true);
        httpServletRequest.setAttribute("exception", exception);
        httpServletRequest.getRequestDispatcher("/login").forward(httpServletRequest, httpServletResponse);
    }
}
