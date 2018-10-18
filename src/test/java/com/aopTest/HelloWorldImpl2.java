package com.aopTest;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name HelloWorldImpl2
 * @description
 * @date 2018-09-28
 */
public class HelloWorldImpl2 implements HelloWorld {

    public void printHelloWorld() {
        System.out.println("Enter HelloWorldImpl2.printHelloWorld()");
    }

    public void doPrint() {
        System.out.println("Enter HelloWorldImpl2.doPrint()");
        return;
    }
}
