package com.imooc.jdkproxy;

import com.imooc.proxy.Car;
import com.imooc.proxy.Moveable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by corning on 2018/1/23.
 */
public class HandlerTest {
    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car();
    }

    @After
    public void tearDown() throws Exception {
        car = null;
    }

    @Test
    public void invoke() throws Exception {
        // 给 Car 增加日志代理
        Class<? extends Car> carClass = car.getClass();
        LogHandler logHandler = new LogHandler(car);

        // 在日志代理上再加时间代理
        TimeHandler timeHandler = new TimeHandler(logHandler);

        // 获取时间代理代理的被代理类(日志代理)
        InvocationHandler logHandler2 = (InvocationHandler) Proxy.newProxyInstance(logHandler.getClass().getClassLoader(),
                logHandler.getClass().getInterfaces(), timeHandler);
        // 获取日志代理的被代理类(Car)
        Moveable m = (Moveable) Proxy.newProxyInstance(carClass.getClassLoader(), carClass.getInterfaces(), logHandler2);
        // 可以开车了
        m.move();
    }

}