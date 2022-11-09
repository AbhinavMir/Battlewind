public class Characters {
    String name;
    int level;
    int exp;
    int hp;
    int baseDamage;

    public Characters(String name, int level, int exp, int hp, int baseDamage) {
        this.name = name;
        this.level = level;
        this.exp = exp;
        this.hp = hp;
        this.baseDamage = baseDamage;
    }

    public Characters() {

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

    class Spell
    {
        String name;
        int cost;
        int requiredLevel;
        int damage;
        int manaCost;
        public Spell(String name, int cost, int requiredLevel, int damage, int manaCost)
        {
            this.name = name;
            this.cost = cost;
            this.requiredLevel = requiredLevel;
            this.damage = damage;
            this.manaCost = manaCost;
        }
    }

    public static class Monster extends Characters {

        String name;
        int exp = 0;
        int damage;
        int defense;
        int dodgeChance;

        public Monster(String name, int level, int exp, int hp, int baseDamage) {
            super(name, level, exp, hp, baseDamage);
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
        int x;
        int y;
        heroType type;

        public Hero(
                String name, int mana, int strength, int agility,
                int dexterity, int startingMoney, int startingExperience,
                heroType type, int hp, int baseDamage
        ) {
            super(name, 0, startingExperience, hp, baseDamage);
            this.mana = mana;
            this.type = type;
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
            super(name, 0, startingExp, 0, 0);
            this.mana = mana;
            this.type = type;
            this.startingMoney = startingMoney;
            this.startingExperience = startingExp;
            this.strength = strength;
            this.dexterity = dexterity;
            this.agility = agility;
        }

        public void printHero() {
            System.out.println("Name: " + this.getName() + " Level: " + this.getLevel() + " Exp: " + this.getExp() + " HP: " + this.getHp() + " Base Damage: " + this.getBaseDamage());
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
}
