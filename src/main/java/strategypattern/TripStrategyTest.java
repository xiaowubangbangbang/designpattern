package strategypattern;

public class TripStrategyTest {
    public static void main(String[] args) {
        WyTour wyTour = new WyTour();
        wyTour.setTripMode(new ByCar());
        wyTour.goOut();
        wyTour.setTripMode(new ByTrain());
        wyTour.goOut();
        wyTour.setTripMode(new SelfDrive());
        wyTour.goOut();
    }
}

class WyTour {
    private TripMode tripMode;

    void goOut() {
        tripMode.goOut();
    }

    public TripMode getTripMode() {
        return tripMode;
    }

    public void setTripMode(TripMode tripMode) {
        this.tripMode = tripMode;
    }


}

interface TripMode {
    void goOut();
}

class ByTrain implements TripMode {

    @Override
    public void goOut() {
        System.out.println("做火车出门");
    }
}

class ByCar implements TripMode {

    @Override
    public void goOut() {
        System.out.println("开车出门");
    }
}

class SelfDrive implements TripMode {

    @Override
    public void goOut() {
        System.out.println("自驾出门");
    }
}