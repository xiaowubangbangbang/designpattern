package decoratorpattern;

public class MorriganAensland {
    public static void main(String[] args) {
        Orginal orginal = new Orginal();
        orginal.display();
        Succubus succubus = new Succubus(orginal);
        succubus.display();
        Girl girl = new Girl(orginal);
        girl.display();
    }
}

interface Morrigan {
    void display();
}

class Orginal implements Morrigan {

    @Override
    public void display() {
        System.out.println("莫莉卡原身");
    }
}

class Changer implements Morrigan {
    private Morrigan morrigan;

    Changer(Morrigan morrigan) {
        this.morrigan = morrigan;
    }

    @Override
    public void display() {
        morrigan.display();
    }
}

class Succubus extends Changer {

    Succubus(Morrigan morrigan) {
        super(morrigan);
    }

    @Override
    public void display() {
        super.display();
        setChanger();
    }

    public void setChanger() {
        System.out.println("变身成女妖了");
    }
}

class Girl extends Changer {

    Girl(Morrigan morrigan) {
        super(morrigan);
    }

    @Override
    public void display() {
        super.display();
        setChanger();
    }

    public void setChanger() {
        System.out.println("变身成女孩了");
    }
}