/**
 * Copyright (C), 2015-2018, 上海汉得信息技术股份有限公司
 * FileName: Student
 * Author:   zqh
 * Date:     2018-07-17 13:58
 * Description:
 */
package com.hzqweb.core.entity;

import java.io.Serializable;

public class Student implements Serializable {

    private Integer id;
    private String name;
    private Integer sex;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
