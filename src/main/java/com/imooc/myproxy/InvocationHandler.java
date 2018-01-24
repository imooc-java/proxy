package com.imooc.myproxy;

import java.lang.reflect.Method;

/**
 * Created by corning on 2018/1/23.
 */
public interface InvocationHandler {

    void invoke(Object o, Method method);

}
