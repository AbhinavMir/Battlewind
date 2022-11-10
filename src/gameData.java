import java.util.ArrayList;

/*
@This is a DB-esque place for us to host game data.
 */
public class gameData {

    static ArrayList<Characters.Hero> heroes = new ArrayList<>();

    ArrayList<itemBaseClass> inventory = new ArrayList<>();

    public static void addHero(Characters.Hero hero)
    {
        heroes.add(hero);
    }

    public static Characters.Hero getHero(int id)
    {
        return heroes.get(id);
    }

    public static void printAllHeroes()
    {
        for (int i = 0; i < heroes.size(); i++)
        {
            System.out.println(i+ ": " + "Name: " + heroes.get(i).getName() + " | Level: " + heroes.get(i).getLevel() + " | Damage: " + heroes.get(i).getBaseDamage() + " | Defense: " + heroes.get(i).getDefense() + " | Dodge Chance: " + heroes.get(i).getDodgeChance() + " | Gold: " + heroes.get(i).getGold());
        }
    }
}

