package nullobjectpattern;

public class Client {
    public static void main(String[] args) {
        AbstractCustomer a = CustomerFactory.getCustomer("a");
        if (a.isNil()) {
            System.out.println( a.getName());
        }
        System.out.println(CustomerFactory.getCustomer("Joe").getName());
        System.out.println(CustomerFactory.getCustomer("aaa").getName());
    }
}

abstract class AbstractCustomer {
    protected String name;

    abstract String getName();

    abstract boolean isNil();
}

class CustomerFactory {

    public static final String[] names = {"Rob", "Joe", "Julie"};

    public static AbstractCustomer getCustomer(String name) {
        for (String s : names) {
            if (s.equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }
        return new NilCustomer();
    }
}

class RealCustomer extends AbstractCustomer {

    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    boolean isNil() {
        return false;
    }
}

class NilCustomer extends AbstractCustomer {

    @Override
    String getName() {
        return "Not Available in Customer Database";
    }

    @Override
    boolean isNil() {
        return true;
    }
}