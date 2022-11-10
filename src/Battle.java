import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.reflect.Array;
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

        // print out your party
        System.out.println("Your party:");
        ArrayList<Characters.Hero> heroesInPlay = new ArrayList<Characters.Hero>();
        for (int i = 0; i < this.numHeroes; i++) {
            heroesInPlay.add(gameData.getHero(i));
        }
        gameData.printAllHeroes();
        int turnCounter = 0;
        int numHeroes = heroesInPlay.size();
        Characters.Hero currentHero;
        int choice2;
        while (true) {
            currentHero = heroesInPlay.get(turnCounter % numHeroes);
            System.out.println("What would" + heroesInPlay.get(turnCounter % numHeroes).getName() + "like to do?");
            System.out.println("1. Attack\n2. Use Spell\n3. Use Potion\n4. Change equipment");
            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Which monster would you like to attack?");
                for (int i = 0; i < this.getMonsters().size(); i++) {
                    System.out.println(i + ". " + this.getMonsters().get(i).getName());
                }
                choice2 = scanner.nextInt();
                attack(currentHero, this.getMonsters().get(choice2));
                if (allHeroesDead()) {
                    System.out.println("You've lost the battle!");
                    System.exit(0);
                } else if (allMonstersDead()) {
                    System.out.println("You've won the battle!");
                    System.exit(0);
                }
            }
            else if (choice == 2)
            {

            }
        }
    }

    public void attack(Characters.Hero hero, Characters.Monster monster) {
        int damage;
        try {
            if (hero.getWeapons().size() > 0) {
                damage = hero.getWeapons().get(0).damage + hero.getBaseDamage();
            } else {
                damage = hero.getBaseDamage();
            }
            int monsterHp = monster.getCurrentHp();
            monster.setCurrentHp(monsterHp - damage);
        } catch (Exception e) {
            System.out.println("You cannot perform this attack!");
        }
    }

    public Boolean allHeroesDead() {
        int numHeroes = gameData.heroes.size();
        int numDeadHeroes = 0;
        for (int i = 0; i < numHeroes; i++) {
            if (gameData.heroes.get(i).getCurrentHp() <= 0) {
                numDeadHeroes++;
            }
        }
        return numDeadHeroes == numHeroes;
    }

    public Boolean allMonstersDead() {
        for (int i = 0; i < this.getMonsters().size(); i++) {
            if (this.getMonsters().get(i).getCurrentHp() > 0) {
                return false;
            }
        }
        return true;
    }

    public void spell(Characters.Hero hero, Characters.Monster monster, Characters.Spell spell) {
        if (hero.getMp() > spell.manaCost) {
            if (hero.type == Characters.Hero.heroType.SORCERER || hero.type == Characters.Hero.heroType.PALADIN) {
                int damage = spell.damage + (hero.dexterity / 10000 * spell.damage);
                int monsterHp = monster.getCurrentHp();
                monster.setCurrentHp(monsterHp - damage);
            } else {
                System.out.println("You can't cast spells!");
            }
        } else {
            System.out.println("You don't have enough mana!");
        }
    }

}
