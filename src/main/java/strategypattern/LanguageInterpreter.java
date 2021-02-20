package strategypattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LanguageInterpreter {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> interpret = new LanguageContext().interpret(scanner);
        System.out.println(interpret);
    }
}

//抽象类表达式
abstract class LanguageExpression {

    protected HashMap<String, String> map;

    public LanguageExpression(HashMap<String, String> map) {
        this.map = map;
    }

    abstract boolean interpret(String info);

    abstract int parsing(String info) throws Exception;
}

//mov a v 把数v赋值给a，其中a是变量名称，由不超过10个小写字母组成，v是变量名或者常数（常数为00000~10000的整数）
class Mov extends LanguageExpression {

    public Mov(HashMap<String, String> map) {
        super(map);
    }

    @Override
    public boolean interpret(String info) {
        return "mov".equals(info.split(" ")[0]);
    }

    @Override
    public int parsing(String info) {
        String[] s = info.split(" ");
        if (map.containsKey(s[2])) map.put(s[1], map.get(s[2]));
        else {
            try {
                Integer.parseInt(s[2]);
            } catch (NumberFormatException e) {
                throw new NumberFormatException(s[2] + "必须初始化");
            }
            map.put(s[1], s[2]);
        }
        return 0;
    }
}

//inc a 变量a加1
class Inc extends LanguageExpression {
    public Inc(HashMap<String, String> map) {
        super(map);
    }

    @Override
    public boolean interpret(String info) {
        return "inc".equals(info.split(" ")[0]);
    }

    @Override
    public int parsing(String info) {
        String[] s = info.split(" ");
        String s1 = map.get(s[1]);
        if (map.containsKey(s[1])) {
            map.put(s[1], Integer.parseInt(s1) + 1 + "");
        }
        return 0;
    }
}

//dec a 变量a减1
class Dec extends LanguageExpression {
    public Dec(HashMap<String, String> map) {
        super(map);
    }

    @Override
    public boolean interpret(String info) {
        return "dec".equals(info.split(" ")[0]);
    }

    @Override
    public int parsing(String info) {
        String[] s = info.split(" ");
        String s1 = map.get(s[1]);
        if (map.containsKey(s[1])) {
            map.put(s[1], Integer.parseInt(s1) - 1 + "");
        }
        return 0;
    }
}

//jnz a v 如果变量a的值不是0，则相对跳转v条指令。比如-2
class Jnz extends LanguageExpression {
    public Jnz(HashMap<String, String> map) {
        super(map);
    }

    @Override
    public boolean interpret(String info) {
        return "jnz".equals(info.split(" ")[0]);
    }

    @Override
    public int parsing(String info) throws Exception {
        String[] s = info.split(" ");
        if (!map.containsKey(s[1])) throw new Exception(s[1] + "必须赋值");
        String s1 = map.get(s[1]);
        if (Integer.parseInt(s1) != 0) {
            try {
                return Integer.parseInt(s[2]);
            } catch (NumberFormatException e) {
                throw new NumberFormatException(info + "输入不正确");
            }
        }
        return 0;
    }
}


class LanguageContext {
    private String[] languages = {"mov", "inc", "dec", "jnz"};
    // private String[] statements = {"mov bx 2", "mov ax 5", "inc bx", "dec ax", "jnz ax -2", "dec ax"};
    private String[] statements = {"mov ax 10000", "mov bx ax", "dec bx", "jnz bx a", "dec ax", "jnz ax -4"};
    private List<LanguageExpression> expressions = new ArrayList<>(100);
    private LanguageExpression languageExpression;
    private HashMap<String, String> map = new HashMap<>();

    public LanguageContext() {
        expressions.add(new Mov(map));
        expressions.add(new Inc(map));
        expressions.add(new Dec(map));
        expressions.add(new Jnz(map));
    }

    public HashMap<String, String> interpret(Scanner scanner) throws Exception {

        while (scanner.hasNextLine()) {
            String next = scanner.nextLine();
           // System.out.println(next);
        }

        for (int i = 0; i < statements.length; i++) {
            String statement = statements[i];
            for (LanguageExpression expression : expressions) {
                if (expression.interpret(statement)) {
                    int parsing = expression.parsing(statement);
                    if (parsing != 0) {
                        i += parsing - 1;
                    }
                }
            }
        }
        return map;
    }
}