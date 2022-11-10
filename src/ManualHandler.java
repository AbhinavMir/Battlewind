
/*
Things that don't work in one go have a backup handler. Use only if the first one doesn't work.
 */
public class ManualHandler {

    public static void loadPotionsManually() {

        String name = "";
        int cost = 0;
        int requiredLevel = 0;
        int level = 0;
        int attributeIncrease = 0;
        String attributeAffected = "";

        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                name = "Healing_Potion";
                cost = 250;
                requiredLevel = 1;
                attributeIncrease = 100;
                attributeAffected = "Health";
            } else if (i == 1) {
                name = "Strength_Potion";
                cost = 200;
                requiredLevel = 1;
                attributeIncrease = 75;
                attributeAffected = "Strength";
            } else if (i == 2) {
                name = "Magic_Potion";
                cost = 350;
                requiredLevel = 2;
                attributeIncrease = 100;
                attributeAffected = "Mana";
            } else if (i == 3) {
                name = "Luck_Elixir";
                cost = 500;
                requiredLevel = 4;
                attributeIncrease = 65;
                attributeAffected = "Agility";
            } else if (i == 4) {
                name = "Mermaid_Tears";
                cost = 850;
                requiredLevel = 5;
                attributeIncrease = 100;
                attributeAffected = "All Health/Mana/Strength/Agility";
            } else if (i == 5) {
                name = "Ambrosia";
                cost = 1000;
                requiredLevel = 8;
                attributeIncrease = 150;
                attributeAffected = "All Health/Mana/Strength/Dexterity/Defense/Agility";
            }

            Potion potion = new Potion(name, cost, requiredLevel, attributeIncrease, attributeAffected);
            readHandler.listOfPotions.add(potion);
        }
    }

    public static void loadLightningSpellManually() {
        // Name/cost/required level/damage/mana cost
        String name = "";
        int cost = 0;
        int requiredLevel = 0;
        int damage = 0;
        int manaCost = 0;

        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                name = "Lightning_Dagger";
                cost = 400;
                requiredLevel = 1;
                damage = 500;
                manaCost = 150;
            } else if (i == 1) {
                name = "Thunder_Blast";
                cost = 750;
                requiredLevel = 4;
                damage = 950;
                manaCost = 400;
            } else if (i == 2) {
                name = "Electric_Arrows";
                cost = 550;
                requiredLevel = 5;
                damage = 650;
                manaCost = 200;
            } else if (i == 3) {
                name = "Spark_Needles";
                cost = 500;
                requiredLevel = 2;
                damage = 600;
                manaCost = 200;
            }

            Spell lightningSpell = new Spell(name, cost, requiredLevel, damage, manaCost);
            readHandler.listOfLightningSpells.add(lightningSpell);
        }
    }

    public static void loadFireSpells() {
        /*
        Name/cost/required level/damage/mana cost
Flame_Tornado   700     4   850     300
Breath_of_Fire  350     1   450     100
Heat_Wave       450     2   600     150
Lava_Comet      800     7   1000    550
Hell_Storm      600     3   950     600

         */
        String name = "";
        int cost = 0;
        int requiredLevel = 0;
        int damage = 0;
        int manaCost = 0;

        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                name = "Flame_Tornado";
                cost = 700;
                requiredLevel = 4;
                damage = 850;
                manaCost = 300;
            } else if (i == 1) {
                name = "Breath_of_Fire";
                cost = 350;
                requiredLevel = 1;
                damage = 450;
                manaCost = 100;
            } else if (i == 2) {
                name = "Heat_Wave";
                cost = 450;
                requiredLevel = 2;
                damage = 600;
                manaCost = 150;
            } else if (i == 3) {
                name = "Lava_Comet";
                cost = 800;
                requiredLevel = 7;
                damage = 1000;
                manaCost = 550;
            } else if (i == 4) {
                name = "Hell_Storm";
                cost = 600;
                requiredLevel = 3;
                damage = 950;
                manaCost = 600;
            }

            Spell fireSpell = new Spell(name, cost, requiredLevel, damage, manaCost);
            readHandler.listOfFireballSpells.add(fireSpell);
        }
    }

    public static void loadWeaponsManually() {
        /*
        Name/cost/level/damage/required hands
Sword           500     1    800    1
Bow             300     2    500    2
Scythe          1000    6    1100   2
Axe             550     5    850    1
TSwords     	1400    8    1600   2
Dagger          200     1    250    1
         */
        String name = "";
        int cost = 0;
        int level = 0;
        int damage = 0;
        int requiredHands = 0;

        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                name = "Sword";
                cost = 500;
                level = 1;
                damage = 800;
                requiredHands = 1;
            } else if (i == 1) {
                name = "Bow";
                cost = 300;
                level = 2;
                damage = 500;
                requiredHands = 2;
            } else if (i == 2) {
                name = "Scythe";
                cost = 1000;
                level = 6;
                damage = 1100;
                requiredHands = 2;
            } else if (i == 3) {
                name = "Axe";
                cost = 550;
                level = 5;
                damage = 850;
                requiredHands = 1;
            } else if (i == 4) {
                name = "TSwords";
                cost = 1400;
                level = 8;
                damage = 1600;
                requiredHands = 2;
            } else if (i == 5) {
                name = "Dagger";
                cost = 200;
                level = 1;
                damage = 250;
                requiredHands = 1;
            }

            Weapon weapon = new Weapon(name, cost, level, damage, requiredHands);
            readHandler.listOfWeapons.add(weapon);
        }
    }

    public static void loadIceSpellsManually() {
        String name = "";
        int cost = 0;
        int requiredLevel = 0;
        int damage = 0;
        int manaCost = 0;

        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                name = "Snow_Cannon";
                cost = 500;
                requiredLevel = 2;
                damage = 650;
                manaCost = 250;
            } else if (i == 1) {
                name = "Ice_Blade";
                cost = 250;
                requiredLevel = 1;
                damage = 450;
                manaCost = 100;
            } else if (i == 2) {
                name = "Frost_Blizzard";
                cost = 750;
                requiredLevel = 5;
                damage = 850;
                manaCost = 350;
            } else if (i == 3) {
                name = "Arctic_Storm";
                cost = 700;
                requiredLevel = 6;
                damage = 800;
                manaCost = 300;
            }

            Spell iceSpell = new Spell(name, cost, requiredLevel, damage, manaCost);
            readHandler.listOfIceSpells.add(iceSpell);
        }
    }

    public static void loadDragonsManually() {
        String name = null;
        int level = 0;
        int damage = 0;
        int defense = 0;
        int dodgeChance = 0;
        // hp = lvl * 100
        for (int i = 0; i < 12; i++) {
            switch (i) {
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
