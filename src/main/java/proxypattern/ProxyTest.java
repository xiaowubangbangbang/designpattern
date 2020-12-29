package proxypattern;

public class ProxyTest {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}

interface Subject {
    void request();
}

class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("我是真实的主题");
    }
}

class Proxy implements Subject {
    private RealSubject realSubject;

    private void preRequest() {
        System.out.println("访问真实主题之前的预处理。");
    }

    private void postRequest() {
        System.out.println("访问真实主题之后的后续处理。");
    }

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.request();
        postRequest();
    }
}