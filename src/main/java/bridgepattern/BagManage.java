package bridgepattern;

public class BagManage {
    public static void main(String[] args) {
        Color color = new Yellow();
        Bag handBag = new HandBag();
        handBag.setColor(color);
        System.out.println(handBag.getName());
    }
}

interface Color {
    String getColor();
}

class Yellow implements Color {

    @Override
    public String getColor() {
        return "yellow";
    }
}

class Red implements Color {

    @Override
    public String getColor() {
        return "red";
    }
}

abstract class Bag {
    protected Color color;

    void setColor(Color color) {
        this.color = color;
    }

    abstract String getName();
}

class HandBag extends Bag {

    @Override
    String getName() {
        return color.getColor() + "HandBag";
    }
}

class Wallet extends Bag {

    @Override
    String getName() {
        return color.getColor() + "Wallet";
    }
}