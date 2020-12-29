package observerpattern;

import java.util.Observable;
import java.util.Observer;

public class CrudeOilFutures {
    public static void main(String[] args) {
        OilFutures oilFutures = new OilFutures();
        oilFutures.addObserver(new Bull());
        oilFutures.addObserver(new Bear());
        oilFutures.setPrice(10);
        oilFutures.setPrice(8);
    }
}

class OilFutures extends Observable {
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        super.setChanged();
        super.notifyObservers(price);
        this.price = price;
    }
}

class Bull implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Float price = (Float) arg;
        if (price > 0) {
            System.out.println("油价上涨" + price + "元，多方高兴了！");
        } else {
            System.out.println("油价下跌" + (-price) + "元，多方伤心了！");
        }
    }
}

class Bear implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Float price = (Float) arg;
        if (price > 0) {
            System.out.println("油价上涨" + price + "元，空方伤心了！");
        } else {
            System.out.println("油价下跌" + (-price) + "元，空方高兴了！");
        }
    }
}