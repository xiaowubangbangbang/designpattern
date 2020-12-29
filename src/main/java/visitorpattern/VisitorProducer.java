package visitorpattern;

import java.util.ArrayList;
import java.util.List;

public class VisitorProducer {
    public static void main(String[] args) {
        SetMaterial setMaterial = new SetMaterial();
        setMaterial.add(new Paper());
        setMaterial.add(new Cuprum());
        System.out.println(setMaterial.accept(new ArtCompany()));
        System.out.println("--------------");
        System.out.println(setMaterial.accept(new Mint()));
    }

}

interface Company {
    String create(Paper element);

    String create(Cuprum element);
}

class ArtCompany implements Company {

    @Override
    public String create(Paper element) {
        return "艺术公司讲学图";
    }

    @Override
    public String create(Cuprum element) {
        return "艺术公司朱熹铜像";
    }
}

class Mint implements Company {

    @Override
    public String create(Paper element) {
        return "造币公司纸币";
    }

    @Override
    public String create(Cuprum element) {
        return "造币公司铜币";
    }
}

interface Material {
    String accept(Company company);
}

class Paper implements Material {

    @Override
    public String accept(Company company) {
        return company.create(this);
    }
}

class Cuprum implements Material {
    @Override
    public String accept(Company company) {
        return company.create(this);
    }
}

class SetMaterial {
    private List<Material> materialList = new ArrayList<>();

    public String accept(Company company) {
        StringBuilder str = new StringBuilder();
        for (Material material : materialList) str.append(material.accept(company)).append("\n");
        return str.toString();
    }

    public void add(Material material) {
        materialList.add(material);
    }

    public void remove(Material material) {
        materialList.remove(material);
    }
}