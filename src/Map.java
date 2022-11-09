import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;

public class Map {
    PrettyPrint pp = new PrettyPrint();
    Logger logger = Logger.getLogger(Map.class.getName());
    Tile[][] map;

    public Map(int seed, int x, int y) {
        map = new Tile[x][y];
        populateMap(seed, x, y);
    }

    public static void main(String[] args) {
        PrettyPrint pp = new PrettyPrint();
        Map map = new Map(1, 10, 10);
        map.initializeMap();
        System.out.println(map.printMap());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            for (int i = 0 ; i<map.mapBackup.length;i++)
            {
                for (int j = 0 ; j<map.mapBackup[i].length;j++)
                {
                    if(map.mapBackup[i][j].type == tileType.PLAYER)
                    {
                        System.out.println("Characters.Hero at " + i + " " + j);
                    }
                }
            }
            pp.clearScreen();
            String move = scanner.nextLine();
            map.movePlayerOnMap(move);
            System.out.println(map.printMap());
        }
    }

    public void initializeMap() {
        this.map[0][0].setType(tileType.PLAYER);
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

    public String tileImage(tileType tile) {
        if (tile == tileType.COMMON) {
            return "" + PrettyPrint.GREEN_BACKGROUND + "   " + PrettyPrint.RESET + "";
        } else if (tile == tileType.INACCESSIBLE) {
            return "" + PrettyPrint.RED_BACKGROUND + "   " + PrettyPrint.RESET + "";
        } else if (tile == tileType.MARKET) {
            return "" + PrettyPrint.BLUE_BACKGROUND + "(M)" + PrettyPrint.RESET + "";
        } else if (tile == tileType.PLAYER) {
            return "" + PrettyPrint.YELLOW_BACKGROUND + "YOU" + PrettyPrint.RESET + "";
        }

        return "ERR";
    }

    public void movePlayerOnMap(String move) {
        int x_current = getPlayerPosition()[0];
        int y_current = getPlayerPosition()[1];

        if (move.equals("w")) {
            if (x_current == 0 || map[x_current - 1][y_current].type == tileType.INACCESSIBLE) {
                System.out.println("You can't move there!");
            } else {
                map[x_current][y_current].setType(mapBackup[x_current][y_current].type);
                map[x_current - 1][y_current].setType(tileType.PLAYER);
            }
        } else if (move.equals("a")) {
            if (y_current == 0 || map[x_current][y_current - 1].type == tileType.INACCESSIBLE) {
                System.out.println("You can't move there!");
            } else {
                map[x_current][y_current].setType(mapBackup[x_current][y_current].type);
                map[x_current][y_current].setType(mapBackup[x_current][y_current].type);
                map[x_current][y_current].setType(mapBackup[x_current][y_current].type);
                map[x_current][y_current - 1].setType(tileType.PLAYER);
            }
        } else if (move.equals("s")) {
            if (x_current == map.length - 1 || map[x_current + 1][y_current].type == tileType.INACCESSIBLE) {
                System.out.println("You can't move there!");
            } else {
                map[x_current][y_current].setType(mapBackup[x_current][y_current].type);
                map[x_current + 1][y_current].setType(tileType.PLAYER);
            }
        } else if (move.equals("d")) {
            if (y_current == map[0].length - 1 || map[x_current][y_current + 1].type == tileType.INACCESSIBLE) {
                System.out.println("You can't move there!");
            } else {
                map[x_current][y_current].setType(mapBackup[x_current][y_current].type);
                map[x_current][y_current + 1].setType(tileType.PLAYER);
            }
        }
    }


    public int[] getPlayerPosition() {
        int[] playerPosition = new int[2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].type == tileType.PLAYER) {
                    playerPosition[0] = i;
                    playerPosition[1] = j;
                }
            }
        }
        return playerPosition;
    }

    public String printMap() {
        String mapString = "";
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[i].length; j++) {
                mapString += tileImage(this.map[i][j].type);
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
