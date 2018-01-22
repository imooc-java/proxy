package com.imooc.proxy;

/**
 * 通过聚合方式实现代理，完成开车时间记录
 */
public class Car3 implements Moveable {

    private Car car;

    public Car3(Car car) {
        this.car = car;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();

        car.move();

        long end = System.currentTimeMillis();
        System.out.println("Car moved time: " + (end - start) + " millisecond");
    }
}
