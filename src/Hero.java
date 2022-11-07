public class Hero extends Characters
{
    int mp;
    int strength;
    int dexterity;
    int agility;
    int gold;
    itemBaseClass.Item[] inventory;
    public Hero(String name, int level, int exp, int hp, int baseDamage)
    {
        super(name, level, exp, hp, baseDamage);
    }
}
