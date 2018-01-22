package com.imooc.proxy;

/**
 * Created by corning on 2018/1/22.
 */
public class Car implements Moveable {
    @Override
    public void move() {
        System.out.println("Car is moving...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
