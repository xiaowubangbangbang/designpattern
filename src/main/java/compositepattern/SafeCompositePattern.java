package compositepattern;

import java.util.ArrayList;
import java.util.List;

public class SafeCompositePattern {
    public static void main(String[] args) {
        SafeComposite safeComposite = new SafeComposite();
        SafeComponent safeLeaf = new SafeLeaf("1");
        SafeComponent safeLeaf1 = new SafeLeaf("2");
        safeComposite.add(safeLeaf);
        safeComposite.add(safeLeaf1);
        safeComposite.operation();
    }
}

interface SafeComponent {
    public void operation();
}

/**
 * 树叶
 */
class SafeLeaf implements SafeComponent {
    private String name;

    public SafeLeaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("树叶" + name + "被访问");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * 树枝
 */
class SafeComposite implements SafeComponent {
    private List<SafeComponent> components = new ArrayList<>();


    public void add(SafeComponent c) {
        components.add(c);
    }


    public void remove(SafeComponent c) {
        components.remove(c);
    }


    public SafeComponent getChild(int i) {
        return components.get(i);
    }

    @Override
    public void operation() {
        for (SafeComponent component : components) {
            component.operation();
        }
    }
}