package com.imooc.myproxy;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by corning on 2018/1/23.
 */
public class Proxy {

    public static final String CHARSET = "UTF-8";

    public static Object newProxyInstance(Class infce) throws IOException {
        String proxyClassContent = getProxyClassContent(infce);

        writeAsJava(proxyClassContent);

        return null;
    }

    /**
     * 通过代理模版 proxyClass.vm 和 接口类 自动生成代理类
     *
     * @see Velocity
     *
     * @param infce
     * @return
     */
    static String getProxyClassContent(Class infce) {
        Velocity.init();

        String proxyPath = "/src/main/java/com/imooc/myproxy/proxyClass.vm";
        Template proxyTemplate = Velocity.getTemplate(proxyPath);

        VelocityContext context = new VelocityContext();
        context.put("interface", infce.getName());
        context.put("methods", infce.getMethods());

        StringWriter proxyWriter = new StringWriter();
        proxyTemplate.merge(context, proxyWriter);

        return proxyWriter.toString();
    }

    static void writeAsJava(String classStr) throws IOException {
        String path = Proxy.class.getResource(".").getFile();
        String filePath = path + "$Proxy.java";
        FileUtils.writeStringToFile(new File(filePath), classStr, CHARSET);
    }

}
