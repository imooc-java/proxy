动态代理实现思路

实现功能: 通过 Proxy 的 newProxyInstance 返回代理对象

1. 声明一段源码(动态产生代理)
2. 编译源码(JDK Compiler API)，产生新的类(代理类)
3. 将这个类load到内存当中，产生一个新的对象(代理对象)
4. return 代理对象

## 其他

* 通过 [Velocity](http://velocity.apache.org/engine/2.0/index.html) 实现

## 通过Velocity生成的源码

### 组合模式实现

```java
package com.imooc.myproxy;

public class $Proxy0 implements com.imooc.proxy.Moveable {

    private com.imooc.proxy.Moveable infce;

    public $Proxy0(com.imooc.proxy.Moveable infce) {
        this.infce = infce;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("Car start move...");

        infce.move();

        long end = System.currentTimeMillis();
        System.out.println("Car moved time: " + (end - start) + " millisecond");
    }
}

```

### InvocationHandler 方式实现

```java
package com.imooc.myproxy;

import com.imooc.myproxy.InvocationHandler;

import java.lang.reflect.Method;

public class $Proxy0 implements com.imooc.proxy.Moveable {

    private InvocationHandler invocationHandler;

    public $Proxy0(InvocationHandler invocationHandler) {
        this.invocationHandler = invocationHandler;
    }

    @Override
    public void move() {
        try {
            Method method = com.imooc.proxy.Moveable.class.getMethod("move", new Class[0]);
            invocationHandler.invoke(this, method);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```