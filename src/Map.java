public class Map {
    class Grid {
        int x;
        int y;
        int type;
        int[] items;
        int[] monsters;
        int[] npcs;
        int[] heroes;
    }

    Grid[][] map;
    int width;
    int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        map = new Grid[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j] = new Grid();
                map[i][j].x = i;
                map[i][j].y = j;
                map[i][j].type = 0;
                map[i][j].items = new int[0];
                map[i][j].monsters = new int[0];
                map[i][j].npcs = new int[0];
                map[i][j].heroes = new int[0];
            }
        }
    }

    public void setGrid(int x, int y, int type, int[] items, int[] monsters, int[] npcs, int[] heroes) {
        map[x][y].type = type;
        map[x][y].items = items;
        map[x][y].monsters = monsters;
        map[x][y].npcs = npcs;
        map[x][y].heroes = heroes;
    }

    private void clearMap() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j].type = 0;
                map[i][j].items = new int[0];
                map[i][j].monsters = new int[0];
                map[i][j].npcs = new int[0];
                map[i][j].heroes = new int[0];
            }
        }
    }
}
