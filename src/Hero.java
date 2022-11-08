import java.util.HashMap;

public class Hero extends Characters {
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
    public Hero(String name, int level, int exp, int hp, int baseDamage) {
        super(name, level, exp, hp, baseDamage);
    }

    public Hero() {
        super();
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
