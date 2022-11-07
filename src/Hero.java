import java.util.HashMap;

public class Hero extends Characters
{
    int mp;
    int strength;
    int dexterity;
    int agility;
    int gold;

    HashMap<String, String> heroMap = new HashMap<String, String>();

    public Hero(String name, int level, int exp, int hp, int baseDamage)
    {
        super(name, level, exp, hp, baseDamage);
    }
}
