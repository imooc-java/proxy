package com.imooc.proxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by corning on 2018/1/22.
 */
public class Car2Test {

    private Car2 car2;

    @Before
    public void setUp() throws Exception {
        car2 = new Car2();
    }

    @After
    public void tearDown() throws Exception {
        car2 = null;
    }

    @Test
    public void move() throws Exception {
        car2.move();
    }

}