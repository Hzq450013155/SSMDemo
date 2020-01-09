package com.ssm.security;

import com.ssm.common.exception.UserException;
import com.ssm.core.entity.User;
import com.ssm.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Copyright (c) 2019. Hand Enterprise Solution Company. All right reserved.
 *
 * @version 1.0
 * @description
 * @date 2019-12-08
 * @Author zongqi.hao@hand-china.com
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found:" + username);
        }

        checkUserException(user);

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        UserDetails userDetails = new CustomUserDetails(user.getUserId(), user.getUserName(),
                user.getPassword(), true, true, true, true, authorities);
        return userDetails;
    }

    /**
     * 用户有效性校验
     *
     * @param user
     */
    private void checkUserException(User user) {
        UserException ue = null;
//        if (User.STATUS_LOCK.equalsIgnoreCase(user.getStatus())) {
//            ue = new UserException(UserException.ERROR_USER_LOCKED, null);
//        } else
//        if (user.getStartActiveDate() != null
//                && user.getStartActiveDate().getTime() > System.currentTimeMillis()) {
//            ue = new UserException(UserException.ERROR_USER_NOT_ACTIVE, null);
//        } else if (user.getEndActiveDate() != null && user.getEndActiveDate().getTime() < System.currentTimeMillis()) {
//            ue = new UserException(UserException.ERROR_USER_EXPIRED, null);
//        }
//        if (ue != null) {
//            throw new RuntimeException(ue);
//        }
    }

}

