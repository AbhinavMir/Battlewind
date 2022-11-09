// import arraylist

import java.util.ArrayList;

public class itemBaseClass {
    /*
    Make a base class that has the basics from the three below
    Name/cost/required level/attribute increase/attribute affected - potion
    Name/cost/required level/damage reduction - armory
    Name/cost/level/damage/required hands - weaponry
     */

    class Item
    {
        String name;
        int cost;
        int requiredLevel;

        public Item(String name, int cost, int requiredLevel)
        {
            this.name = name;
            this.cost = cost;
            this.requiredLevel = requiredLevel;
        }
    }

    class Weaponry extends Item
    {
        int damage;
        int requiredHands;

        public Weaponry(String name, int cost, int requiredLevel, int damage, int requiredHands)
        {
            super(name, cost, requiredLevel);
            this.damage = damage;
            this.requiredHands = requiredHands;
        }
    }

    class Armory extends Item
    {
        int damageReduction;

        public Armory(String name, int cost, int requiredLevel, int damageReduction)
        {
            super(name, cost, requiredLevel);
            this.damageReduction = damageReduction;
        }
    }

    class Potion extends Item
    {
        int attributeIncrease;
        String attributeAffected;

        public Potion(String name, int cost, int requiredLevel, int attributeIncrease, String attributeAffected)
        {
            super(name, cost, requiredLevel);
            this.attributeIncrease = attributeIncrease;
            this.attributeAffected = attributeAffected;
        }
    }
}
