package com.shiro;

import com.ssm.security.SystemAuthcRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name SystemAuthcRealmTest
 * @description
 * @date 2018-10-11
 */
public class SystemAuthcRealmTest {


    @Test
    public void testAuthentication2() {
        SystemAuthcRealm realm = new SystemAuthcRealm();

        //构建security环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);
        //主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("mark", "123");
        subject.login(token);

        System.out.println("isAuthenticated:" + subject.isAuthenticated());
//        subject.checkRoles("admin","manager1");
//        subject.logout();
//
//        System.out.println("isAuthenticated:" + subject.isAuthenticated());

    }

}
