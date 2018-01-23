package com.imooc.proxy;

/**
 * 通过聚合方式实现代理，完成开车时间记录
 */
public class CarLogProxy implements Moveable {

    private Moveable moveable;

    public CarLogProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        System.out.println("log start.");

        moveable.move();

        System.out.println("log end.");
    }
}
