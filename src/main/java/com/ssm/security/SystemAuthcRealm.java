package com.ssm.security;

import com.ssm.core.entity.User;
import com.ssm.core.service.UserRolesService;
import com.ssm.core.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name CustomRealm
 * @description 自定义Realm
 * @date 2018-10-11
 */
public class SystemAuthcRealm extends AuthorizingRealm {

    private final Logger logger = Logger.getLogger(SystemAuthcRealm.class);

    @Autowired
    UserService userService;

    @Autowired
    UserRolesService userRolesService;

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        Set<String> roles = getRolesByUsername(userName);
        Set<String> permission = getPermissionByUsername(userName);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permission);
        info.setRoles(roles);
        return info;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取凭证
        String username = (String) authenticationToken.getPrincipal();
        //2.通过用户名到数据库获取凭证
        String password = getPasswordByUsername(username);
        if (password == null) {
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, "SystemAuthcRealm");
        info.setCredentialsSalt(ByteSource.Util.bytes(username));
        return info;
    }


    private String getPasswordByUsername(String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return user.getPassword();
        }
        return null;
    }

    private Set<String> getRolesByUsername(String username) {
        logger.info("=============从数据库获取角色信息==================");
        List<String> list = userRolesService.getRolesByUsername(username);
        Set<String> sets = new HashSet<String>(list);
        return sets;
    }

    private Set<String> getPermissionByUsername(String username) {
        Set<String> sets = new HashSet<String>();
        sets.add("user:delete");
        sets.add("user:add");
        sets.add("admin:add");
        return sets;
    }

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456", "xll");
        System.out.println(md5Hash.toString());
    }
}
