package statepattern;

public class ScoreStateThreadTest {
    public static void main(String[] args) {
        ThreadContext context = new ThreadContext();
        context.start();
    }
}

class ThreadContext {
    private ThreadState state;

    ThreadContext() {
        this.state = new New();
    }

    public ThreadState getState() {
        return state;
    }

    public void setState(ThreadState state) {
        this.state = state;
    }

    public void start() {
        ((New) state).start(this);
    }

    public void getCPU() {
        ((Runnable) state).getCPU(this);
    }

    public void suspend() {
        ((Running) state).suspend(this);
    }

    public void stop() {
        ((Running) state).stop(this);
    }

    public void resume() {
        ((Blocked) state).resume(this);
    }

}

abstract class ThreadState {
    protected String stateName;
}

class New extends ThreadState {
    public New() {
        stateName = "新建状态";
        System.out.println("当前线程处于：新建状态.");
    }

    public void start(ThreadContext hj) {
        System.out.print("调用start()方法-->");
        if (stateName.equals("新建状态")) {
            hj.setState(new Runnable());
        } else {
            System.out.println("当前线程不是新建状态，不能调用start()方法.");
        }
    }
}

class Runnable extends ThreadState {
    public Runnable() {
        stateName = "就绪状态";
        System.out.println("当前线程处于：就绪状态.");
    }

    public void getCPU(ThreadContext hj) {
        System.out.print("获得CPU时间-->");
        if (stateName.equals("就绪状态")) {
            hj.setState(new Running());
        } else {
            System.out.println("当前线程不是就绪状态，不能获取CPU.");
        }
    }
}

class Running extends ThreadState {
    public Running() {
        stateName = "运行状态";
        System.out.println("当前线程处于：运行状态.");
    }

    public void suspend(ThreadContext hj) {
        System.out.print("调用suspend()方法-->");
        if (stateName.equals("运行状态")) {
            hj.setState(new Blocked());
        } else {
            System.out.println("当前线程不是运行状态，不能调用suspend()方法.");
        }
    }

    public void stop(ThreadContext hj) {
        System.out.print("调用stop()方法-->");
        if (stateName.equals("运行状态")) {
            hj.setState(new Dead());
        } else {
            System.out.println("当前线程不是运行状态，不能调用stop()方法.");
        }
    }
}

class Blocked extends ThreadState {
    public Blocked() {
        stateName = "阻塞状态";
        System.out.println("当前线程处于：阻塞状态.");
    }

    public void resume(ThreadContext hj) {
        System.out.print("调用resume()方法-->");
        if (stateName.equals("阻塞状态")) {
            hj.setState(new Runnable());
        } else {
            System.out.println("当前线程不是阻塞状态，不能调用resume()方法.");
        }
    }
}

class Dead extends ThreadState {
    public Dead() {
        stateName = "死亡状态";
        System.out.println("当前线程处于：死亡状态.");
    }
}