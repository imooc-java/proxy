package com.imooc.myproxy;

import com.imooc.proxy.Moveable;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by corning on 2018/1/23.
 */
public class ProxyTest {
    @Test
    public void newProxyInstance() throws Exception {
        System.out.println(Proxy.newProxyInstance(Moveable.class));
    }

    @Test
    public void write2Java() throws IOException {
        Proxy.writeAsJava("xxx");
    }

    @Test
    public void getProxyClassContent() {
        System.out.println(Proxy.getProxyClassContent(Moveable.class));
    }

}