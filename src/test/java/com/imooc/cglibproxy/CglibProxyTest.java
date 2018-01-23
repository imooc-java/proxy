package com.imooc.cglibproxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by corning on 2018/1/23.
 */
public class CglibProxyTest {
    private CglibProxy cglibProxy;

    @Before
    public void setUp() throws Exception {
        cglibProxy = new CglibProxy();
    }

    @After
    public void tearDown() throws Exception {
        cglibProxy = null;
    }

    @Test
    public void getProxy() throws Exception {
        Train train = (Train) cglibProxy.getProxy(Train.class);
        train.move();
    }

}