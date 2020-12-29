package compositepattern;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public static void main(String[] args) {
        Component composite = new Composite();
        composite.add(new Leaf("1"));
        composite.add(new Leaf("2"));
        composite.operation();
    }
}

interface Component {
    public void add(Component c);

    public void remove(Component c);

    public Component getChild(int i);

    public void operation();
}

/**
 * 树叶
 */
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void add(Component c) {

    }

    @Override
    public void remove(Component c) {

    }

    @Override
    public Component getChild(int i) {
        return null;
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
class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    @Override
    public void add(Component c) {
        components.add(c);
    }

    @Override
    public void remove(Component c) {
        components.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return components.get(i);
    }

    @Override
    public void operation() {
        for (Component component : components) {
            component.operation();
        }
    }
}