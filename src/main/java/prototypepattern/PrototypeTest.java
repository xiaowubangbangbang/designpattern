package prototypepattern;

public class PrototypeTest {
    public static void main(String[] args) {
        Realizetype realizetype = new Realizetype();
        Realizetype clone = realizetype.clone();
        System.out.println(realizetype == clone);
    }
}

class Realizetype implements Cloneable {
    Realizetype() {
        System.out.println("具体原型创建成功！");
    }

    public Realizetype clone() {
        System.out.println("具体原型复制成功！");
        try {
            return (Realizetype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
