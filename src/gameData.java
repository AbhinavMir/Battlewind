import java.util.ArrayList;

public class gameData {
    /*
    This is a DB-esque place for us to host game data
     */

    static ArrayList<Characters.Hero> heroes = new ArrayList<>();
    ArrayList<itemBaseClass.Item> inventory = new ArrayList<>();

    public static void addHero(Characters.Hero hero)
    {
        heroes.add(hero);
    }

    public Characters.Hero getHero(int id)
    {
        return heroes.get(id);
    }

    public static void printAllHeroes()
    {
        for (Characters.Hero hero : heroes)
        {
            System.out.println(hero.getName()+ " " + hero.getLevel() + " " + hero.getExp() + " " + hero.getHp() + " " + hero.getBaseDamage());
        }
    }
}
