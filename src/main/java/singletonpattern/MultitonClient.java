package singletonpattern;

import java.util.ArrayList;

public class MultitonClient {
    public static void main(String[] args) {
        Multiton instance = Multiton.getInstance();
        Multiton instance1 = Multiton.getInstance();
        System.out.println(instance1 == instance);
    }
}

class Multiton {
    private static volatile ArrayList<Multiton> arrayList = new ArrayList<>();
    private static volatile int n = 5;

    static {
        for (int i = 0; i < n; i++) {
            arrayList.add(new Multiton(i));
        }
    }

    private Multiton(int n) {

    }

    public static synchronized Multiton getInstance() {
        return arrayList.get((int) (Math.random() * n));
    }
}
