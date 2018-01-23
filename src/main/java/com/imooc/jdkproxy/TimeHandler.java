package com.imooc.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by corning on 2018/1/23.
 */
public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Car start move...");

        if (target instanceof InvocationHandler) {
            method.invoke(target, args);
        } else {
            method.invoke(target);
        }

        long end = System.currentTimeMillis();
        System.out.println("Car moved time: " + (end - start) + " millisecond");
        return null;
    }
}
