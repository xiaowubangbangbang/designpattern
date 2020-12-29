package prototypepattern;

public class ProtoTypeWukongTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        MonkeySun monkeySun = new MonkeySun();
        monkeySun.setName("monkeySun01");
        MonkeySun clone = monkeySun.clone();
        System.out.println(clone.getName());
    }
}


class MonkeySun implements Cloneable {
    private String name;

    @Override
    protected MonkeySun clone() throws CloneNotSupportedException {
        return (MonkeySun) super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}