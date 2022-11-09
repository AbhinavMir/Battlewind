import java.util.ArrayList;
import java.util.Scanner;

public class Market
{
    public static void prompt(Scanner scanner)
    {
        System.out.println("Welcome to market!");
        Characters.Player.getGold();
        System.out.println("Would you like to (1) buy, (2) sell or (3) leave?");
        int userChoice = scanner.nextInt();
        Characters.Hero thisHero = new Characters.Hero();
        System.out.println("For which hero?");
        int heroChoice = scanner.nextInt();
        thisHero = gameData.getHero(heroChoice);
        if(userChoice == 1)
        {
            System.out.println("What would you like to buy?");
            System.out.println("1. Potion");
            System.out.println("2. Weapon");
            System.out.println("3. Armor");
            System.out.println("4. Spell");
            int userChoice2 = scanner.nextInt();
            if(userChoice2 == 1)
            {
                readHandler.getListOfPotions();
                System.out.println("Which potion would you like to buy?");
                int userChoice3 = scanner.nextInt();
                Potion potion = readHandler.getListOfPotions().get(userChoice3);
                if(thisHero.getGold() >= potion.cost)
                {
                    thisHero.getPotions().add(potion);
                    thisHero.gold -= potion.cost;
                    System.out.println("You bought a " + potion.name + " for " + potion.cost + " gold.");
                }
                else
                {
                    System.out.println("You don't have enough gold!");
                }
            }

            else if(userChoice2 == 2)
            {
                readHandler.getListOfWeapons();
                System.out.println("Which weapon would you like to buy?");
                int userChoice3 = scanner.nextInt();
                Weapon weapon = readHandler.getListOfWeapons().get(userChoice3);
                if(thisHero.getGold() >= weapon.cost)
                {
                    thisHero.getWeapons().add(weapon);
                    thisHero.gold -= weapon.cost;
                    System.out.println("You bought a " + weapon.name + " for " + weapon.cost + " gold.");
                }
                else
                {
                    System.out.println("You don't have enough gold!");
                }
            }

            else if(userChoice2 == 3)
            {
                readHandler.getListOfArmors();
                System.out.println("Which armor would you like to buy?");
                int userChoice3 = scanner.nextInt();
                Armor armor = readHandler.getListOfArmors().get(userChoice3);
                if(thisHero.getGold() >= armor.cost)
                {
                    thisHero.getArmors().add(armor);
                    thisHero.gold -= armor.cost;
                    System.out.println("You bought a " + armor.name + " for " + armor.cost + " gold.");
                }
                else
                {
                    System.out.println("You don't have enough gold!");
                }
            }

            else if(userChoice2 == 4)
            {
                // check if hero is a sorcerer or paladin
                if(thisHero.type == Characters.Hero.heroType.SORCERER || thisHero.type == Characters.Hero.heroType.PALADIN)
                {
                    ArrayList<Characters.Spell> lightningSpells = readHandler.getListOfLightningSpells();
                    ArrayList<Characters.Spell> fireSpells = readHandler.getListOfFireballSpells();
                    ArrayList<Characters.Spell> iceSpells = readHandler.getListOfIceSpells();
                    System.out.println("Which type of spell would you like to buy?");
                    System.out.println("1. Lightning" + " " + "2. Fire" + " " + "3. Ice");
                    int userChoice3 = scanner.nextInt();
                    if(userChoice3==1)
                    {

                    }
                }
                else
                {
                    System.out.println("You can't buy spells!");
                }
            }
        }
    }
    ArrayList<Potion> potionsOnSale= new ArrayList<Potion>();
    ArrayList<Weapon> weaponsOnSale= new ArrayList<Weapon>();
    ArrayList<Armor> armorsOnSale= new ArrayList<Armor>();
    ArrayList<Characters.Spell> fireballSpellsOnSale= new ArrayList<Characters.Spell>();
    ArrayList<Characters.Spell> lightningSpellsOnSale= new ArrayList<Characters.Spell>();
    ArrayList<Characters.Spell> iceSpellsOnSale= new ArrayList<Characters.Spell>();

    public Market()
    {
        potionsOnSale = readHandler.getListOfPotions();
        weaponsOnSale = readHandler.getListOfWeapons();
        armorsOnSale = readHandler.getListOfArmors();
        fireballSpellsOnSale = readHandler.getListOfFireballSpells();
        lightningSpellsOnSale = readHandler.getListOfLightningSpells();
        iceSpellsOnSale = readHandler.getListOfIceSpells();
    }

    // use generics
    public <T> void buyItem(T item, Characters.Hero hero)
    {
        if (item instanceof Potion)
        {
            Potion potion = (Potion) item;
            hero.potions.add(potion);
            hero.payGold(potion.cost);
        }
        else if (item instanceof Weapon)
        {
            Weapon weapon = (Weapon) item;
            hero.weapons.add(weapon);
            hero.payGold(weapon.cost);
        }
        else if (item instanceof Armor)
        {
            Armor armor = (Armor) item;
            hero.armors.add(armor);
            hero.payGold(armor.cost);
        }
        else if (item instanceof Characters.Spell)
        {
            Characters.Spell spell = (Characters.Spell) item;
            hero.spells.add(spell);
            hero.payGold(spell.cost);
        }
    }
}
