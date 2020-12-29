package prototypepattern;

import java.util.HashMap;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        ProtoTypeManager protoTypeManager = new ProtoTypeManager();
        Shape circle = protoTypeManager.getShape("Circle");
        circle.countArea();
    }
}

interface Shape extends Cloneable {
    Circle clone() throws CloneNotSupportedException;

    void countArea();
}

class Circle implements Shape {


    @Override
    public Circle clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }

    @Override
    public void countArea() {
        int r = 0;
        System.out.print("这是一个圆，请输入圆的半径：");
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        System.out.println("该圆的面积=" + 3.1415 * r * r + "\n");
    }
}

class Square implements Shape {

    @Override
    public Circle clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }

    @Override
    public void countArea() {
        int r = 0;
        System.out.print("这是一个正方形，请输入正方形的边长：");
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        System.out.println("该正方形的面积=" + r * r + "\n");
    }
}

class ProtoTypeManager {
    private HashMap<String, Shape> hashMap = new HashMap<>();
    ProtoTypeManager() {
        hashMap.put("Circle", new Circle());
        hashMap.put("Square", new Square());
    }
    public void addShape(String key, Shape shape) {
        hashMap.put(key, shape);
    }

    public Shape getShape(String key) throws CloneNotSupportedException {
        Shape temp = hashMap.get(key);
        return (Shape) temp.clone();
    }
}