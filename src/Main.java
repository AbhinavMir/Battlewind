import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        // get all loggers
        Logger logger = Logger.getLogger("");
        // set the log level to ALL
        logger.setLevel(Level.OFF);
        Launcher.main(args);
    }
}
