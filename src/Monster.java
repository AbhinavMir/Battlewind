public class Monster extends Characters {

    String name;
    int exp = 0;
    int damage;
    int defense;
    int dodgeChance;

    public Monster(String name, int level, int exp, int hp, int baseDamage) {
        super(name, level, exp, hp, baseDamage);
    }
}
