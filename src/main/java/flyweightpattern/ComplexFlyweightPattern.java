package flyweightpattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComplexFlyweightPattern {
    public static void main(String[] args) {
        ComplexFlyweight flyweight = new ComplexFlyweightFactory().getFlyweight("新闻", "博客", "视频");
        flyweight.operation(new ComplexUnsharedConcreteFlyweight("小白"));
        flyweight.operation(new ComplexUnsharedConcreteFlyweight("小明"));
    }
}

class ComplexFlyweightFactory {
    private Map<String, ComplexFlyweight> flyweights = new HashMap<>();

    public ComplexFlyweight getFlyweight(String... key) {
        ComplexFlyweight flyweight = null;
        for (String s : key) {
            flyweight = flyweights.get(s);
            if (flyweight != null) {
                System.out.println("具体享元" + s + "已存在,被成功获取");
            } else {
                flyweight = new ComplexConcreteFlyweight(s);
                flyweights.put(s, flyweight);
            }
        }
        return flyweight;
    }
}

interface ComplexFlyweight {
    void operation(ComplexUnsharedConcreteFlyweight complexUnsharedConcreteFlyweight);
}

class ComplexConcreteFlyweight implements ComplexFlyweight {

    private String key;

    ComplexConcreteFlyweight(String key) {
        this.key = key;
    }

    @Override
    public void operation(ComplexUnsharedConcreteFlyweight complexUnsharedConcreteFlyweight) {
        System.out.println("共享享元" + key + "被调用");
        System.out.println("我是具体享元" + complexUnsharedConcreteFlyweight.getInfo());
    }
}

class CompositeConcreteFlyweight implements ComplexFlyweight {

    private List<ComplexFlyweight> complexFlyweights = new ArrayList<>();

    public void add(ComplexFlyweight complexFlyweight) {
        complexFlyweights.add(complexFlyweight);
    }

    public void remove(ComplexFlyweight complexFlyweight) {
        complexFlyweights.remove(complexFlyweight);
    }

    @Override
    public void operation(ComplexUnsharedConcreteFlyweight complexUnsharedConcreteFlyweight) {
        for (ComplexFlyweight complexFlyweight : complexFlyweights) {
            complexFlyweight.operation(complexUnsharedConcreteFlyweight);
        }
    }
}

class ComplexUnsharedConcreteFlyweight {
    private String info;

    ComplexUnsharedConcreteFlyweight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}