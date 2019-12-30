package com.ssm.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Copyright (c) 2019. Hand Enterprise Solution Company. All right reserved.
 *
 * @version 1.0
 * @description
 * @date 2019-12-16
 * @Author zongqi.hao@hand-china.com
 */
public class ResponseData {

    // 返回状态编码
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String code;

    // 返回信息
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    //数据
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<?> rows;

    // 成功标识
    private boolean success = true;

    //总数
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long total;

    public ResponseData() {
    }

    public ResponseData(boolean success) {
        setSuccess(success);
    }

    public ResponseData(List<?> list) {
        this(true);
        setRows(list);
        if (list instanceof Page) {
            setTotal(((Page<?>) list).getTotal());
        } else {
            setTotal((long) list.size());
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
