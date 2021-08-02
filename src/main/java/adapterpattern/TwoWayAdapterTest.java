package adapterpattern;

/**
 * 该模式的主要优点如下。
 * 客户端通过适配器可以透明地调用目标接口。
 * 复用了现存的类，程序员不需要修改原有代码而重用现有的适配者类。
 * 将目标类和适配者类解耦，解决了目标类和适配者类接口不一致的问题。
 * 在很多业务场景中符合开闭原则。
 * <p>
 * 其缺点是：
 * 适配器编写过程需要结合业务场景全面考虑，可能会增加系统的复杂性。
 * 增加代码阅读难度，降低代码可读性，过多使用适配器会使系统代码变得凌乱。
 * 1. 模式的结构
 * 适配器模式（Adapter）包含以下主要角色。
 * 目标（Target）接口：当前系统业务所期待的接口，它可以是抽象类或接口。
 * 适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口。
 * 适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。
 */
public class TwoWayAdapterTest {
    public static void main(String[] args) {
        //目标访问适配者
        TwoWayAdapter twoWayAdapter = new TwoWayAdapter(new AdapteeRealize());
        twoWayAdapter.request();
        //适配者访问目标
        TwoWayAdapter adapter = new TwoWayAdapter(new TargetRealize());
        adapter.request();
    }
}

/**
 * 目标接口
 */
interface TwoWayTarget {
    /**
     * request
     */
    void request();
}

interface TwoWayAdaptee {
    void specificRequest();
}

class TargetRealize implements TwoWayTarget {

    @Override
    public void request() {
        System.out.println("目标代码被调用！");
    }
}

/**
 * 适配者实现
 */
class AdapteeRealize implements TwoWayAdaptee {
    @Override
    public void specificRequest() {
        System.out.println("适配者代码被调用！");
    }
}

/**
 * 双向适配器
 */
class TwoWayAdapter implements TwoWayTarget, TwoWayAdaptee {
    private TwoWayTarget target;
    private TwoWayAdaptee adaptee;

    public TwoWayAdapter(TwoWayTarget target) {
        this.target = target;
    }

    public TwoWayAdapter(TwoWayAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }

    @Override
    public void specificRequest() {
        target.request();
    }
}