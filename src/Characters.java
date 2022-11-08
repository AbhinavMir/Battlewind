import java.util.HashMap;

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
}
