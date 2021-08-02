package strategypattern;

/**
 * 举个简单例子，有一个玩游戏的策略类，提供一个playGame的方法，
 * 一般而言游戏可以分为Moba类、FPS类、模拟经营类、棋牌类等等
 * ，这些不同类型的游戏可以看作是不同策略，因为他们玩法大不相同。
 * 然而针对同一类型下的游戏，又可以在PC、XBox、手机甚至VR体感设备等玩耍。
 * 此时可以提供抽象类提供通用的操作方法，使用抽象方法来引导子类实现。例如Moba类游戏，
 * 不管在那个平台上都会有选人，开始游戏。而FPS类则基本打开游戏就可以直接玩
 * 。因此可以针对不同类型游戏提供统一的父类来减少冗余代码。
 *
 * 作者：Yancey_Z
 * 链接：https://juejin.cn/post/6844903895290871816
 * 来源：掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author xiaowu
 */
public class StrategyTemplateTest {
    public static void main(String[] args) {
        GamePlatFrom pc = new MobaPC();
        StrategyTemplateContext strategyTemplateContext = new StrategyTemplateContext();
        strategyTemplateContext.setStrategy(pc);
      strategyTemplateContext.strategyMethod();
    }
}

interface GamePlatFrom {
    void strategyMethod();
}

/**
 * Moba游戏玩法
 */
abstract class Moba implements GamePlatFrom {

    /**
     * 获取动作
     */
    public void getAction() {
        System.out.println("我是Moba模板,我正在获取动作");
    }

    /**
     * 获取方法
     */
    public void getMethod() {
        System.out.println("我是Moba模板,我正在获取方法");
    }

    abstract void getAttributes();

    @Override
    public void strategyMethod() {
        getAction();
        getAttributes();
    }
}

class MobaPC extends Moba {

    @Override
    void getAttributes() {
        System.out.println("获取鼠标键盘");
    }
}

class MobaXBox extends Moba {

    @Override
    void getAttributes() {
        System.out.println("获取手柄");
    }
}

abstract class FPS implements GamePlatFrom {
    /**
     * 获取动作
     */
    public void getAction() {
        System.out.println("我是FPS模板,我正在获取动作");
    }

    /**
     * 获取方法
     */
    public void getMethod() {
        System.out.println("我是FPS模板,我正在获取方法");
    }

    abstract void getAttributes();

    @Override
    public void strategyMethod() {
        getAction();
        getAttributes();
    }
}

class FPSPC extends FPS {

    @Override
    void getAttributes() {
        System.out.println("我是FPS,啥也不干,打开直接玩了");
    }
}

class FPSXBox extends FPS {

    @Override
    void getAttributes() {
        System.out.println("我是FPS的XBox.我要直接上了");
    }
}

abstract class Chess implements GamePlatFrom {
    /**
     * 获取动作
     */
    public void getAction() {
        System.out.println("我是Chess模板,我正在获取动作");
    }

    /**
     * 获取方法
     */
    public void getMethod() {
        System.out.println("我是Chess模板,我正在获取方法");
    }

    abstract void getAttributes();

    @Override
    public void strategyMethod() {
        getAction();
        getAttributes();
    }
}

class ChessPC extends Chess {

    @Override
    void getAttributes() {
        System.out.println("我是Chess,我得等所有人员加载完毕");
    }
}

class ChessXBox extends Chess {

    @Override
    void getAttributes() {
        System.out.println("我是Chess的XBox.我得等所有人员加载完毕");
    }
}

//环境类
class StrategyTemplateContext {
    private GamePlatFrom strategy;

    public GamePlatFrom getStrategy() {
        return strategy;
    }

    public void setStrategy(GamePlatFrom strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.strategyMethod();
    }
}