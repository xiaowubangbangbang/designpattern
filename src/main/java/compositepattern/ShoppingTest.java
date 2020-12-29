package compositepattern;

import java.util.ArrayList;

public class ShoppingTest {
    public static void main(String[] args) {
        Bags 红色小袋子 = new Bags("红色小袋子");
        Good 婺源特产 = new Good("婺源特产", 2, 7.9f);
        Good 婺源地图 = new Good("婺源地图", 1, 9.9f);
        红色小袋子.add(婺源特产);
        红色小袋子.add(婺源地图);
        Good 景德镇瓷器 = new Good("景德镇瓷器", 1, 380f);
        Bags 中袋子 = new Bags("中袋子");
        中袋子.add(红色小袋子);
        中袋子.add(景德镇瓷器);
        Bags 白色小袋子 = new Bags("白色小袋子");
        Good 韶关香藉 = new Good("韶关香藉", 2, 68f);
        Good 韶关红茶 = new Good("韶关红茶", 3, 180f);
        白色小袋子.add(韶关香藉);
        白色小袋子.add(韶关红茶);
        Good 李宁牌运动鞋 = new Good("李宁牌运动鞋", 1, 198f);
        Bags 大袋子 = new Bags("大袋子");
        大袋子.add(白色小袋子);
        大袋子.add(中袋子);
        大袋子.add(李宁牌运动鞋);
        float calculation = 大袋子.calculation();
        System.out.println("总价为:" + calculation);
        大袋子.show();
    }
}

interface Articles {
    float calculation();

    void show();
}

class Good implements Articles {
    private String name;     //名字
    private int quantity;    //数量
    private float unitPrice; //单价

    public Good(String name, int quantity, float unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    @Override
    public float calculation() {
        return quantity * unitPrice;
    }

    @Override
    public void show() {
        System.out.println(name + "(数量：" + quantity + "，单价：" + unitPrice + "元)");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }
}

class Bags implements Articles {
    private String name;     //名字
    private ArrayList<Articles> bags = new ArrayList<Articles>();

    public Bags(String name) {
        this.name = name;
    }

    public void add(Articles c) {
        bags.add(c);
    }

    public void remove(Articles c) {
        bags.remove(c);
    }

    public Articles getChild(int i) {
        return bags.get(i);
    }

    public float calculation() {
        float s = 0;
        for (Object obj : bags) {
            s += ((Articles) obj).calculation();
        }
        return s;
    }

    public void show() {
        for (Object obj : bags) {
            ((Articles) obj).show();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Articles> getBags() {
        return bags;
    }

    public void setBags(ArrayList<Articles> bags) {
        this.bags = bags;
    }
}