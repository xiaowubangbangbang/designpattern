package mementopattern;

public class MementoPattern {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setState("S0");
        System.out.println("发起人初始状态:" + originator.getState());
        //保存状态
        caretaker.setMemento(originator.createMemento());
        originator.setState("S1");
        System.out.println("发起人改变了状态:" + originator.getState());
        //发起人还原状态
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("还原之后的状态为:" + originator.getState());
    }
}

class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

//发起人
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(Memento m) {
        this.setState(m.getState());
    }
}

//管理者
class Caretaker {
    private Memento memento;

    public void setMemento(Memento m) {
        memento = m;
    }

    public Memento getMemento() {
        return memento;
    }
}