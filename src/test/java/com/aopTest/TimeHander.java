package com.aopTest;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name TimeHander
 * @description 横切关注点
 * @date 2018-09-28
 */
public class TimeHander {

    public void printTime() {
        System.out.println("CurrentTime = " + System.currentTimeMillis());
    }
}
