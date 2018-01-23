package com.imooc.proxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by corning on 2018/1/22.
 */
public class CarProxyTest {

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
    public void move1() throws Exception {
        System.out.println("test move1： 先记录日志，再记录时间");
        CarTimeProxy carTimeProxy = new CarTimeProxy(car);
        CarLogProxy carLogProxy = new CarLogProxy(carTimeProxy);
        carLogProxy.move();
    }

    @Test
    public void move2() throws Exception {
        System.out.println("test move2： 先记录时间，再记录日志");
        CarLogProxy carLogProxy = new CarLogProxy(car);
        CarTimeProxy carTimeProxy = new CarTimeProxy(carLogProxy);
        carTimeProxy.move();
    }
}