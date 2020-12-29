package adapterpattern;

public class MotorAdapterTest {
    public static void main(String[] args) {
        Motor motor = new OpticalAdapter(new OpticalMotor());
        motor.drive();
        ElectricAdapter adapter = new ElectricAdapter(new ElectricMotor());
        adapter.drive();
    }
}

interface Motor {
    void drive();
}

class ElectricMotor {
    public void electricDrive() {
        System.out.println("电能发动机驱动汽车！");
    }
}

class OpticalMotor {
    public void opticalDrive() {
        System.out.println("光能发动机驱动汽车！");
    }
}

class ElectricAdapter implements Motor {

    private ElectricMotor electricMotor;

    ElectricAdapter(ElectricMotor electricMotor) {
        this.electricMotor = electricMotor;
    }

    public void drive() {
        electricMotor.electricDrive();
    }

}

class OpticalAdapter implements Motor {
    private OpticalMotor opticalMotor;

    OpticalAdapter(OpticalMotor opticalMotor) {
        this.opticalMotor = opticalMotor;
    }

    public void drive() {
        opticalMotor.opticalDrive();
    }
}

