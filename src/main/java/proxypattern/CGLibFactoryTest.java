package proxypattern;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibFactoryTest {
    public static void main(String[] args) {
        CGLibFactory libFactory = new CGLibFactory(() -> System.out.println("我request了"));
        AbstractSubject abstractSubject = libFactory.myCGLibCreator();
        abstractSubject.request();
    }
}

class CGLibFactory implements MethodInterceptor {
    // 声明目标类的成员变量
    private AbstractSubject target;

    public CGLibFactory(AbstractSubject target) {
        this.target = target;
    }

    // 定义代理的生成方法,用于创建代理对象
    public AbstractSubject myCGLibCreator() {
        Enhancer enhancer = new Enhancer();
        // 为代理对象设置父类，即指定目标类
        enhancer.setSuperclass(AbstractSubject.class);
        /**
         * 设置回调接口对象 注意，只所以在setCallback()方法中可以写上this，
         * 是因为MethodIntecepter接口继承自Callback，是其子接口
         */
        enhancer.setCallback(this);
        return (AbstractSubject) enhancer.create();// create用以生成CGLib代理对象
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("start invoke " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("end invoke " + method.getName());
        return result;
    }
}