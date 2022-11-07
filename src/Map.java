import java.util.Random;

public class Map {

    Tile[][] map;

    public Map(int seed, int x, int y) {
        map = new Tile[x][y];
        populateMap(seed, x, y);
        this.map[0][0].setType(tileType.PLAYER);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Map map = new Map(rand.nextInt(1000), 10, 10);
//        map.map[0][0].setType(tileType.PALADIN);
//        map.map[6][2].setType(tileType.WARRIOR);
//        map.map[3][3].setType(tileType.SORCERER);
        System.out.println(map.printMap());
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
    }

    public String tileImage(tileType tile) {
        if (tile == tileType.COMMON) {
            return "C";
        } else if (tile == tileType.INACCESSIBLE) {
            return "X";
        } else if (tile == tileType.ACCESSIBLE) {
            return "A";
        } else if (tile == tileType.PLAYER) {
            return "P";
        }

        return "ERR";
    }

    public String printMap() {
        String mapString = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                mapString += tileImage(map[i][j].type);
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
