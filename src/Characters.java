import java.util.ArrayList;

public class Characters {
    String name;
    int level;
    int exp;
    int hp;
    int currentHp;
    int baseDamage;

    public Characters(String name, int level, int exp, int baseDamage) {
        this.name = name;
        this.level = level;
        this.exp = exp;
        this.hp = 100 * level;
        this.baseDamage = baseDamage;
    }

    public Characters() {

    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
        this.setHp(this.getLevel() * 100);
    }

    public static class Monster extends Characters {
        // Name/level/damage/defense/dodge chance
        int damage;
        int defense;
        int dodgeChance;

        public Monster(String name, int level, int damage, int exp, int hp, int baseDamage, int dodgeChance) {
            super(name, level, exp, baseDamage);
            this.damage = damage;
            this.dodgeChance = dodgeChance;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getDefense() {
            return defense;
        }

        public void setDefense(int defense) {
            this.defense = defense;
        }

        public int getDodgeChance() {
            return dodgeChance;
        }

        public void setDodgeChance(int dodgeChance) {
            this.dodgeChance = dodgeChance;
        }

        enum monsterType {
            DRAGON, SPIRIT, EXOSKELETON

        }
    }

    static class Player {
        ArrayList<Hero> group = new ArrayList<>();

        public static String getGold() {
            String totalGoldByHeroes = "";
            int numHeroes = gameData.heroes.size();
            for (int i = 0; i < numHeroes; i++) {
                gameData.heroes.get(i).getGold();
                totalGoldByHeroes += gameData.heroes.get(i).getName() + " has " + gameData.heroes.get(i).getGold() + " gold\n";
            }
            return totalGoldByHeroes;
        }

        public static String viewInventory(Characters.Hero hero) {
            String inventory = "";

            // get all potions
            inventory += "Potions:\n";
            for (int i = 0; i < hero.getPotions().size(); i++) {
                inventory += hero.getPotions().get(i).name + "\n";
            }

            // get all weapons
            inventory += "Weapons:\n";
            for (int i = 0; i < hero.getWeapons().size(); i++) {
                inventory += hero.getWeapons().get(i).name + "\n";
            }

            // get all armor
            inventory += "Armor:\n";
            for (int i = 0; i < hero.getArmors().size(); i++) {
                inventory += hero.getArmors().get(i).name + "\n";
            }

            return inventory;
        }
    }

    public static class Hero extends Characters {
        int id;
        int mp;
        int mana;
        int startingMoney;
        int startingExperience;
        int strength;
        int dexterity;
        int agility;
        int gold;
        int defense;
        int x;
        int y;
        heroType type;
        int dodgeChance;
        Weapon weapon;
        Armor armor;
        ArrayList<Spell> spells = new ArrayList<>();
        ArrayList<Potion> potions = new ArrayList<>();
        ArrayList<Weapon> weapons = new ArrayList<>();
        ArrayList<Armor> armors = new ArrayList<>();

        public Hero(String name, int mana, int strength, int agility, int dexterity, int startingMoney, int startingExperience, heroType type, int hp, int baseDamage) {
            super(name, 0, startingExperience, baseDamage);
            this.mana = mana;
            this.type = type;
            this.defense = 0;
            this.startingMoney = startingMoney;
            this.startingExperience = startingExperience;
            this.strength = strength;
            this.dexterity = dexterity;
            this.agility = agility;
        }

        public Hero() {
            super();
        }

        public Hero(String name, int mana, int strength, int agility, int dexterity, int startingMoney, int startingExp, heroType type) {
            super(name, 0, startingExp, strength);
            this.mana = mana;
            this.type = type;
            this.startingMoney = startingMoney;
            this.startingExperience = startingExp;
            this.strength = strength;
            this.dexterity = dexterity;
            this.agility = agility;
        }

        public Weapon getWeapon() {
            return weapon;
        }

        public void setWeapon(Weapon weapon) {
            this.weapon = weapon;
        }

        public void removeWeapon() {
            this.weapon = null;
        }

        public Armor getArmor() {
            return armor;
        }

        public void setArmor(Armor armor) {
            this.armor = armor;
        }

        public void removeArmor() {
            this.armor = null;
        }

        public int getDodgeChance() {
            return dodgeChance;
        }

        public void setDodgeChance(int dodgeChance) {
            this.dodgeChance = dodgeChance;
        }

        public int getDefense() {
            return defense;
        }

        public void setDefense(int defense) {
            this.defense = defense;
        }

        public ArrayList<Spell> getSpells() {
            return spells;
        }

        public void setSpells(ArrayList<Spell> spells) {
            this.spells = spells;
        }

        public ArrayList<Potion> getPotions() {
            return potions;
        }

        public void setPotions(ArrayList<Potion> potions) {
            this.potions = potions;
        }

        public ArrayList<Weapon> getWeapons() {
            return weapons;
        }

        public void setWeapons(ArrayList<Weapon> weapons) {
            this.weapons = weapons;
        }

        public ArrayList<Armor> getArmors() {
            return armors;
        }

        public void setArmors(ArrayList<Armor> armors) {
            this.armors = armors;
        }

        public void payGold(int amount) {
            this.setGold(this.getGold() - amount);
        }

        public void printHero() {
            System.out.println("Name: " + this.getName() + " Level: " + this.getLevel() + " Exp: " + this.getExp() + " HP: " + this.getHp() + " Base Damage: " + this.getBaseDamage() + " Mana: " + this.getMana() + " Strength: " + this.getStrength() + " Agility: " + this.getAgility() + " Dexterity: " + this.getDexterity() + " Gold: " + this.getGold());
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getMp() {
            return mp;
        }

        public void setMp(int mp) {
            this.mp = mp;
        }

        public int getStrength() {
            return strength;
        }

        public void setStrength(int strength) {
            this.strength = strength;
        }

        public int getDexterity() {
            return dexterity;
        }

        public void setDexterity(int dexterity) {
            this.dexterity = dexterity;
        }

        public int getAgility() {
            return agility;
        }

        public void setAgility(int agility) {
            this.agility = agility;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public heroType getType() {
            return type;
        }

        public void setType(heroType type) {
            this.type = type;
        }

        public int getMana() {
            return mana;
        }

        public void setMana(int mana) {
            this.mana = mana;
        }

        public int getStartingMoney() {
            return startingMoney;
        }

        public void setStartingMoney(int startingMoney) {
            this.startingMoney = startingMoney;
        }

        public int getStartingExperience() {
            return startingExperience;
        }

        public void setStartingExperience(int startingExperience) {
            this.startingExperience = startingExperience;
        }

        enum heroType {
            WARRIOR, PALADIN, SORCERER
        }
    }

    class Spell {
        String name;
        int cost;
        int requiredLevel;
        int damage;
        int manaCost;

        public Spell(String name, int cost, int requiredLevel, int damage, int manaCost) {
            this.name = name;
            this.cost = cost;
            this.requiredLevel = requiredLevel;
            this.damage = damage;
            this.manaCost = manaCost;
        }
    }
}
