import java.util.ArrayList;
import java.util.Scanner;

/*
A module to handle market and merchant (not mentioned programatically)
Can buy and sell with Gold
Unlimited supply of items for convenience of tester
 */
public class Market {
    ArrayList<Potion> potionsOnSale = new ArrayList<Potion>();
    ArrayList<Weapon> weaponsOnSale = new ArrayList<Weapon>();
    ArrayList<Armor> armorsOnSale = new ArrayList<Armor>();
    ArrayList<Characters.Spell> fireballSpellsOnSale = new ArrayList<Characters.Spell>();
    ArrayList<Characters.Spell> lightningSpellsOnSale = new ArrayList<Characters.Spell>();
    ArrayList<Characters.Spell> iceSpellsOnSale = new ArrayList<Characters.Spell>();

    public Market() {
        potionsOnSale = readHandler.getListOfPotions();
        weaponsOnSale = readHandler.getListOfWeapons();
        armorsOnSale = readHandler.getListOfArmors();
        fireballSpellsOnSale = readHandler.getListOfFireballSpells();
        lightningSpellsOnSale = readHandler.getListOfLightningSpells();
        iceSpellsOnSale = readHandler.getListOfIceSpells();
    }

    public static void prompt() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                prePrompt(scanner);
                scanner.close();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input, let's try again");
            }
        }
    }

    public static void prePrompt(Scanner scanner) {
        System.out.println("Welcome to market!");
        Characters.Player.getGold();
        System.out.println("Would you like to (1) buy, (2) sell or (3) leave?");
        // userChoice with scanner but make sure correct input
        int userChoice = 0;
        userChoice = scanner.nextInt();
        Characters.Hero thisHero = new Characters.Hero();

        if (userChoice == 1) {
            System.out.println("BUYING");
            System.out.println("For which hero?");
            gameData.printAllHeroes();
            int heroChoice = 0;
            heroChoice = scanner.nextInt();
            thisHero = gameData.getHero(heroChoice);
            System.out.println("What would you like to buy?");
            System.out.println("1. Potion");
            System.out.println("2. Weapon");
            System.out.println("3. Armor");
            System.out.println("4. Spell");
            System.out.println("5. Repellents");
            System.out.println("6. Leave");
            int userChoice2 = 0;
            userChoice2 = scanner.nextInt();
            if (userChoice2 == 1) {
                System.out.println("Which potion would you like to buy?");
                readHandler.printAllPotions();
                int userChoice3 = scanner.nextInt();
                Potion potion = readHandler.getListOfPotions().get(userChoice3);
                if (thisHero.getGold() >= potion.cost) {
                    thisHero.getPotions().add(potion);
                    thisHero.gold -= potion.cost;
                    System.out.println("You bought a " + potion.name + " for " + potion.cost + " gold.");
                } else {
                    System.out.println("You don't have enough gold!");
                }
            } else if (userChoice == 2) {
                readHandler.printAllWeapons();
                System.out.println("Which weapon would you like to buy?");
                int userChoice3 = 0;
                Weapon weapon = readHandler.getListOfWeapons().get(userChoice3);
                if (thisHero.getGold() >= weapon.cost) {
                    thisHero.getWeapons().add(weapon);
                    thisHero.gold -= weapon.cost;
                    System.out.println("You bought a " + weapon.name + " for " + weapon.cost + " gold.");
                } else {
                    System.out.println("You don't have enough gold!");
                }
            } else if (userChoice == 3) {
                readHandler.printAllArmors();
                System.out.println("Which armor would you like to buy?");
                int userChoice3 = scanner.nextInt();
                Armor armor = readHandler.getListOfArmors().get(userChoice3);
                if (thisHero.getGold() >= armor.cost) {
                    thisHero.getArmors().add(armor);
                    thisHero.gold -= armor.cost;
                    System.out.println("You bought a " + armor.name + " for " + armor.cost + " gold.");
                } else {
                    System.out.println("You don't have enough gold!");
                }
            } else if (userChoice == 4) {
                // check if hero is a sorcerer or paladin
                if (thisHero.type == Characters.Hero.heroType.SORCERER || thisHero.type == Characters.Hero.heroType.PALADIN) {
                    ArrayList<Characters.Spell> lightningSpells = readHandler.getListOfLightningSpells();
                    ArrayList<Characters.Spell> fireSpells = readHandler.getListOfFireballSpells();
                    ArrayList<Characters.Spell> iceSpells = readHandler.getListOfIceSpells();
                    readHandler.printAllSpells();
                    System.out.println("Which type of spell would you like to buy?");
                    System.out.println("1. Lightning" + " " + "2. Fire" + " " + "3. Ice");
                    int userChoice3 = scanner.nextInt();
                    if (userChoice3 == 1) {
                        System.out.println("Which spell would you like to buy?");
                        for (int i = 0; i < lightningSpells.size(); i++) {
                            System.out.println(i + ". " + lightningSpells.get(i).name + " " + lightningSpells.get(i).cost);
                        }
                        int userChoice4 = scanner.nextInt();
                        Characters.Spell spell = lightningSpells.get(userChoice4);
                        if (thisHero.getGold() >= spell.cost) {
                            thisHero.getSpells().add(spell);
                            thisHero.gold -= spell.cost;
                            System.out.println("You bought a " + spell.name + " for " + spell.cost + " gold.");
                        } else {
                            System.out.println("You don't have enough gold!");
                        }
                    } else if (userChoice3 == 2) {
                        System.out.println("Which spell would you like to buy?");
                        for (int i = 0; i < fireSpells.size(); i++) {
                            System.out.println(i + ". " + fireSpells.get(i).name + " " + fireSpells.get(i).cost);
                        }
                        int userChoice4 = scanner.nextInt();
                        Characters.Spell spell = fireSpells.get(userChoice4);
                        if (thisHero.getGold() >= spell.cost) {
                            thisHero.getSpells().add(spell);
                            thisHero.gold -= spell.cost;
                            System.out.println("You bought a " + spell.name + " for " + spell.cost + " gold.");
                        } else {
                            System.out.println("You don't have enough gold!");
                        }
                    } else if (userChoice3 == 3) {
                        System.out.println("Which spell would you like to buy?");
                        for (int i = 0; i < iceSpells.size(); i++) {
                            System.out.println(i + ". " + iceSpells.get(i).name + " " + iceSpells.get(i).cost);
                        }
                        int userChoice4 = scanner.nextInt();
                        Characters.Spell spell = iceSpells.get(userChoice4);
                        if (thisHero.getGold() >= spell.cost) {
                            thisHero.getSpells().add(spell);
                            thisHero.gold -= spell.cost;
                            System.out.println("You bought a " + spell.name + " for " + spell.cost + " gold.");
                        } else {
                            System.out.println("You don't have enough gold!");
                        }
                    }
                } else {
                    System.out.println("You can't buy spells!");
                }
            }
            else if(userChoice2 == 5)
            {
                System.out.println("For how many steps?");
                int userChoice3 = scanner.nextInt();

            }
        } else if (userChoice == 2) {
            System.out.println("What would you like to sell?");
            System.out.println("1. Potion");
            System.out.println("2. Weapon");
            System.out.println("3. Armor");
            System.out.println("4. Spell");
            System.out.println("5. Nothing, I'm good.");
            int userChoice2 = scanner.nextInt();
            if (userChoice2 == 1) {
                System.out.println("Which potion would you like to sell?");
                for (int i = 0; i < thisHero.getPotions().size(); i++) {
                    System.out.println(i + ". " + thisHero.getPotions().get(i).name + " " + thisHero.getPotions().get(i).cost);
                }
                int userChoice3 = scanner.nextInt();
                Potion potion = thisHero.getPotions().get(userChoice3);
                thisHero.getPotions().remove(potion);
                thisHero.gold += potion.cost;
                System.out.println("You sold a " + potion.name + " for " + potion.cost + " gold.");
            } else if (userChoice2 == 2) {
                System.out.println("Which weapon would you like to sell?");
                for (int i = 0; i < thisHero.getWeapons().size(); i++) {
                    System.out.println(i + ". " + thisHero.getWeapons().get(i).name + " " + thisHero.getWeapons().get(i).cost);
                }
                int userChoice3 = scanner.nextInt();
                Weapon weapon = thisHero.getWeapons().get(userChoice3);
                thisHero.getWeapons().remove(weapon);
                thisHero.gold += weapon.cost;
                System.out.println("You sold a " + weapon.name + " for " + weapon.cost + " gold.");
            } else if (userChoice2 == 3) {
                System.out.println("Which armor would you like to sell?");
                for (int i = 0; i < thisHero.getArmors().size(); i++) {
                    System.out.println(i + ". " + thisHero.getArmors().get(i).name + " " + thisHero.getArmors().get(i).cost);
                }
                int userChoice3 = scanner.nextInt();
                Armor armor = thisHero.getArmors().get(userChoice3);
                thisHero.getArmors().remove(armor);
                thisHero.gold += armor.cost;
                System.out.println("You sold a " + armor.name + " for " + armor.cost);
            }
            else if (userChoice2 == 5)
            {
                System.out.println(PrettyPrint.RED+"Merchant"+PrettyPrint.RESET+" : Come back anytime!");
            }
        }
        else if(userChoice == 3){
            System.out.println("You left the shop.");
        }
    }

    public static void main(String[] args) {
        prompt();
    }
}

