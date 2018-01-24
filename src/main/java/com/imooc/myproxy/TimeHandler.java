package com.imooc.myproxy;

import java.lang.reflect.InvocationTargetException;
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
    public void invoke(Object o, Method method) {
        try {
            long start = System.currentTimeMillis();
            System.out.println("Car start move...");

            method.invoke(target);

            long end = System.currentTimeMillis();
            System.out.println("Car moved time: " + (end - start) + " millisecond");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
