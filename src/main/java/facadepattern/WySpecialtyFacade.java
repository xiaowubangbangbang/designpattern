package facadepattern;

public class WySpecialtyFacade {
    public static void main(String[] args) {
        WySpecialty wySpecialty = new WySpecialty(5);
        wySpecialty.getSpecialty();
    }
}

class WySpecialty {
    private Specialty1 s1 = new Specialty1();
    private Specialty2 s2 = new Specialty2();
    private Specialty3 s3 = new Specialty3();
    private Specialty4 s4 = new Specialty4();
    private Specialty5 s5 = new Specialty5();
    private Specialty6 s6 = new Specialty6();
    private Specialty7 s7 = new Specialty7();
    private Specialty8 s8 = new Specialty8();
    private int i;

    WySpecialty(int i) {
        this.i = i;
    }

    public void getSpecialty() {
        switch (i) {
            case 1:
                s1.get();
                break;
            case 2:
                s2.get();
                break;
            case 3:
                s3.get();
                break;
            case 4:
                s4.get();
                break;
            case 5:
                s5.get();
                break;
            case 6:
                s6.get();
                break;
            case 7:
                s7.get();
                break;
            case 8:
                s8.get();
                break;
            default:
        }
    }
}

class Specialty1 {
    public void get() {
        System.out.println("Specialty1");
    }
}

class Specialty2 {
    public void get() {
        System.out.println("Specialty2");
    }
}

class Specialty3 {
    public void get() {
        System.out.println("Specialty3");
    }
}

class Specialty4 {
    public void get() {
        System.out.println("Specialty4");
    }
}

class Specialty5 {
    public void get() {
        System.out.println("Specialty5");
    }
}

class Specialty6 {
    public void get() {
        System.out.println("Specialty6");
    }
}

class Specialty7 {
    public void get() {
        System.out.println("Specialty7");
    }
}

class Specialty8 {
    public void get() {
        System.out.println("Specialty8");
    }
}
