package statepattern;

import java.util.HashMap;

public class FlyweightStatePattern {
    public static void main(String[] args) {
        ShareContext shareContext = new ShareContext();
        shareContext.Handle();
        shareContext.Handle();
    }
}

class ShareContext {
    private HashMap<String, ShareState> stateSet = new HashMap<>();
    private ShareState state;

    ShareContext() {
        state = new ConcreteState1();
        stateSet.put("1", state);
        state = new ConcreteState2();
        stateSet.put("2", state);
        state = getState("1");
    }

    public void Handle() {
        state.Handle(this);
    }

    public ShareState getState(String key) {
        return stateSet.get(key);
    }

    public void setState(ShareState state) {
        this.state = state;
    }
}

abstract class ShareState {
    abstract void Handle(ShareContext shareContext);
}

class ConcreteState1 extends ShareState {

    @Override
    void Handle(ShareContext shareContext) {
        System.out.println("当前状态是： 状态1");
        shareContext.setState(shareContext.getState("2"));
    }
}

class ConcreteState2 extends ShareState {

    @Override
    void Handle(ShareContext shareContext) {
        System.out.println("当前状态是： 状态2");
        shareContext.setState(shareContext.getState("1"));
    }
}