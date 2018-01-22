package com.imooc.proxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by corning on 2018/1/22.
 */
public class Car3Test {


    private Car3 car3;

    @Before
    public void setUp() throws Exception {
        car3 = new Car3(new Car());
    }

    @After
    public void tearDown() throws Exception {
        car3 = null;
    }

    @Test
    public void move() throws Exception {
        car3.move();
    }

}