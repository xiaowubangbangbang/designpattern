package decoratorpattern;

public class ConcreteDecoratorTest {
    public static void main(String[] args) {
        new ConcreteDecoratorTestA(new ConcreteComponentTest()).operation();
    }
}

interface ConcreteDecoratorInterface {
    void operation();
}

class ConcreteComponentTest implements ConcreteDecoratorInterface {

    @Override
    public void operation() {
        System.out.println("具体构件");
    }
}

class ConcreteDecoratorTestA implements ConcreteDecoratorInterface {
    private ConcreteDecoratorInterface concreteDecoratorInterface;

    ConcreteDecoratorTestA(ConcreteDecoratorInterface concreteDecoratorInterface) {
        this.concreteDecoratorInterface = concreteDecoratorInterface;
    }

    @Override
    public void operation() {
        concreteDecoratorInterface.operation();
    }
}