import java.util.HashMap;

public class Spell {

    /*
    Name/cost/required level/damage/mana cost
    Lightning_Dagger      400        1       500     150
    Thunder_Blast         750        4       950     400
    Electric_Arrows       550        5       650     200
    Spark_Needles         500        2       600     200
     */

    HashMap<String, String> spellMap = new HashMap<String, String>();
    String name;

    class spellData {
        int cost;
        int level;
        int damage;
        int manaCost;
    }


}
