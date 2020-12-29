package singletonpattern;

public class SingletonEagerClient {
    public static void main(String[] args) {
        SingletonEager singletonEager = SingletonEager.getSingletonEager();
        SingletonEager singletonEager1 = SingletonEager.getSingletonEager();
        System.out.println(singletonEager1 == singletonEager);
    }
}

class SingletonEager {
    public static SingletonEager singletonEager = new SingletonEager();

    public static SingletonEager getSingletonEager() {
        return singletonEager;
    }
}
