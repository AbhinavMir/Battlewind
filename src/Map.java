import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;

public class Map {
    String helpString = "";
    Scanner scanner = new Scanner(System.in);
    PrettyPrint pp = new PrettyPrint();
    Logger logger = Logger.getLogger(Map.class.getName());
    Tile[][] map;

    public Map(int seed, int x, int y) {
        map = new Tile[x][y];
        populateMap(seed, x, y);
    }

    public static void run(Map map) {
        PrettyPrint pp = new PrettyPrint();
        readHandler.init();
        map.initializeMap();
        System.out.println(map.printMap());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("W - Move Up \t S - Move Down \t A - Move Left \t D - Move Right \t H - Help \t I - Inventory \t Q - Quit");
            // System.out.println("Hero is at " + map.getPlayerPosition()[0] + " " + map.getPlayerPosition()[1]);
            String move = scanner.nextLine();
            if (move != null) {
                map.movePlayerOnMap(move);
                System.out.println(map.printMap());
            } else {
                move = scanner.nextLine();
            }
            // pp.clearScreen();
        }
    }


    public void initializeMap() {
        this.map[0][0].isPlayer = true;
    }

    public void populateMap(int seed, int x, int y) {
        tileType[] tileTypes = {tileType.COMMON, tileType.INACCESSIBLE, tileType.MARKET};
        Random rand = new Random(seed);
        // randomly make a new map with 20% inaccessible spaces, 30% market spaces, and 50% common spaces
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int randNum = rand.nextInt(100);
                if (randNum < 20) {
                    map[i][j] = new Tile(tileTypes[1], i, j);
                } else if (randNum > 90) {
                    map[i][j] = new Tile(tileTypes[2], i, j);
                } else {
                    map[i][j] = new Tile(tileTypes[0], i, j);
                }
            }
        }
    }

    public String tileImage(Tile tile) {
        tileType type = tile.type;
        String toReturn = "";

        if (tile.isPlayer) {
            toReturn = "" + PrettyPrint.YELLOW_BACKGROUND + "YOU" + PrettyPrint.RESET + "";
        } else {
            if (tile.isPlayer) {
            }
            if (type == tileType.COMMON) {
                toReturn = "" + PrettyPrint.GREEN_BACKGROUND + "   " + PrettyPrint.RESET + "";
            } else if (type == tileType.INACCESSIBLE) {
                toReturn = "" + PrettyPrint.RED_BACKGROUND + "   " + PrettyPrint.RESET + "";
            } else if (type == tileType.MARKET) {
                toReturn = "" + PrettyPrint.BLUE_BACKGROUND + "(M)" + PrettyPrint.RESET + "";
            }
        }
        return toReturn;
    }

    public Boolean promptBattle(Tile tile) {
        Random rand = new Random();
        int randNum = rand.nextInt(100);
        if (tile.type == tileType.COMMON) {
            return randNum % 2 == 0 && randNum > 50;
        } else {
            return false;
        }
    }

    public void movePlayerOnMap(String move) {
        int x_current = getPlayerPosition()[0];
        int y_current = getPlayerPosition()[1];

        if (move.equals("w")) {
            if (x_current == 0 || map[x_current - 1][y_current].type == tileType.INACCESSIBLE) {
                System.out.println("You can't move there!");
            } else if (map[x_current - 1][y_current].type == tileType.COMMON) {
                if (promptBattle(map[x_current - 1][y_current])) {
                    System.out.println("You encountered a monster!");
                    Battle battle = new Battle(3);
                    battle.startBattle();
                } else {
                    map[x_current][y_current].isPlayer = false;
                    map[x_current - 1][y_current].isPlayer = true;
                }
            } else if (map[x_current - 1][y_current].type == tileType.MARKET) {
                map[x_current][y_current].isPlayer = false;
                map[x_current - 1][y_current].isPlayer = true;
                Market.prePrompt(scanner);
            }
        } else if (move.equals("a")) {
            if (y_current == 0 || map[x_current][y_current - 1].type == tileType.INACCESSIBLE) {
                System.out.println("You can't move there!");
            } else if (map[x_current][y_current - 1].type == tileType.COMMON) {
                if (promptBattle(map[x_current][y_current - 1])) {
                    System.out.println("You encountered a monster!");
                    Battle battle = new Battle(3);
                    battle.startBattle();
                } else {
                    map[x_current][y_current].isPlayer = false;
                    map[x_current][y_current - 1].isPlayer = true;
                }
            } else if (map[x_current][y_current - 1].type == tileType.MARKET) {
                map[x_current][y_current].isPlayer = false;
                map[x_current][y_current - 1].isPlayer = true;
                Market.prePrompt(scanner);

            }
        } else if (move.equals("s")) {
            if (x_current == map.length - 1 || map[x_current + 1][y_current].type == tileType.INACCESSIBLE) {
                System.out.println("You can't move there!");
            } else if (map[x_current + 1][y_current].type == tileType.COMMON) {
                if (promptBattle(map[x_current + 1][y_current])) {
                    System.out.println("You encountered a monster!");
                    Battle battle = new Battle(3);
                    battle.startBattle();
                } else {
                    map[x_current][y_current].isPlayer = false;
                    map[x_current + 1][y_current].isPlayer = true;
                }
            } else if (map[x_current + 1][y_current].type == tileType.MARKET) {
                map[x_current][y_current].isPlayer = false;
                map[x_current + 1][y_current].isPlayer = true;
                Market.prePrompt(scanner);
            }
        } else if (move.equals("d")) {
            if (y_current == map[0].length - 1 || map[x_current][y_current + 1].type == tileType.INACCESSIBLE) {
                System.out.println("You can't move there!");
            } else {
                if (promptBattle(map[x_current][y_current + 1])) {
                    System.out.println("You encountered a monster!");
                    Battle battle = new Battle(3);
                    battle.startBattle();
                } else if (map[x_current][y_current + 1].type == tileType.COMMON) {
                    map[x_current][y_current].isPlayer = false;
                    map[x_current][y_current + 1].isPlayer = true;
                } else if (map[x_current][y_current + 1].type == tileType.MARKET) {
                    map[x_current][y_current].isPlayer = false;
                    map[x_current][y_current + 1].isPlayer = true;
                    Market.prePrompt(scanner);
                }
            }
        } else if (move.equals("i")) {
            int whichHero = scanner.nextInt();
            gameData.printAllHeroes();
            System.out.println("0: Print entire inventory of party");
            if (whichHero != 0) {
                Characters.Player.viewInventory(gameData.heroes.get(whichHero));
            } else if (whichHero == 0) {
                for (int i = 0; i < gameData.heroes.size(); i++) {
                    Characters.Player.viewInventory(gameData.heroes.get(i));
                }
            } else {
                System.out.println("Invalid input");
            }
        } else if (move.equals("p")) {
            gameData.printAllHeroes();
        } else if (move.equals("q")) {
            System.out.println("Are you sure? You'll lose all progress!");
            String sure = scanner.next();
            if (sure.equals("y")) {
                System.exit(0);
            }
        } else if (move.equals("m")) {
            printMap();
        } else if (move.equals("h")) {
            System.out.println(helpString);
        } else {
            System.out.println("Invalid input");
        }
    }


    public int[] getPlayerPosition() {
        int[] position = new int[2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j].isPlayer) {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }
        return position;
    }

    public String printMap() {
        String mapString = "";
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[i].length; j++) {
                mapString += tileImage(this.map[i][j]);
            }
            mapString += "\n";
        }

        return mapString;
    }

    enum tileType {
        INACCESSIBLE, MARKET, COMMON
    }

    class Tile {
        tileType type;
        int x;
        int y;
        boolean isPlayer;

        public Tile(tileType type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }

        public void setType(tileType type) {
            this.type = type;
        }
    }
}
