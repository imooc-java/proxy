package com.imooc.proxy;

/**
 * 通过继承方式实现代理，完成开车时间记录
 */
public class Car2 extends Car {

    @Override
    public void move() {
        long start = System.currentTimeMillis();

        super.move();

        long end = System.currentTimeMillis();
        System.out.println("Car moved time: " + (end - start) + " millisecond");
    }
}
