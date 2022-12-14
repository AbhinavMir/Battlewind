public class PrettyPrint {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // background colors
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";

    public void clearScreen() {
        System.out.print("\033\143");
    }

    public static void healthBarPrinter(int currentHp, int maxHp) {
        int healthBarLength = 20;
        int healthBarCurrent = (int) Math.round((double) currentHp / maxHp * healthBarLength);
        String healthBar = "";
        for (int i = 0; i < healthBarLength; i++) {
            if (i < healthBarCurrent) {
                healthBar += GREEN + "█" + RESET;
            } else {
                healthBar += RED + "█" + RESET;
            }
        }
        System.out.println(healthBar);
    }
}
