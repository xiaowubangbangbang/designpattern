package flyweightpattern;

import java.util.HashMap;

public class SimpleFlyweightPattern {
    public static void main(String[] args) {
        SimpleFlyweightFactory simpleFlyweightFactory = new SimpleFlyweightFactory();
        SimpleFlyweight aaa = simpleFlyweightFactory.getFlyweight("aaa");
        SimpleFlyweight bb = simpleFlyweightFactory.getFlyweight("bb");
        aaa.operation();
        bb.operation();
    }
}

interface SimpleFlyweight {
    void operation();
}


class SimpleFlyweightFactory {
    private HashMap<String, SimpleFlyweight> simpleFlyweightHashMap = new HashMap<>();

    public SimpleFlyweight getFlyweight(String key) {
        SimpleFlyweight flyweight = (SimpleFlyweight) simpleFlyweightHashMap.get(key);
        if (flyweight != null) {
            System.out.println("具体享元" + key + "已经存在，被成功获取！");
        } else {
            flyweight = key.length() > 2 ? new SimpleConcreteFlyweightA(key) : new SimpleConcreteFlyweightB(key);
            simpleFlyweightHashMap.put(key, flyweight);
        }
        return flyweight;
    }
}

class SimpleConcreteFlyweightA implements SimpleFlyweight {
    private String key;

    SimpleConcreteFlyweightA(String key) {
        this.key = key;
    }

    @Override
    public void operation() {
        System.out.println("单纯享元模式A,无需传入");
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

class SimpleConcreteFlyweightB implements SimpleFlyweight {
    private String key;

    SimpleConcreteFlyweightB(String key) {
        this.key = key;
    }

    @Override
    public void operation() {
        System.out.println("单纯享元模式B,无需传入");
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}