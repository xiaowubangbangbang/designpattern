package bridgepattern;

public class BankTest {
    public static void main(String[] args) {
        new LocalLog(new OperateClass()).saveLog();
        new LocalLog(new TransactionClass()).saveLog();
        new LocalLog(new ExceptionClass()).saveLog();
        new RemoteLog(new OperateClass()).saveLog();
        new RemoteLog(new TransactionClass()).saveLog();
        new RemoteLog(new ExceptionClass()).saveLog();
    }
}

interface FormatInterface {
    void saveLog();
}

/**
 * 操作
 */
class OperateClass implements FormatInterface {

    @Override
    public void saveLog() {
        System.out.println("操作日志");
    }
}

/**
 * 交易日志
 */
class TransactionClass implements FormatInterface {

    @Override
    public void saveLog() {
        System.out.println("交易日志");
    }
}

/**
 * 异常日志
 */
class ExceptionClass implements FormatInterface {

    @Override
    public void saveLog() {
        System.out.println("异常日志");
    }
}

abstract class Log {
    protected FormatInterface formatInterface;

    public Log(FormatInterface formatInterface) {
        this.formatInterface = formatInterface;
    }

    abstract void saveLog();
}

class LocalLog extends Log {

    public LocalLog(FormatInterface formatInterface) {
        super(formatInterface);
    }

    @Override
    void saveLog() {
        System.out.print("保存本地");
        formatInterface.saveLog();
    }
}

class RemoteLog extends Log {

    public RemoteLog(FormatInterface formatInterface) {
        super(formatInterface);
    }

    @Override
    void saveLog() {
        System.out.print("保存远程");
        formatInterface.saveLog();
    }
}
