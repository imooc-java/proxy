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
public class TimeHandlerTest {
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
        Class<? extends Car> carClass = car.getClass();
        InvocationHandler invocationHandler = new TimeHandler(car);

        Moveable m = (Moveable) Proxy.newProxyInstance(carClass.getClassLoader(), carClass.getInterfaces(), invocationHandler);
        m.move();
    }

}