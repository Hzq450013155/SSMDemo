package com.ssm.security;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * Copyright (c) 2019. Hand Enterprise Solution Company. All right reserved.
 *
 * @version 1.0
 * @description
 * @date 2019-12-08
 * @Author zongqi.hao@hand-china.com
 */
public class passwordManager implements PasswordEncoder, InitializingBean {

    private PasswordEncoder delegate;

    private String siteWideSecret = "my-secret-key";

    private String defaultPassword = "123456";

    public String getDefaultPassword() {
        return defaultPassword;
    }

    public void setDefaultPassword(String defaultPassword) {
        this.defaultPassword = defaultPassword;
    }

    public String getSiteWideSecret() {
        return siteWideSecret;
    }

    public void setSiteWideSecret(String siteWideSecret) {
        this.siteWideSecret = siteWideSecret;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        delegate = new StandardPasswordEncoder(siteWideSecret);
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return delegate.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return delegate.matches(rawPassword, encodedPassword);
    }


}
