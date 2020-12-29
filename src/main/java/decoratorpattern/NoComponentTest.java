package decoratorpattern;

public class NoComponentTest {
    public static void main(String[] args) {
        //未加装饰的构件
        new ConcreteComponentNoInterface().operation();
        //通过A装饰
        new DecoratorConcreteA(new ConcreteComponentNoInterface()).operation();
    }
}

class ConcreteComponentNoInterface {
    public void operation() {
        System.out.println("无抽象装饰的具体构件");
    }
}

class DecoratorNoInterface extends ConcreteComponentNoInterface {

    DecoratorNoInterface(ConcreteComponentNoInterface concreteComponentNoInterface) {
    }
}

class DecoratorConcreteA extends DecoratorNoInterface {

    DecoratorConcreteA(ConcreteComponentNoInterface component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addedFunction();
    }

    private void addedFunction() {
        System.out.println("为具体构件角色A增加额外的功能addedFunction()");
    }
}

class DecoratorConcreteB extends DecoratorNoInterface {
    DecoratorConcreteB(ConcreteComponentNoInterface concreteComponentNoInterface) {
        super(concreteComponentNoInterface);
    }

    @Override
    public void operation() {
        super.operation();
        addedFunction();
    }

    private void addedFunction() {
        System.out.println("为具体构件角色B增加额外的功能addedFunction()");
    }
}