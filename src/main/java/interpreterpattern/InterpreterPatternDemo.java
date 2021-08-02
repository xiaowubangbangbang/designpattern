package interpreterpattern;

import java.util.Collections;
import java.util.HashSet;

/**
 * 解释器模式
 */
public class InterpreterPatternDemo {
    public static void main(String[] args) {
        Context bus = new Context();
        bus.freeRide("韶关的老人");
        bus.freeRide("韶关的年轻人");
        bus.freeRide("广州的妇女");
        bus.freeRide("广州的儿童");
        bus.freeRide("山东的儿童");
    }
}

//抽象类表达式
interface Expression {
    boolean interpret(String info);
}

////终结符表达式类
class TerminalExpression implements Expression {
    private HashSet<String> set = new HashSet<>();

    public TerminalExpression(String[] data) {
        Collections.addAll(set, data);
    }

    @Override
    public boolean interpret(String info) {
        return set.contains(info);
    }
}

//非终结符表达式类
class AndExpression implements Expression {
    private Expression city;
    private Expression person;

    public AndExpression(Expression city, Expression person) {
        this.city = city;
        this.person = person;
    }

    @Override
    public boolean interpret(String info) {
        return city.interpret(info.split("的")[0]) && person.interpret(info.split("的")[1]);
    }
}

class Context {
    private String[] citys = {"韶关", "广州"};
    private String[] persons = {"老人", "妇女", "儿童"};
    private Expression cityPerson;

    public Context() {
        TerminalExpression citys = new TerminalExpression(this.citys);
        TerminalExpression persons = new TerminalExpression(this.persons);
        cityPerson = new AndExpression(citys, persons);
    }

    public void freeRide(String info) {
        if (cityPerson.interpret(info)) {
            System.out.println("您是" + info + "，您本次乘车免费！");
        } else {
            System.out.println(info + "，您不是免费人员，本次乘车扣费2元！");
        }
    }
}