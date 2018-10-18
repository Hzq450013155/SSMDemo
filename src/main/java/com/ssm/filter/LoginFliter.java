package com.ssm.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name LoginFliter
 * @description
 * @date 2018-07-23
 */
public class LoginFliter implements Filter {


    public FilterConfig config;

    public void destroy() {
        this.config = null;
    }

    public static boolean isContains(String container, String[] regx) {
        boolean result = false;
        for (int i = 0; i < regx.length; i++) {
            if (container.indexOf(regx[i]) != -1) {
                return true;
            }
        }
        return result;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest) request;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);
        // 登录登陆页面
        String logonStrings = config.getInitParameter("logonStrings");
        // 过滤资源后缀参数
        String includeStrings = config.getInitParameter("includeStrings");
        // 没有登陆转向页面
        String redirectPath = hrequest.getContextPath() + config.getInitParameter("redirectPath");
        // 过滤器是否有效
        String disabletestfilter = config.getInitParameter("disabletestfilter");
        if (disabletestfilter.toUpperCase().equals("Y")) { // 过滤无效
            chain.doFilter(request, response);
            return;
        }
        String[] logonList = logonStrings.split(";");
        String[] includeList = includeStrings.split(";");
        //只对指定过滤参数后缀进行过滤
        if (!isContains(hrequest.getRequestURI(), includeList)) {
            chain.doFilter(request, response);
            return;
        }
        // 对登录页面不进行过滤
        if (isContains(hrequest.getRequestURI(), logonList)) {
            chain.doFilter(request, response);
            return;
        }
        //判断用户是否登录
        Object user = hrequest.getSession().getAttribute("userId");
        if (user == null) {
            wrapper.sendRedirect(redirectPath);
            return;
        } else {
            chain.doFilter(request, response);
            return;
        }
    }

    public void init(FilterConfig filterConfig) {
        config = filterConfig;
    }
}

