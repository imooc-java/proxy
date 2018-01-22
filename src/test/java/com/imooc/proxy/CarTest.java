package com.imooc.proxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by corning on 2018/1/22.
 */
public class CarTest {

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
    public void move() throws Exception {
        car.move();
    }

}