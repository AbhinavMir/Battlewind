public class ItemsAndWeapon {

    class Item
    {
        String name;
        int price;
        int level;
    }

    class Weapon extends Item
    {
        int damage;
        int hands;
    }

    class Armor extends Item
    {
        int damageReduction;
    }

    class Potion extends Item
    {
        int effectAmount;
    }

    class Spell extends Item
    {
        int damage;
        int manaCost;
        String spellType;
    }

}
