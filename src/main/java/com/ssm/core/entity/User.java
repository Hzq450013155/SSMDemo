package com.ssm.core.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Long age;

    /**
     * 电话
     */
    private String phoneNumber;

    /**
     * 创建时间
     */
    private Date creationDate;

    /**
     * 更新时间
     */
    private Date lastUpdateDate;

    /**
     * 备注
     */
    private String comments;

    /**
     * 用户ID
     *
     * @return USER_ID 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 用户名称
     *
     * @return USER_NAME 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 用户密码
     *
     * @return PASSWORD 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 用户密码
     *
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 性别
     *
     * @return SEX 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 年龄
     *
     * @return AGE 年龄
     */
    public Long getAge() {
        return age;
    }

    /**
     * 年龄
     *
     * @param age 年龄
     */
    public void setAge(Long age) {
        this.age = age;
    }

    /**
     * 电话
     *
     * @return PHONE_NUMBER 电话
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 电话
     *
     * @param phoneNumber 电话
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * 创建时间
     *
     * @return CREATION_DATE 创建时间
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * 创建时间
     *
     * @param creationDate 创建时间
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * 更新时间
     *
     * @return LAST_UPDATE_DATE 更新时间
     */
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * 更新时间
     *
     * @param lastUpdateDate 更新时间
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * 备注
     *
     * @return COMMENTS 备注
     */
    public String getComments() {
        return comments;
    }

    /**
     * 备注
     *
     * @param comments 备注
     */
    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }
}