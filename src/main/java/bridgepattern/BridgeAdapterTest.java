package bridgepattern;

public class BridgeAdapterTest {
    public static void main(String[] args) {
        BridgeAdapterAdaptee bridgeAdapterAdaptee = new BridgeAdapterAdaptee();
        BridgeAdapterImplementor objectAdapter = new ObjectAdapter(bridgeAdapterAdaptee);
        BridgeAdapterAbstraction abstraction = new BridgeAdapterRefinedAbstraction(objectAdapter);
        abstraction.operation();
        //桥街模式
        BridgeAdapterImplementor implementor = new ConcreteImplementor();
        BridgeAdapterAbstraction refinedAbstraction = new BridgeAdapterRefinedAbstraction(implementor);
        refinedAbstraction.operation();
    }
}

interface BridgeAdapterImplementor {
    void operationImpl();
}

/**
 * 桥街模式
 */
class ConcreteImplementor implements BridgeAdapterImplementor {

    @Override
    public void operationImpl() {
        System.out.println("桥街模式的实现");
    }
}

/**
 * 适配者模式,因为适配器的实现与桥街模式的实现方法不同
 * 桥街模式:specificRequest
 * 适配器模式:operationImpl
 */
class ObjectAdapter extends ConcreteImplementor {
    private BridgeAdapterAdaptee adapterAdaptee;

    ObjectAdapter(BridgeAdapterAdaptee bridgeAdapterAdaptee) {
        this.adapterAdaptee = bridgeAdapterAdaptee;
    }

    @Override
    public void operationImpl() {
        adapterAdaptee.specificRequest();
    }
}

/**
 * 适配者模式
 */
class BridgeAdapterAdaptee {
    void specificRequest() {
        System.out.println("适配者模式的调用");
    }
}

abstract class BridgeAdapterAbstraction {
    protected BridgeAdapterImplementor bridgeAdapterImplementor;

    protected BridgeAdapterAbstraction(BridgeAdapterImplementor bridgeAdapterImplementor) {
        this.bridgeAdapterImplementor = bridgeAdapterImplementor;
    }

    abstract void operation();
}

class BridgeAdapterRefinedAbstraction extends BridgeAdapterAbstraction {
    protected BridgeAdapterRefinedAbstraction(BridgeAdapterImplementor bridgeAdapterImplementor) {
        super(bridgeAdapterImplementor);
    }

    @Override
    void operation() {
        bridgeAdapterImplementor.operationImpl();
    }
}