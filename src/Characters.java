public class Characters {

   /*
   A hero has several attributes:
• A name
• A level with an amount of experience points
• HP (hit points, the hero’s in battle)
• MP (mana or magic points, for casting spells)
• A strength value
• A dexterity value
• An agility value
• An amount of gold
• An inventory of items
The example rules section at the end of this document contains several formulae you can
use for determining HP, MP, and the calculations involving strength, dexterity, and agility.
    */

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
        //Item[] inventory;
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
