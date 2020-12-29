package singletonpattern;

public class LazySingletonClient {
    public static void main(String[] args) {
        LazySingleton instance = LazySingleton.getInstance();
        LazySingleton instance1 = LazySingleton.getInstance();
        System.out.println(instance == instance1);
    }
}

class LazySingleton {
    private static LazySingleton lazySingleton = null;

    public static LazySingleton getInstance() {
        return lazySingleton == null ? lazySingleton = new LazySingleton() : lazySingleton;
    }
} 