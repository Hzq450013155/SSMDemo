//package com.ssm.core.controller;
//
//import com.ssm.core.service.UserService;
//import com.ssm.util.JsonResult;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.DefaultRedirectStrategy;
//import org.springframework.security.web.RedirectStrategy;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Date;
//
///**
// * @author zongqi.hao@hand-china.com
// * @version 1.0
// * @name LoginController
// * @description 登录验证控制器
// * @date 2018-10-11
// */
//@Controller
//public class LoginController implements AuthenticationSuccessHandler, AuthenticationFailureHandler, InitializingBean {
//
//    @Autowired
//    private UserService iUserService;
//
//    private String successURL;
//
//    private String failURL;
//
//    private boolean byForward = false;
//
//    private String AttrName;
//
//    private String userInfo;
//
//    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//
//    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
//
//    public void setSuccessURL(String successURL) {
//        this.successURL = successURL;
//    }
//
//    public void setFailURL(String failURL) {
//        this.failURL = failURL;
//    }
//
//    public void setByForward(boolean byForward) {
//        this.byForward = byForward;
//    }
//
//    public void setAttrName(String attrName) {
//        AttrName = attrName;
//    }
//
//    public void setUserInfo(String userInfo) {
//        this.userInfo = userInfo;
//    }
//
//
//    public void afterPropertiesSet() throws Exception {
//        if (StringUtils.isEmpty(successURL))
//            throw new ExceptionInInitializerError("成功后跳转的地址未设置!");
//        if (StringUtils.isEmpty(failURL))
//            throw new ExceptionInInitializerError("失败后跳转的地址未设置!");
//        if (StringUtils.isEmpty(AttrName))
//            throw new ExceptionInInitializerError("Attr的Key值未设置!");
//    }
//
//    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//        JsonResult jsonResult;
////        logger.info("登录失败:请求IP地址[{}];失败原因:{};", HttpUtil.getIP(request), exception.getMessage());
//        jsonResult = JsonResult.error(exception.getMessage());
//        request.getSession().setAttribute(AttrName, jsonResult);
//        httpReturn(request, response, false);
//    }
//
//
//    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
////        SysUsers users;
////        JsonResult jsonResult;
////        try {
////            users = (SysUsers) authentication.getPrincipal();
////            Date date = new Date();
////            users.setLastLogin(date);
////            users.setLoginIp(HttpUtil.getIP(request));
////            try {
////                iUserService.updateUserLoginInfo(users);
////            } catch (DataAccessException e) {
////                logger.error("登录异常:保存登录数据失败!", e);
////            }
////        } catch (Exception e) {
////            jsonResult = JsonResult.error("用户登录信息保存失败!");
////            logger.error("登录异常:用户登录信息保存失败!", e);
////            request.getSession().setAttribute(AttrName, jsonResult);
////            return;
////        }
////        jsonResult = JsonResult.success("登录验证成功!", users);
////        request.getSession().setAttribute(userInfo, jsonResult);
////        httpReturn(request, response, true);
//    }
//
//
//    private void httpReturn(HttpServletRequest request, HttpServletResponse response, boolean success) throws IOException, ServletException {
//        if (success) {
//            if (this.byForward) {
//                logger.info("登录成功:Forwarding to [{}]", successURL);
//                request.getRequestDispatcher(this.successURL).forward(request, response);
//            } else {
//                logger.info("登录成功:Redirecting to [{}]", successURL);
//                this.redirectStrategy.sendRedirect(request, response, this.successURL);
//            }
//        } else {
//            if (this.byForward) {
//                logger.info("登录失败:Forwarding to [{}]", failURL);
//                request.getRequestDispatcher(this.failURL).forward(request, response);
//            } else {
//                logger.info("登录失败:Redirecting to [{}]", failURL);
//                this.redirectStrategy.sendRedirect(request, response, this.failURL);
//            }
//        }
//
//
//    }
//}