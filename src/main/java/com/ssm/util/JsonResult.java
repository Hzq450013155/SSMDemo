//package com.ssm.util;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.Serializable;
//
///**
// * @author zongqi.hao@hand-china.com
// * @version 1.0
// * @name JsonResult
// * @description
// * @date 2018-10-11
// */
//public class JsonResult implements Serializable {
//
//    private static final long serialVersionUID = 8134245754393400511L;
//
//    private boolean status = true;
//    private String message;
//    private Object data;
//    private static Logger logger = LoggerFactory.getLogger(JsonResult.class);
//
//    public JsonResult() {
//    }
//
//    public JsonResult(Object data) {
//        this.data = data;
//    }
//
//    public boolean getStatus() {
//        return status;
//    }
//
//    public JsonResult setStatus(boolean status) {
//        this.status = status;
//        return this;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public JsonResult setMessage(String message) {
//        this.message = message;
//        return this;
//    }
//
//    public Object getData() {
//        return data;
//    }
//
//    public JsonResult setData(Object data) {
//        this.data = data;
//        return this;
//    }
//
//    public static JsonResult success() {
//        return new JsonResult().setStatus(true);
//    }
//
//    public static JsonResult success(Object data) {
//        JsonResult jsonResult = success().setData(data);
//        logger.info(jsonResult.toString());
//        return jsonResult;
//    }
//
//    public static JsonResult success(String message, Object data) {
//        JsonResult jsonResult = success().setData(data).setMessage(message);
//        logger.info(jsonResult.toString());
//        return jsonResult;
//    }
//
//    public static JsonResult error() {
//        return new JsonResult().setStatus(false);
//    }
//
//    public static JsonResult error(String message) {
//        JsonResult jsonResult = error().setMessage(message);
//        logger.info(jsonResult.toString());
//        return jsonResult;
//    }
//
//    @Override
//    public String toString() {
//        return "JsonResult{" +
//                "status=" + status +
//                ", message='" + message + '\'' +
//                ", data=" + data +
//                '}';
//    }
//}