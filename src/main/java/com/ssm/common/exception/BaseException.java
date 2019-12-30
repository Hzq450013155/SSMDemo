package com.ssm.common.exception;

/**
 * Copyright (c) 2019. Hand Enterprise Solution Company. All right reserved.
 *
 * @version 1.0
 * @description
 * @date 2019-12-16
 * @Author zongqi.hao@hand-china.com
 */
public class BaseException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    // e.g. ORDER_FROZEN
    private String code;

    private String descriptionKey;

    private Object[] parameters;

    /**
     * 不应该直接实例化,应该定义子类.
     *
     * @param code           异常 code,通常与模块 CODE 对应
     * @param descriptionKey 异常消息代码,系统描述中定义
     * @param parameters     如果没有参数,可以传 null
     */
    protected BaseException(String code, String descriptionKey, Object[] parameters) {
        super(descriptionKey);
        this.code = code;
        this.descriptionKey = descriptionKey;
        this.parameters = parameters;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescriptionKey() {
        return descriptionKey;
    }

    public void setDescriptionKey(String descriptionKey) {
        this.descriptionKey = descriptionKey;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
