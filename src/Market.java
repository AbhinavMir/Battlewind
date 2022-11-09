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
                itemBaseClass potion = readHandler.getListOfPotions().get(userChoice3);

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
