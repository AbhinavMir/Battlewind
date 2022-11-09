import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;

public class Map {
    PrettyPrint pp = new PrettyPrint();
    static Tile[][] backupMap;
    Logger logger = Logger.getLogger(Map.class.getName());
    Tile[][] map;

    public Map(int seed, int x, int y) {
        map = new Tile[x][y];
        populateMap(seed, x, y);
    }

    public static void main(String[] args) {
        Map map = new Map(1, 10, 10);
        map.initializeMap();
        System.out.println(map.printMap());
        Scanner scanner = new Scanner(System.in);
        String move = scanner.nextLine();
        //map.movePlayer(move);
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
                } else if (randNum < 50) {
                    map[i][j] = new Tile(tileTypes[2], i, j);
                } else {
                    map[i][j] = new Tile(tileTypes[0], i, j);
                }
            }
        }

        backupMap = map;
    }

    public String tileImage(tileType tile) {
        if (tile == tileType.COMMON) {
            return ""+pp.GREEN_BACKGROUND + "(C)" + pp.RESET+"";
        } else if (tile == tileType.INACCESSIBLE) {
            return ""+pp.RED_BACKGROUND + "(X)" + pp.RESET+"";
        } else if (tile == tileType.MARKET) {
            return ""+pp.BLUE_BACKGROUND + "(M)" + pp.RESET+"";
        } else if (tile == tileType.PLAYER) {
            return ""+pp.YELLOW_BACKGROUND + "YOU" + pp.RESET+"";
        }

        return "ERR";
    }

   public int[] getPlayerPosition() {
        int[] playerPosition = new int[2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].getType() == tileType.PLAYER) {
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

    public String printBackupMap() {
        String mapString = "";
        backupMap[0][0].setType(tileType.COMMON);
        for (int i = 0; i < backupMap.length; i++) {
            for (int j = 0; j < backupMap[i].length; j++) {
                mapString += tileImage(backupMap[i][j].type);
            }
            mapString += "\n";
        }

        return mapString;
    }

    enum tileType {
        INACCESSIBLE, MARKET, COMMON, PLAYER
    }

    class Tile {
        tileType type;
        int x;
        int y;

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
