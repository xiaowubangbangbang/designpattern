package observerpattern;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;

public class BellEventTest {
    public static void main(String[] args) {
        BellEventSource bell = new BellEventSource();    //铃（事件源）
        bell.addPersonListener(new TeachEventListener()); //注册监听器（老师）
        bell.addPersonListener(new StuEventListener());    //注册监听器（学生）
        bell.ring(true);   //打上课铃声
        System.out.println("------------");
        bell.ring(false);  //打下课铃声
    }
}

//铃声事件类：用于封装事件源及一些与事件相关的参数
class RingEvent extends EventObject {
    private static final long serialVersionUID = 1L;
    private boolean sound;    //true表示上课铃声,false表示下课铃声

    public RingEvent(Object source, boolean sound) {
        super(source);
        this.sound = sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    public boolean getSound() {
        return this.sound;
    }
}

class BellEventSource {
    private List<BellEventListener> listener; //监听器容器

    public BellEventSource() {
        listener = new ArrayList<BellEventListener>();
    }

    //给事件源绑定监听器
    public void addPersonListener(BellEventListener ren) {
        listener.add(ren);
    }

    //事件触发器：敲钟，当铃声sound的值发生变化时，触发事件。
    public void ring(boolean sound) {
        String type = sound ? "上课铃" : "下课铃";
        System.out.println(type + "响！");
        RingEvent event = new RingEvent(this, sound);
        notifies(event);    //通知注册在该事件源上的所有监听器
    }

    //当事件发生时,通知绑定在该事件源上的所有监听器做出反应（调用事件处理方法）
    protected void notifies(RingEvent e) {
        for (BellEventListener bellEventListener : listener) {
            bellEventListener.heardBell(e);
        }
    }
}

//抽象观察者类：铃声事件监听器
interface BellEventListener extends EventListener {
    //事件处理方法，听到铃声
    public void heardBell(RingEvent e);
}

class TeachEventListener implements BellEventListener {

    @Override
    public void heardBell(RingEvent e) {
        if (e.getSound()) {
            System.out.println("老师上课了...");
        } else {
            System.out.println("老师下课了...");
        }
    }
}

class StuEventListener implements BellEventListener {

    @Override
    public void heardBell(RingEvent e) {
        if (e.getSound()) {
            System.out.println("同学们，上课了...");
        } else {
            System.out.println("同学们，下课了...");
        }
    }
}