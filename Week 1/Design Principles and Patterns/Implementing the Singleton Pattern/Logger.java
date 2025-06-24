public class Logger {
    private static Logger instance;
    private Logger() {
        System.out.println("Logger instance created");
    }
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }return  instance;
    }
    public void log(String message) {
        System.out.println(message);
    }
}
class SingletonPatternTest{
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Logger1");
        Logger logger2 = Logger.getInstance();
        logger2.log("Logger2");
        System.out.println("Same instance? "+logger1.equals(logger2));
    }
}
