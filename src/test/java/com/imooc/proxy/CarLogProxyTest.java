package com.imooc.proxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by corning on 2018/1/23.
 */
public class CarLogProxyTest {
    private CarLogProxy carLogProxy;

    @Before
    public void setUp() throws Exception {
        carLogProxy = new CarLogProxy(new Car());
    }

    @After
    public void tearDown() throws Exception {
        carLogProxy = null;
    }

    @Test
    public void move() throws Exception {
        carLogProxy.move();
    }

}