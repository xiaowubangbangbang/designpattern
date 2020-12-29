package facadepattern;

public class Client {
    public static void main(String[] args) {
        new Facade1().method1();
        new Facade2().method2();
    }
}

interface AbstractFacade {
    void method1();

    void method2();
}

class Facade1 implements AbstractFacade {
    private SubSystem1 subSystem1 = new SubSystem1();
    private SubSystem2 subSystem2 = new SubSystem2();
    private SubSystem3 subSystem3 = new SubSystem3();

    @Override
    public void method1() {
        subSystem1.method1();
        subSystem2.method2();
    }

    @Override
    public void method2() {
        subSystem1.method1();
        subSystem3.method3();
    }
}

class Facade2 implements AbstractFacade {

    private SubSystem2 subSystem2 = new SubSystem2();
    private SubSystem3 subSystem3 = new SubSystem3();
    private SubSystem4 subSystem4 = new SubSystem4();

    @Override
    public void method1() {
        subSystem2.method2();
        subSystem3.method3();
    }

    @Override
    public void method2() {
        subSystem3.method3();
        subSystem4.method4();
    }
}

class SubSystem1 {
    public void method1() {
        System.out.println("this is SubSystem1");
    }
}

class SubSystem2 {
    public void method2() {
        System.out.println("this is SubSystem2");
    }
}

class SubSystem3 {
    public void method3() {
        System.out.println("this is SubSystem3");
    }
}

class SubSystem4 {
    public void method4() {
        System.out.println("this is SubSystem4");
    }
}