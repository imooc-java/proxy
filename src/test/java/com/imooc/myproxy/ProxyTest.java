package com.imooc.myproxy;

import com.imooc.proxy.Car;
import com.imooc.proxy.Moveable;
import org.junit.Test;

/**
 * Created by corning on 2018/1/23.
 */
public class ProxyTest {
    @Test
    public void newProxyInstance() throws Exception {
        Car car = new Car();
        TimeHandler timeHandler = new TimeHandler(car);
        Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class, timeHandler);
        m.move();

    }

    @Test
    public void getProxyClassContent() {
        System.out.println(Proxy.getProxyClassContent(Moveable.class));
    }


}