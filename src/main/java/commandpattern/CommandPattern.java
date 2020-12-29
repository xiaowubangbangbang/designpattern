package commandpattern;

public class CommandPattern {
    public static void main(String[] args) {
        ConcreteCommandA concreteCommandA = new ConcreteCommandA();
        ConcreteCommandB concreteCommandB = new ConcreteCommandB();
        Invoker invoker = new Invoker(concreteCommandA);
        invoker.call();
        invoker = new Invoker(concreteCommandB);
        invoker.call();
    }
}

class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        System.out.println("调用者执行命令command...");
        command.execute();
    }
}

interface Command {
    void execute();
}

class ConcreteCommandA implements Command {
    private ReceiveA receiver;

    ConcreteCommandA() {
        receiver = new ReceiveA();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}

class ConcreteCommandB implements Command {
    private ReceiveB receiver;

    ConcreteCommandB() {
        receiver = new ReceiveB();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}

class ReceiveA {
    public void action() {
        System.out.println("接收者A的action()方法被调用...");
    }
}

class ReceiveB {
    public void action() {
        System.out.println("接收者B的action()方法被调用...");
    }
}