package com.swt.web.viewmodel;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by wtshen on 18/2/17.
 * prefix = "userinfo-config" 此处前缀必须是 kebab（小写或连字符『-』分隔）
 */
@Component
@ConfigurationProperties(prefix = "userinfo-config")
public class UserInfoConfig {
    private String userName;
    private Integer userAge;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}
