package com.ssm.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionKey;

import javax.servlet.ServletRequest;
import java.io.Serializable;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name SystemSessionManager
 * @description session管理器
 * @date 2018-10-15
 */
public class SystemSessionManager extends DefaultWebSessionManager {

//    @Override
//    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
//        // 如果参数中包含“__sid”参数，则使用此sid会话。 例如：http://localhost/project?__sid=xxx&__cookie=true
//        String sid = request.getParameter("__sid");
//        if (org.apache.commons.lang3.StringUtils.isNotBlank(sid)) {
//        // 是否将sid保存到cookie，浏览器模式下使用此参数。
//            if (WebUtils.isTrue(request, "__cookie")) {
//                HttpServletRequest rq = (HttpServletRequest) request;
//                HttpServletResponse rs = (HttpServletResponse) response;
//                Cookie template = getSessionIdCookie();
//                Cookie cookie = new SimpleCookie(template);
//                cookie.setValue(sid);
//                cookie.saveTo(rq, rs);
//            }
//            // 设置当前session状态
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,
//                    ShiroHttpServletRequest.URL_SESSION_ID_SOURCE); // session来源与url
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, sid);
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
//            return sid;
//        } else {
//            return super.getSessionId(request, response);
//        }
//
//    }

    @Override
    protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {
        Serializable sessionId = getSessionId(sessionKey);
        ServletRequest request = null;
        if (sessionKey instanceof WebSessionKey) {
            request = ((WebSessionKey) sessionKey).getServletRequest();
        }
        if (request != null && sessionId != null) {
            Session session = (Session) request.getAttribute(sessionId.toString());
            if (session != null) {
                return session;
            }
        }
        Session session = super.retrieveSession(sessionKey);
        if (request != null && sessionId != null) {
            request.setAttribute(sessionId.toString(), session);
        }
        return session;
    }


}
