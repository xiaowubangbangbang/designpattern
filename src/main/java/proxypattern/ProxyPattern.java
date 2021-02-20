package proxypattern;

/**
 * 被代理的对象和代理类同时实现一个接口,代理类持有真实对象的引用
 */
public class ProxyPattern {
    public static void main(String[] args) {
        SchoolGirl schoolGirl = new SchoolGirl();
        schoolGirl.setName("娇娇");
        GiftProxy giftProxy = new GiftProxy(schoolGirl);
        giftProxy.giveChocolate();
        giftProxy.giveDolls();
        giftProxy.giveFlower();
    }
}

class SchoolGirl {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface GiveGift {
    void giveDolls();

    void giveFlower();

    void giveChocolate();
}

class Pursuit implements GiveGift {

    private SchoolGirl schoolGirl;
    private String name;

    public Pursuit(SchoolGirl schoolGirl) {
        System.out.println("first load");
        this.schoolGirl = schoolGirl;
    }

    @Override
    public void giveDolls() {
        System.out.println(schoolGirl.getName() + "送你洋娃娃");
    }

    @Override
    public void giveFlower() {
        System.out.println(schoolGirl.getName() + "送你花");

    }

    @Override
    public void giveChocolate() {
        System.out.println(schoolGirl.getName() + "送你巧克力");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class GiftProxy implements GiveGift {

    private Pursuit pursuit;

    public GiftProxy(SchoolGirl schoolGirl) {
        if (this.pursuit == null) {
            this.pursuit = new Pursuit(schoolGirl);
        }
        pursuit.setName("小五");
    }

    @Override
    public void giveDolls() {
        System.out.print("我是" + pursuit.getName() + ",");
        pursuit.giveDolls();
    }

    @Override
    public void giveFlower() {
        System.out.print("我是" + pursuit.getName() + ",");
        pursuit.giveFlower();
    }

    @Override
    public void giveChocolate() {
        System.out.print("我是" + pursuit.getName() + ",");
        pursuit.giveChocolate();
    }
}