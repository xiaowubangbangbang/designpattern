package observerpattern;

import java.util.ArrayList;
import java.util.List;

public class RMBrateTest {
    public static void main(String[] args) {
        RMBrate rmBrate = new RMBrate();
        rmBrate.add(new ExportCompany());
        rmBrate.add(new ImportCompany());
        rmBrate.change(10);
    }
}

abstract class Rate {
    protected List<Company> companyArrayList = new ArrayList<>();

    void add(Company company) {
        companyArrayList.add(company);
    }

    void remove(Company company) {
        companyArrayList.remove(company);
    }

    public abstract void change(int number);

}

class RMBrate extends Rate {

    @Override
    public void change(int number) {
        for (Company company : companyArrayList) {
            company.response(number);
        }
    }
}

interface Company {
    void response(int number);
}

class ImportCompany implements Company {

    @Override
    public void response(int number) {
        System.out.println("进口公司收到通知,汇率变成了" + number);
    }
}

class ExportCompany implements Company {

    @Override
    public void response(int number) {
        System.out.println("出口公司收到通知,汇率变成了" + number);
    }
}