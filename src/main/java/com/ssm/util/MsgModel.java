package com.ssm.util;

import java.io.Serializable;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name MsgModel
 * @description
 * @date 2018-07-23
 */
public class MsgModel<T> implements Serializable {

    /**
     * @Fields msg : 消息
     */
    private String msg;
    /**
     * @Fields status : 调用状态 0.成功 1.失败
     */
    private Integer status = 0;
    /**
     * @Fields code : 状态编码
     */
    private String code;
    /**
     * @Fields data : 返回数据
     */
    private T data;


    public MsgModel() {

    }

    public MsgModel(String msg) {
        this.msg = msg;
    }

    public MsgModel(String msg, Integer status) {
        this.msg = msg;
        this.status = status;
    }

    public MsgModel(String msg, RespStatusEnum statusEnum) {
        this.msg = msg;
        this.status = statusEnum.ordinal();
    }

    public MsgModel(String msg, Integer status, T data) {
        this.msg = msg;
        this.status = status;
        this.data = data;
    }

    public MsgModel(String msg, RespStatusEnum statusEnum, T data) {
        this.msg = msg;
        this.status = statusEnum.ordinal();
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return RespStatusEnum.SUCCESS.ordinal() == status || RespStatusEnum.SUCCESS.ordinal() == status.intValue();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
