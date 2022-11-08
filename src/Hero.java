import java.util.HashMap;

public class Hero extends Characters
{
    enum heroType
    {
        WARRIOR,
        PALADIN,
        SORCERER
    }

    int id;
    int mp;
    int strength;
    int dexterity;
    int agility;
    int gold;
    int x;
    int y;
    heroType type;

    public Hero(String name, int level, int exp, int hp, int baseDamage)
    {
        super(name, level, exp, hp, baseDamage);
    }

    public void printHero()
    {
        System.out.println("Name: " + this.getName() + " Level: " + this.getLevel() + " Exp: " + this.getExp() + " HP: " + this.getHp() + " Base Damage: " + this.getBaseDamage());
    }
}
