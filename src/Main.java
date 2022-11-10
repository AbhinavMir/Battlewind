import java.util.logging.Level;
import java.util.logging.Logger;

/*
Main class to launch the program and overarching handle errors
 */
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.OFF);
        while (true) {
            try {
                Launcher.main(args);
            } catch (Exception e) {
            }
        }

    }
}
