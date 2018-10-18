package com.aopTest;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name LogHandler
 * @description 日志
 * @date 2018-09-28
 */
public class LogHandler {

    public void LogBefore() {
        System.out.println("Log before method");
    }

    public void LogAfter() {
        System.out.println("Log after method");
    }
}
