package adapterpattern;

//客户端代码
public class ClassAdapterTest {
    public static void main(String[] args) {
        ClassAdapter classAdapter = new ClassAdapter();
        classAdapter.request();
        ObjectAdapter objectAdapter = new ObjectAdapter(new Adaptee());
        objectAdapter.request();
    }
}

interface Target {
    void request();
}

/**
 * 类适配器
 */
class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        specificRequest();
    }
}

class Adaptee {
    void specificRequest() {
        System.out.println("适配者中的业务代码被调用！");
    }
}

/**
 * 对象适配器
 */
class ObjectAdapter implements Target {
    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.specificRequest();
    }
}