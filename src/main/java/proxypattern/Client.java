package proxypattern;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class Client {
    public static void main(String[] args) {
        RealSubject1 subject = new RealSubject1();
        ClassLoader classLoader = subject.getClass().getClassLoader();
        Class[] interfaces = subject.getClass().getInterfaces();
        InvocationHandler invocationHandler = new DynamicProxy(subject);
        AbstractSubject proxy = (AbstractSubject) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        // 调用代理的方法
        proxy.request();
        //下面这个是在根目录下生成代理类
        try (FileOutputStream fileOutputStream = new FileOutputStream("subject.class")) {
            fileOutputStream.write(ProxyGenerator.generateProxyClass("subject", interfaces));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

interface AbstractSubject {
    void request();
}

class RealSubject1 implements AbstractSubject {

    @Override
    public void request() {
        System.out.println("我是真实的主题1");
    }
}

class RealSubject2 implements AbstractSubject {

    @Override
    public void request() {
        System.out.println("我是真实的主题2");
    }
}

class DynamicProxy implements InvocationHandler {
    private Object object;

    public DynamicProxy(Object o) {
        this.object = o;
    }

    @Override
    public Object invoke(Object p, Method m, Object[] args) {
        try {
            before();
            return m.invoke(object, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void before() {
        System.out.println("代理之前我做了一些处理");
    }
}
