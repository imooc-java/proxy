package com.imooc.jdkproxy;

import com.imooc.proxy.Car;
import com.imooc.proxy.Moveable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

/**
 * Created by corning on 2018/1/23.
 */
public class LogHandlerTest {
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
        LogHandler logHandler = new LogHandler(car);

        Moveable m = (Moveable) Proxy.newProxyInstance(carClass.getClassLoader(), carClass.getInterfaces(), logHandler);
        m.move();
    }

}