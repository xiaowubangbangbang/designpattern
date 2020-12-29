package facadepattern;

/**
 * 外观模式
 */
public class FacadePattern {
    public static void main(String[] args) {
        new Facade().method();
    }
}

class Facade {
    private SubSystem01 subSystem01 = new SubSystem01();
    private SubSystem02 subSystem02 = new SubSystem02();
    private SubSystem03 subSystem03 = new SubSystem03();

    void method() {
        subSystem01.method1();
        subSystem02.method2();
        subSystem03.method3();
    }
}

class SubSystem01 {
    public void method1() {
        System.out.println("SubSystem01:method1");
    }
}

class SubSystem02 {
    public void method2() {
        System.out.println("SubSystem02:method2");
    }
}

class SubSystem03 {
    public void method3() {
        System.out.println("SubSystem03:method3");
    }
}