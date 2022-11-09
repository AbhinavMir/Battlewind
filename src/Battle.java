import java.util.ArrayList;
import java.util.Random;

public class Battle {

    private int numHeroes;

    private ArrayList<Characters.Monster> monsters = new ArrayList<Characters.Monster>();

    public ArrayList<Characters.Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Characters.Monster> monsters) {
        this.monsters = monsters;
    }

    public Battle(int numHeroes) {
        this.numHeroes = numHeroes;
        for (int i = 0; i < 3; i++) {
            this.monsters.add(createMonster());
        }
    }

    public static void printBattleCry() {
        System.out.println("            /\\\n" + "/vvvvvvvvvvvv \\--------------------------------------,\n" + "`^^^^^^^^^^^^ /=====================================\"\n" + "            \\/");
    }

    public static void main(String[] args) {
        readHandler.init();
        Battle battle = new Battle(3);
        for (int i = 0; i < battle.getMonsters().size(); i++) {
            System.out.println(battle.getMonsters().get(i).getName());
        }
    }

    public Characters.Monster createMonster() {
        ArrayList<Characters.Monster> monsters = new ArrayList<>();
        int monsterArraySize = readHandler.getAllMonsters().size();
        Random random = new Random();
        int randomMonster = random.nextInt(monsterArraySize);
        Characters.Monster monster = readHandler.getAllMonsters().get(randomMonster);
        return monster;
    }

    public void startBattle() {
        printBattleCry();
    }
}
