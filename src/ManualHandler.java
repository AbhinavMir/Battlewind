public class ManualHandler {

    /*
    Things that don't work in one go have a backup handler. Use only if the first one doesn't work.
     */

    public static void loadDragonsManually()
    {
        String name = null;
        int level = 0;
        int damage = 0;
        int defense = 0;
        int dodgeChance = 0;
        // hp = lvl * 100
        for (int i = 0 ; i <12 ; i++)
        {
            switch (i)
            {
                case 0:
                    name = "Desghidorrah";
                    level = 3;
                    damage = 300;
                    defense = 400;
                    dodgeChance = 35;
                    break;
                case 1:
                    name = "Chrysophylax";
                    level = 2;
                    damage = 200;
                    defense = 500;
                    dodgeChance = 20;
                    break;
                case 2:
                    name = "BunsenBurner";
                    level = 4;
                    damage = 400;
                    defense = 500;
                    dodgeChance = 45;
                    break;
                case 3:
                    name = "Natsunomeryu";
                    level = 1;
                    damage = 100;
                    defense = 200;
                    dodgeChance = 10;
                    break;
                case 4:
                    name = "TheScaleless";
                    level = 7;
                    damage = 700;
                    defense = 600;
                    dodgeChance = 75;
                    break;
                case 5:
                    name = "Kas-Ethelinh";
                    level = 5;
                    damage = 600;
                    defense = 500;
                    dodgeChance = 60;
                    break;
                case 6:
                    name = "Alexstraszan";
                    level = 10;
                    damage = 1000;
                    defense = 9000;
                    dodgeChance = 55;
                    break;
                case 7:
                    name = "Phaarthurnax";
                    level = 6;
                    damage = 600;
                    defense = 700;
                    dodgeChance = 60;
                    break;
                case 8:
                    name = "D-Maleficent";
                    level = 9;
                    damage = 900;
                    defense = 950;
                    dodgeChance = 85;
                    break;
                case 9:
                    name = "TheWeatherbe";
                    level = 8;
                    damage = 800;
                    defense = 900;
                    dodgeChance = 80;
                    break;
                case 10:
                    name = "Igneel";
                    level = 6;
                    damage = 600;
                    defense = 400;
                    dodgeChance = 60;
                    break;
                case 11:
                    name = "BlueEyesWhite";
                    level = 9;
                    damage = 900;
                    defense = 600;
                    dodgeChance = 75;
                    break;
            }

            Characters.Monster monster = new Characters.Monster(name, level, damage, defense, dodgeChance, level * 100, damage);
            readHandler.listOfDragons.add(monster);
        }
    }
}
