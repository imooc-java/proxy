package com.imooc.proxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by corning on 2018/1/22.
 */
public class CarTimeProxyTest {


    private CarTimeProxy carTimeProxy;

    @Before
    public void setUp() throws Exception {
        carTimeProxy = new CarTimeProxy(new Car());
    }

    @After
    public void tearDown() throws Exception {
        carTimeProxy = null;
    }

    @Test
    public void move() throws Exception {
        carTimeProxy.move();
    }

}