package decoratorpattern;

/**
 * @author xiaowu
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        System.out.println("未加装饰的代码");
        ConcreteComponent concreteComponent = new ConcreteComponent();
        concreteComponent.operation();
        System.out.println("通过装饰者A装饰");
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA(concreteComponent);
        concreteDecoratorA.operation();
        System.out.println("通过装饰者B装饰");
        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB(concreteDecoratorA);
        concreteDecoratorB.operation();
    }
}

interface Component {
    void operation();
}


class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("具体的构件");
    }
}

class Decorator implements Component {
    private Component component;

    Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

class ConcreteDecoratorA extends Decorator {

    ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addedFunction();
    }

    public void addedFunction() {
        System.out.println("为具体构件角色A增加额外的功能addedFunction()");
    }
}

class ConcreteDecoratorB extends Decorator {

    ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addedFunction();
    }

    public void addedFunction() {
        System.out.println("为具体构件角色B增加额外的功能addedFunction()");
    }
}