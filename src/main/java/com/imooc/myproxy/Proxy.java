package com.imooc.myproxy;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.nio.charset.Charset;

/**
 * Created by corning on 2018/1/23.
 */
public class Proxy {

    public static final String CHARSET = "UTF-8";

    public static Object newProxyInstance(Class infce, InvocationHandler invocationHandler) throws Exception {
        // 生产代理类内容
        String proxyClassContent = getProxyClassContent(infce);
        // 获取代理类 java 文件名
        String proxyJavaFileName = getProxyJavaFileName();
        // 将代理类写到 java 文件中
        writeAsJava(proxyJavaFileName, proxyClassContent);
        // 对代理类进行编译(javac xxx.java)
        compilerProxyFile(proxyJavaFileName);
        // 加载编译好的 class 文件
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> proxyClass = classLoader.loadClass("com.imooc.myproxy.$Proxy0");
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        return constructor.newInstance(invocationHandler);
    }

    private static void compilerProxyFile(String proxyJavaFileName) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, Charset.forName(CHARSET));
        Iterable<? extends JavaFileObject> units = fileManager.getJavaFileObjects(proxyJavaFileName);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, units);
        task.call();
        fileManager.close();
    }

    /**
     * 通过代理模版 proxyClass.vm 和 接口类 自动生成代理类
     *
     * @param infce
     * @return
     * @see Velocity
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

    static void writeAsJava(String proxyJavaFileName, String classStr) throws IOException {
        FileUtils.writeStringToFile(new File(proxyJavaFileName), classStr, CHARSET);
    }

    private static String getProxyJavaFileName() {
        String path = Proxy.class.getResource(".").getFile();
        return path + "$Proxy0.java";
    }

}
