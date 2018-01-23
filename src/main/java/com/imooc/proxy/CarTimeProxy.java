package com.imooc.proxy;

/**
 * 通过聚合方式实现代理，完成开车时间记录
 */
public class CarTimeProxy implements Moveable {

    private Moveable moveable;

    public CarTimeProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("Car start move...");

        moveable.move();

        long end = System.currentTimeMillis();
        System.out.println("Car moved time: " + (end - start) + " millisecond");
    }
}
