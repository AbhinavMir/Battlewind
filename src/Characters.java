public class Characters {
    class Hero
    {
        String name;
        int level;
        int exp;
        int hp;
        int mp;
        int strength;
        int dexterity;
        int agility;
        int gold;
        ItemsAndWeapon.Item[] inventory;
    }

    interface RuleSet
    {
        // write a method to calculate the hero's HP
        int calcHP(Hero hero);
        // write a method to calculate the hero's MP
        int calcMP(Hero hero);
        // write a method to calculate the hero's strength
        int calcStrength(Hero hero);
        // write a method to calculate the hero's dexterity
        int calcDexterity(Hero hero);
        // write a method to calculate the hero's agility
        int calcAgility(Hero hero);
    }
}
