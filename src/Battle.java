import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
A class to handle the battle between the hero and the monster
Can have one-to-one attack as chosen by user
A new instance is created when a battle is initiated in COMMON grounds
Local variable copies are maintained for speed
@TODO: Improve memory management
 */
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
        gameData.printAllHeroes();
        ArrayList<Characters.Hero> heroesInPlay = gameData.heroes;
        int turnCounter = 0;
        int numHeroes = heroesInPlay.size();
        Characters.Hero currentHero;
        int choice2;
        while (true) {
            currentHero = heroesInPlay.get(turnCounter % numHeroes);
            System.out.println("What would " + heroesInPlay.get(turnCounter % numHeroes).getName() + " like to do?");
            System.out.println("1. Attack\n2. Use Spell\n3. Use Potion\n4. Change equipment");
            while (true) {
                try {
                    choice = scanner.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Please enter a valid choice");
                }
            }

            while (choice < 1 || choice > 4) {
                System.out.println("Please enter an acceptable option");
                choice = scanner.nextInt();
            }
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
            } else if (choice == 2) {
                System.out.println("Which spell would you like to use?");
                for (int i = 0; i < currentHero.getSpells().size(); i++) {
                    System.out.println(i + ". " + currentHero.getSpells().get(i).name);
                }
                choice2 = scanner.nextInt();
                System.out.println("Which monster would you like to attack?");
                for (int i = 0; i < this.getMonsters().size(); i++) {
                    System.out.println(i + ". " + this.getMonsters().get(i).getName());
                }
                choice2 = scanner.nextInt();
                spell(currentHero, this.getMonsters().get(choice2), currentHero.getSpells().get(choice2));
                if (allHeroesDead()) {
                    System.out.println("You've lost the battle!");
                    System.exit(0);
                } else if (allMonstersDead()) {
                    System.out.println("You've won the battle!");
                    System.exit(0);
                } else if (choice == 3) {
                    System.out.println("Which potion would you like to use?");
                    for (int i = 0; i < currentHero.getPotions().size(); i++) {
                        System.out.println(i + ". " + currentHero.getPotions().get(i).name);
                    }
                    choice2 = scanner.nextInt();
                    Potion potion = currentHero.getPotions().get(choice2);
                    potion.usePotion(currentHero, potion);
                } else if (choice == 4) {
                    System.out.println("Which equipment would you like to change?");
                    System.out.println("1. Weapon\n2. Armor");
                    choice2 = scanner.nextInt();
                    if (choice2 == 1) {
                        System.out.println("Which weapon would you like to equip?");
                        for (int i = 0; i < currentHero.getWeapons().size(); i++) {
                            System.out.println(i + ". " + currentHero.getWeapons().get(i).name);
                        }
                        choice2 = scanner.nextInt();
                        Weapon weapon = currentHero.getWeapons().get(choice2);
                        currentHero.setWeapon(weapon);
                    } else if (choice2 == 2) {
                        System.out.println("Which armor would you like to equip?");
                        for (int i = 0; i < currentHero.getArmors().size(); i++) {
                            System.out.println(i + ". " + currentHero.getArmors().get(i).name);
                        }
                        choice2 = scanner.nextInt();
                        Armor armor = currentHero.getArmors().get(choice2);
                        currentHero.setArmor(armor);
                    }
                }
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

    public void spell(Characters.Hero hero, Characters.Monster monster, Spell spell) {
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
