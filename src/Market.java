import java.util.ArrayList;

public class Market
{
    ArrayList<Potion> potionsOnSale= new ArrayList<Potion>();
    ArrayList<Weapon> weaponsOnSale= new ArrayList<Weapon>();
    ArrayList<Armor> armorsOnSale= new ArrayList<Armor>();
    ArrayList<Spell> fireballSpellsOnSale= new ArrayList<Spell>();
    ArrayList<Spell> lightningSpellsOnSale= new ArrayList<Spell>();
    ArrayList<Spell> iceSpellsOnSale= new ArrayList<Spell>();

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
        else if (item instanceof Spell)
        {
            Characters.Spell spell = (Characters.Spell) item;
            hero.spells.add(spell);
            hero.payGold(spell.cost);
        }
    }
}
