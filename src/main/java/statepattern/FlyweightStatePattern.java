package statepattern;

import java.util.HashMap;

/**
 * @author xiaowu
 */
public class FlyweightStatePattern {
    public static void main(String[] args) {
        ShareContext shareContext = new ShareContext();
        shareContext.handle();
        shareContext.handle();
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

    public void handle() {
        state.handle(this);
    }

    public ShareState getState(String key) {
        return stateSet.get(key);
    }

    public void setState(ShareState state) {
        this.state = state;
    }
}

interface ShareState {
    void handle(ShareContext shareContext);
}

class ConcreteState1 implements ShareState {

    @Override
    public void handle(ShareContext shareContext) {
        System.out.println("当前状态是： 状态1");
        shareContext.setState(shareContext.getState("2"));
    }
}

class ConcreteState2 implements ShareState {

    @Override
    public void handle(ShareContext shareContext) {
        System.out.println("当前状态是： 状态2");
        shareContext.setState(shareContext.getState("1"));
    }
}