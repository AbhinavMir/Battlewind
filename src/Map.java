import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;

public class Map {
    Logger logger = Logger.getLogger(Map.class.getName());
    // turn off logger
    // logger.setLevel(Level.OFF);
    Tile[][] map;
    // duplicate of map
    Tile[][] backupMap;

    public Map(int seed, int x, int y) {
        map = new Tile[x][y];
        populateMap(seed, x, y);
        this.map[0][0].setType(tileType.PLAYER);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        Map map = new Map(rand.nextInt(1000), 10, 10);
        System.out.println(map.printMap());
        while (true) {
            String move = scanner.nextLine();
            //map.movePlayer(hero, move);
            System.out.println(map.printMap());
        }
    }

    public static Boolean initiateBattle(Tile tile) {
        return tile.type == tileType.COMMON;
    }

    public void populateMap(int seed, int x, int y) {
        tileType[] tileTypes = {tileType.COMMON, tileType.INACCESSIBLE, tileType.ACCESSIBLE};
        Random rand = new Random(seed);
        Tile[][] map = this.map;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tileType type = tileTypes[rand.nextInt(tileTypes.length)];
                map[i][j] = new Tile(type, i, j);
            }
        }
        this.backupMap = map;
    }

    public String tileImage(tileType tile) {
        if (tile == tileType.COMMON) {
            return " (C) ";
        } else if (tile == tileType.INACCESSIBLE) {
            return " (X) ";
        } else if (tile == tileType.ACCESSIBLE) {
            return " (A) ";
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
                    this.map[x_current][y_current].setType(this.backupMap[x_current][y_current].type);
                    hero.y = y_current - 1;
                    this.map[hero.x][hero.y].setType(tileType.PLAYER);
                }
            } else if (move.equals("a")) {
                if (x_current - 1 >= 0) {
                    // update map
                    this.map[x_current][y_current].setType(this.backupMap[x_current][y_current].type);
                    hero.x = x_current - 1;
                    this.map[hero.x][hero.y].setType(tileType.PLAYER);
                }
            } else if (move.equals("s")) {
                if (y_current + 1 < this.map[0].length) {
                    // update map
                    this.map[x_current][y_current].setType(this.backupMap[x_current][y_current].type);
                    hero.y = y_current + 1;
                    this.map[hero.x][hero.y].setType(tileType.PLAYER);
                }
            } else if (move.equals("d")) {
                if (x_current + 1 < this.map.length) {
                    // update map
                    this.map[x_current][y_current].setType(this.backupMap[x_current][y_current].type);
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

    enum tileType {
        INACCESSIBLE, ACCESSIBLE, COMMON, PLAYER
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
