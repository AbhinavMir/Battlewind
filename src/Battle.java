import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle {

    private final int numHeroes;

    private ArrayList<Characters.Monster> monsters = new ArrayList<Characters.Monster>();

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
        battle.startBattle();
    }

    public ArrayList<Characters.Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Characters.Monster> monsters) {
        this.monsters = monsters;
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
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        printBattleCry();
        if (this.getMonsters().size() > 0) {
            System.out.println("You've encountered a party of " + this.getMonsters().size() + " monsters!");
        } else {
            System.out.println("You've encountered a monster!");
        }
        System.out.println("Name | level | damage | defense | dodge chance");
        for (int i = 0; i < this.getMonsters().size(); i++) {
            readHandler.printMonster(this.getMonsters().get(i));
            PrettyPrint.healthBarPrinter(this.getMonsters().get(i).getCurrentHp(), this.getMonsters().get(i).getHp());
        }

        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("(1) Attack\n" + "(2) Use a Spell\n" + "(3) Change Equipment\n" + "(4) Use a Potion");
            choice = scanner.nextInt();
            if (choice == 1) {
                attack();
            } else if (choice == 2) {
                useSpell();
            } else if (choice == 3) {
                changeEquipment();
            } else if (choice == 4) {
                usePotion();
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
