import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;

public class Map {
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
        // print out backup map
        System.out.println("Backup map:");
        System.out.println(map.printBackupMap());
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
            return " (C) ";
        } else if (tile == tileType.INACCESSIBLE) {
            return " (X) ";
        } else if (tile == tileType.MARKET) {
            return " (M) ";
        } else if (tile == tileType.PLAYER) {
            return " YOU ";
        }

        return "ERR";
    }

    public String movePlayer(Hero hero, String move) {
        // convert to lowercase and check if moves are within WASD
        move = move.toLowerCase();
        logger.info("Move: " + move);
        if (move.equals("w") || move.equals("a") || move.equals("s") || move.equals("d")) {
            logger.info("Move is WASD");
            int x_current = hero.x;
            int y_current = hero.y;
            logger.info("Current x: " + x_current);
            logger.info("Current y: " + y_current);
            // switch case
            if (move.equals("w")) {
                if (y_current - 1 >= 0) {
                    // update map
                    this.map[x_current][y_current].setType(backupMap[x_current][y_current].type);
                    hero.y = y_current - 1;
                    this.map[hero.x][hero.y].setType(tileType.PLAYER);
                }
            } else if (move.equals("a")) {
                if (x_current - 1 >= 0) {
                    // update map
                    this.map[x_current][y_current].setType(backupMap[x_current][y_current].type);
                    hero.x = x_current - 1;
                    this.map[hero.x][hero.y].setType(tileType.PLAYER);
                }
            } else if (move.equals("s")) {
                if (y_current + 1 < this.map[0].length) {
                    // update map
                    this.map[x_current][y_current].setType(backupMap[x_current][y_current].type);
                    hero.y = y_current + 1;
                    this.map[hero.x][hero.y].setType(tileType.PLAYER);
                }
            } else if (move.equals("d")) {
                if (x_current + 1 < this.map.length) {
                    // update map
                    this.map[x_current][y_current].setType(backupMap[x_current][y_current].type);
                    hero.x = x_current + 1;
                    this.map[hero.x][hero.y].setType(tileType.PLAYER);
                }
            }

            logger.info("New x: " + hero.x);
            logger.info("New y: " + hero.y);
        } else {
            System.out.println("Invalid move");
        }


        return null;
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
