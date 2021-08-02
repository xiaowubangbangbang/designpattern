package bridgepattern;

public class BridgeTest {
    public static void main(String[] args) {
        Implementor concreteImplementorA = new ConcreteImplementorA();
        Abstraction abstraction = new RefinedAbstraction(concreteImplementorA);
        abstraction.operation();
    }
}

interface Implementor {
    void operationImpl();
}

class ConcreteImplementorA implements Implementor {

    @Override
    public void operationImpl() {
        System.out.println("具体实现化(Concrete Implementor)角色被访问");
    }
}

abstract class Abstraction {
    protected Implementor implementor;

    protected Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void operation();
}

class RefinedAbstraction extends Abstraction {
    protected RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        System.out.println("扩展抽象化(Refined Abstraction)角色被访问");
        implementor.operationImpl();
    }
}