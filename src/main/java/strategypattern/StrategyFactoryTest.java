package strategypattern;

import java.util.HashMap;

public class StrategyFactoryTest {
    public static void main(String[] args) {
        WyTourFactory wyTourFactory = new WyTourFactory();
        wyTourFactory.goOut("byTrainFactory");
        wyTourFactory.goOut("byCarFactory");
        wyTourFactory.goOut("bySelfDriveFactory");
    }
}

class WyTourFactory {
    private HashMap<String, TripModeFactory> factoryHashMap = new HashMap<>();

    void goOut(String key) {
        get(key).goOut();
    }

    WyTourFactory() {
        factoryHashMap.put("byTrainFactory", new ByTrainFactory());
        factoryHashMap.put("byCarFactory", new ByCarFactory());
        factoryHashMap.put("bySelfDriveFactory", new SelfDriveFactory());
    }

    public void put(String key, TripModeFactory tripModeFactory) {
        factoryHashMap.put(key, tripModeFactory);
    }

    public TripModeFactory get(String key) {
        return factoryHashMap.get(key);
    }
}

interface TripModeFactory {
    void goOut();
}

class ByTrainFactory implements TripModeFactory {

    @Override
    public void goOut() {
        System.out.println("做火车出门");
    }
}

class ByCarFactory implements TripModeFactory {

    @Override
    public void goOut() {
        System.out.println("开车出门");
    }
}

class SelfDriveFactory implements TripModeFactory {

    @Override
    public void goOut() {
        System.out.println("自驾出门");
    }
}
