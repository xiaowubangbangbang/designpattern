package abstractFactorypattern;

public class Client {
    public static void main(String[] args) {
        SGfarm sGfarm = new SGfarm();
        Animal animal = sGfarm.newAnimal();
        animal.show();
        SRfarm sRfarm = new SRfarm();
        Plant plant = sGfarm.newPlant();
        plant.show();
    }
}


interface Animal {
    void show();
}

class Horse implements Animal {

    @Override
    public void show() {
        System.out.println("我是马");
    }
}

class Cattle implements Animal {

    @Override
    public void show() {
        System.out.println("我是牛");
    }
}

interface Plant {
    void show();
}

class Fruitage implements Plant {

    @Override
    public void show() {
        System.out.println("我是水果");
    }
}

class Vegetables implements Plant {

    @Override
    public void show() {
        System.out.println("我是蔬菜");
    }
}

/**
 * 抽象工厂,对应两个产品族(韶关农场类,SRfarm)
 */
interface Farm {
    Animal newAnimal();

    Plant newPlant();
}

//具体工厂：韶关农场类
class SGfarm implements Farm {
    public Animal newAnimal() {
        System.out.println("新牛出生！");
        return new Cattle();
    }

    public Plant newPlant() {
        System.out.println("蔬菜长成！");
        return new Vegetables();
    }
}

//具体工厂：上饶农场类
class SRfarm implements Farm {
    public Animal newAnimal() {
        System.out.println("新马出生！");
        return new Horse();
    }

    public Plant newPlant() {
        System.out.println("水果长成！");
        return new Fruitage();
    }
}