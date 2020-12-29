package proxypattern;

public class WySpecialtyProxy {
    public static void main(String[] args) {

    }
}

interface Specialty {
    void display();
}

class WySpecialty implements Specialty {

    @Override
    public void display() {
        System.out.println("特殊特产");
    }
}

class SgProxy implements Specialty {
    private WySpecialty wySpecialty = new WySpecialty();

    private void preRequest() {
        System.out.println("韶关代理婺源特产开始。");
    }

    private void postRequest() {
        System.out.println("韶关代理婺源特产结束。");
    }

    @Override
    public void display() {
        preRequest();
        wySpecialty.display();
        postRequest();
    }
}