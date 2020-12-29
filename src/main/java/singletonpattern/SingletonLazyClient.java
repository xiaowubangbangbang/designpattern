package singletonpattern;

public class SingletonLazyClient {
    public static void main(String[] args) {
        SingletonLazy instance = SingletonLazy.getInstance();
        SingletonLazy instance1 = SingletonLazy.getInstance();
        System.out.println(instance.getName());
    }
}

class SingletonLazy {
    private String name = "特朗普";
    private static SingletonLazy singletonLazy = null;

    public static SingletonLazy getInstance() {
        return singletonLazy == null ? singletonLazy = new SingletonLazy() : singletonLazy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

