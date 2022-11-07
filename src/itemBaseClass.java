// import arraylist

import java.util.ArrayList;

public class itemBaseClass {

    ArrayList<Potion> potions = new ArrayList<Potion>();
    ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    ArrayList<Armor> armors = new ArrayList<Armor>();

    enum HeroType {
        WARRIOR, PALADIN, SORCERERS
    }

    class Item {
        String name;
        int cost;

        class itemData {
        }
    }

    class Weapon extends Item {
        // Name/cost/level/damage/required hands
        String name;

        class weaponData extends itemData {
            int level;
            int damage;
            int hands;
        }
    }

    class Armor extends Item {
        String name;

        class armorData extends itemData {
            int level;
            int damage;
        }
    }

    class Potion extends Item {
        String name;

        class potionData extends itemData {
            int level;
            int damage;
        }
    }
}
