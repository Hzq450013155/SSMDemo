package com.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name IniRealmTest
 * @description
 * @date 2018-10-11
 */
public class IniRealmTest {

    @Test
    public void testIniRealm() {
        IniRealm iniRealm = new IniRealm("classpath:testUser.ini");
        //构建security环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);
        //主题提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("mark", "123456");
        subject.login(token);

        System.out.println("isAuthenticated:" + subject.isAuthenticated());
        subject.checkRoles("admin");
        subject.checkPermission("user:delete");
    }


}
