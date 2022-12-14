import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
These are used to read data from the `txt` files.
They then store it in readHandler class.
If anything fails, it calls `manualHandler`, which then makes ammends.
@NOT: For me, `dragons.txt` failed, so I've called it via manualHandler, but only after trying it with readHandler.
 */

public class readHandler {
    private static final Logger logger = Logger.getLogger(readHandler.class.getName());
    static ArrayList<Characters.Hero> listOfPaladins = new ArrayList<>(); // heroes
    static ArrayList<Characters.Hero> listOfSorcerers = new ArrayList<>(); // heroes
    static ArrayList<Characters.Hero> listOfWarriors = new ArrayList<>(); // heroes
    static ArrayList<Characters.Monster> listOfDragons = new ArrayList<>(); // monsters
    static ArrayList<Characters.Monster> listOfSpirits = new ArrayList<>(); // monsters
    static ArrayList<Characters.Monster> listOfExoskeletons = new ArrayList<>(); // monsters
    static ArrayList<Potion> listOfPotions = new ArrayList<>(); // potions
    static ArrayList<Spell> listOfLightningSpells = new ArrayList<>(); // spells
    static ArrayList<Spell> listOfFireballSpells = new ArrayList<>(); // spells
    static ArrayList<Spell> listOfIceSpells = new ArrayList<>(); // spells
    static ArrayList<Weapon> listOfWeapons = new ArrayList<>(); // weapons
    static ArrayList<Armor> listOfArmors = new ArrayList<>();    // armors
    String armory = "Name/cost/required level/damage reduction";
    String monster = "Name/level/damage/defense/dodge chance";
    String hero = "Name/mana/strength/agility/dexterity/starting money/starting experience";

    public static void printAllPotions() {
        for (Potion potion : listOfPotions) {
            System.out.println(potion.name + PrettyPrint.BLUE + " costs " + potion.cost + PrettyPrint.RESET + " / Required level: " + potion.requiredLevel + " / Attribute affected: " + potion.attributeAffected + " / Amount increase" + potion.attributeIncrease);
        }
    }

    public static void printAllWeapons() {
        for (Weapon weapon : listOfWeapons) {
            System.out.println(weapon.name + PrettyPrint.BLUE + " costs " + weapon.cost + PrettyPrint.RESET + " / Required level: " + weapon.requiredLevel + " / Damage: " + weapon.damage);
        }
    }

    public static void printAllArmors() {
        for (Armor armor : listOfArmors) {
            System.out.println(armor.name + PrettyPrint.BLUE + " costs " + armor.cost + PrettyPrint.RESET + " / Required level: " + armor.requiredLevel + " / Damage reduction: " + armor.damageReduction);
        }
    }

    public static void printAllSpells() {
        System.out.println("Lightning Spells:");
        for (Spell spell : listOfLightningSpells) {
            System.out.println(spell.name + PrettyPrint.BLUE + " costs " + spell.cost + PrettyPrint.RESET + " / Required level: " + spell.requiredLevel + " / Damage: " + spell.damage + " / Mana cost: " + spell.manaCost);
        }
        System.out.println("Fireball Spells:");
        for (Spell spell : listOfFireballSpells) {
            System.out.println(spell.name + PrettyPrint.BLUE + " costs " + spell.cost + PrettyPrint.RESET + " / Required level: " + spell.requiredLevel + " / Damage: " + spell.damage + " / Mana cost: " + spell.manaCost);
        }
        System.out.println("Ice Spells:");
        for (Spell spell : listOfIceSpells) {
            System.out.println(spell.name + PrettyPrint.BLUE + " costs " + spell.cost + PrettyPrint.RESET + " / Required level: " + spell.requiredLevel + " / Damage: " + spell.damage + " / Mana cost: " + spell.manaCost);
        }
    }

    public static void readPotions(String potionData) {
        String keys = "Name/cost/required level/attribute increase/attribute affected";
        potionData = potionData.replace(keys, "");
        potionData = potionData.replaceFirst(" ", "");
        String[] potionDataArray = potionData.split(" +");
        int potionNum = potionDataArray.length / 5;
        for (int i = 0; i < potionNum; i++) {
            String name = potionDataArray[i * 5];
            int cost = Integer.parseInt(potionDataArray[i * 5 + 1]);
            int requiredLevel = Integer.parseInt(potionDataArray[i * 5 + 2]);
            int attributeIncrease = Integer.parseInt(potionDataArray[i * 5 + 3]);
            String attributeAffected = potionDataArray[i * 5 + 4];
            listOfPotions.add(new Potion(name, cost, requiredLevel, attributeIncrease, attributeAffected));
        }
    }

    public static void readWeapons(String weaponData) {
        String keys = "Name/cost/level/damage/required hands";
        weaponData = weaponData.replace(keys, "");
        weaponData = weaponData.replaceFirst(" ", "");
        String[] weaponDataArray = weaponData.split(" +");
        int weaponNum = weaponDataArray.length / 5;
        for (int i = 0; i < weaponNum; i++) {
            String name = weaponDataArray[i * 5];
            int cost = Integer.parseInt(weaponDataArray[i * 5 + 1]);
            int requiredLevel = Integer.parseInt(weaponDataArray[i * 5 + 2]);
            int damage = Integer.parseInt(weaponDataArray[i * 5 + 3]);
            int requiredHands = Integer.parseInt(weaponDataArray[i * 5 + 4]);
            Weapon weapon = new Weapon(name, cost, requiredLevel, damage, requiredHands);
            listOfWeapons.add(weapon);
        }
    }

    public static void readArmors(String armorData) {
        String keys = "Name/cost/required level/damage reduction";
        armorData = armorData.replace(keys, "");
        armorData = armorData.replaceFirst(" ", "");
        String[] armorDataArray = armorData.split(" +");
        int armorNum = armorDataArray.length / 5;
        for (int i = 0; i < armorNum; i++) {
            String name = armorDataArray[i * 4];
            int cost = Integer.parseInt(armorDataArray[i * 4 + 1]);
            int requiredLevel = Integer.parseInt(armorDataArray[i * 4 + 2]);
            int damageReduction = Integer.parseInt(armorDataArray[i * 4 + 3]);
            Armor armor = new Armor(name, cost, requiredLevel, damageReduction);
            listOfArmors.add(armor);
        }
    }

    public static void readHeroes(String heroData, Characters.Hero.heroType type) {
        String keys = "Name/mana/strength/agility/dexterity/starting money/starting experience";
        // remove Name/mana/strength/agility/dexterity/starting money/starting experience from heroData using replace
        heroData = heroData.replace(keys, "");
        // remove first element from heroData using replace
        heroData = heroData.replaceFirst(" ", "");
        // turn it into an array, split by space. If multiple spaces, split by multiple spaces
        String[] heroDataArray = heroData.split(" +");

        int numNames = heroDataArray.length / 7;

        for (int i = 0; i < numNames; i++) {
            String name = heroDataArray[i * 7];
            int mana = Integer.parseInt(heroDataArray[i * 7 + 1]);
            int strength = Integer.parseInt(heroDataArray[i * 7 + 2]);
            int agility = Integer.parseInt(heroDataArray[i * 7 + 3]);
            int dexterity = Integer.parseInt(heroDataArray[i * 7 + 4]);
            int startingMoney = Integer.parseInt(heroDataArray[i * 7 + 5]);
            int startingExp = Integer.parseInt(heroDataArray[i * 7 + 6]);
            Characters.Hero hero = new Characters.Hero(name, mana, strength, agility, dexterity, startingMoney, startingExp, type);

            switch (type) {
                case PALADIN:
                    listOfPaladins.add(hero);
                    break;
                case SORCERER:
                    listOfSorcerers.add(hero);
                    break;
                case WARRIOR:
                    listOfWarriors.add(hero);
                    break;
            }
        }
    }

    public static void readMonsters(String monsterData, Characters.Monster.monsterType type) {
        String keys = "Name/level/damage/defense/dodge chance";
        // remove Name/level/damage/defense/dodge chance from monsterData using replace
        monsterData = monsterData.replace(keys, "");
        // remove first element from monsterData using replace
        monsterData = monsterData.replaceFirst(" ", "");
        // turn it into an array, split by space. If multiple spaces, split by multiple spaces
        String[] monsterDataArray = monsterData.split(" +");

        int numNames = monsterDataArray.length / 5;

        for (int i = 0; i < numNames; i++) {
            // String name, int level, int damage, int exp, int hp, int baseDamage, int dodgeChance
            String name = monsterDataArray[i * 5];
            int level = Integer.parseInt(monsterDataArray[i * 5 + 1]);
            int damage = Integer.parseInt(monsterDataArray[i * 5 + 2]);
            int defense = Integer.parseInt(monsterDataArray[i * 5 + 3]);
            int dodgeChance = Integer.parseInt(monsterDataArray[i * 5 + 4]);
            int hp = level * 100;
            int baseDamage = damage;
            Characters.Monster monster = new Characters.Monster(name, level, damage, defense, dodgeChance, hp, baseDamage);
            if (type == Characters.Monster.monsterType.DRAGON) {
                listOfDragons.add(monster);
            } else if (type == Characters.Monster.monsterType.EXOSKELETON) {
                listOfExoskeletons.add(monster);
            } else if (type == Characters.Monster.monsterType.SPIRIT) {
                listOfSpirits.add(monster);
            }
        }
    }

    public static void readSpells(String spellData) {
        // Errors out, using manual input
    }

    public static void printHeroes(Characters.Hero.heroType type) {
        // print keys
        System.out.println("Name | mana | strength | agility | dexterity | starting money | starting experience");
        logger.info("Here we reached the printHeroes method");
        if (type == Characters.Hero.heroType.PALADIN) {
            logger.info("Here we reached the printHeroes method for paladins");
            for (Characters.Hero hero : listOfPaladins) {
                System.out.println(hero.getName() + " | " + hero.getMana() + " | " + hero.getStrength() + " | " + hero.getAgility() + " | " + hero.getDexterity() + " | " + hero.getStartingMoney() + " | " + hero.getStartingExperience());
            }
        } else if (type == Characters.Hero.heroType.SORCERER) {
            for (Characters.Hero hero : listOfSorcerers) {
                System.out.println(hero.getName() + " | " + hero.getMana() + " | " + hero.getStrength() + " | " + hero.getAgility() + " | " + hero.getDexterity() + " | " + hero.getStartingMoney() + " | " + hero.getStartingExperience());
            }
        } else if (type == Characters.Hero.heroType.WARRIOR) {
            for (Characters.Hero hero : listOfWarriors) {
                System.out.println(hero.getName() + " | " + hero.getMana() + " | " + hero.getStrength() + " | " + hero.getAgility() + " | " + hero.getDexterity() + " | " + hero.getStartingMoney() + " | " + hero.getStartingExperience());
            }
        }
    }

    public static void printMonster(Characters.Monster monster) {
        System.out.println(monster.getName() + " | " + monster.getLevel() + " | " + monster.getDamage() + " | " + monster.getDefense() + " | " + monster.getDodgeChance());
    }

    public static Characters.Hero getHero(String chosenHero, int index) {
        // string to enum
        Characters.Hero.heroType type = Characters.Hero.heroType.valueOf(chosenHero.toUpperCase());
        if (type == Characters.Hero.heroType.PALADIN) {
            return listOfPaladins.get(index);
        } else if (type == Characters.Hero.heroType.SORCERER) {
            return listOfSorcerers.get(index);
        } else if (type == Characters.Hero.heroType.WARRIOR) {
            return listOfWarriors.get(index);
        }

        return null;
    }

    public static String[] getAllFiles(String path) {
        String[] allDirs;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        allDirs = new String[listOfFiles.length];
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                allDirs[i] = listOfFiles[i].getName().substring(0, listOfFiles[i].getName().length() - 4);
            }
        }
        return allDirs;
    }

    public static String readThisFiles(String path, String fileName) {
        String dataDump = "";
        try {
            File myObj = new File(path + fileName + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                dataDump += data + " ";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return dataDump;
    }

    public static void init() {
        System.out.println("Loading data, please wait...");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // String[] x = getAllFiles("gameUtils/"); // Usually I'd use this to map , but was a bit lazy
        String paladins = readThisFiles("gameUtils/", "Paladins");
        String sorcerers = readThisFiles("gameUtils/", "Sorcerers");
        String warriors = readThisFiles("gameUtils/", "Warriors");
        String spirits = readThisFiles("gameUtils/", "Spirits");
        String exoskeletons = readThisFiles("gameUtils/", "Exoskeletons");
        String dragons = readThisFiles("gameUtils/", "Dragons");
        String potions = readThisFiles("gameUtils/", "Potions");
        String lightningSpells = readThisFiles("gameUtils/", "LightningSpells");
        String fireSpells = readThisFiles("gameUtils/", "FireSpells");
        String iceSpells = readThisFiles("gameUtils/", "IceSpells");
        String weapons = readThisFiles("gameUtils/", "Weaponry");
        String armors = readThisFiles("gameUtils/", "Armory");
        readHeroes(paladins, Characters.Hero.heroType.PALADIN);
        readHeroes(sorcerers, Characters.Hero.heroType.SORCERER);
        readHeroes(warriors, Characters.Hero.heroType.WARRIOR);
        readMonsters(spirits, Characters.Monster.monsterType.SPIRIT);
        readMonsters(exoskeletons, Characters.Monster.monsterType.EXOSKELETON);
        ManualHandler.loadDragonsManually();
        ManualHandler.loadLightningSpellManually();
        ManualHandler.loadFireSpells();
        ManualHandler.loadIceSpellsManually();
        ManualHandler.loadPotionsManually();
        ManualHandler.loadWeaponsManually();
        readArmors(armors);
    }

    public static ArrayList<Characters.Hero> getListOfPaladins() {
        return listOfPaladins;
    }

    public static ArrayList<Characters.Monster> getAllMonsters() {
        ArrayList<Characters.Monster> allMonsters = new ArrayList<>();
        allMonsters.addAll(listOfDragons);
        allMonsters.addAll(listOfExoskeletons);
        allMonsters.addAll(listOfSpirits);
        return allMonsters;
    }

    public static ArrayList<Characters.Hero> getListOfSorcerers() {
        return listOfSorcerers;
    }

    public static ArrayList<Characters.Hero> getListOfWarriors() {
        return listOfWarriors;
    }

    public static ArrayList<Characters.Monster> getListOfDragons() {
        return listOfDragons;
    }

    public static ArrayList<Characters.Monster> getListOfSpirits() {
        return listOfSpirits;
    }

    public static ArrayList<Characters.Monster> getListOfExoskeletons() {
        return listOfExoskeletons;
    }

    public static ArrayList<Potion> getListOfPotions() {
        return listOfPotions;
    }

    public static ArrayList<Spell> getListOfLightningSpells() {
        return listOfLightningSpells;
    }

    public static ArrayList<Spell> getListOfFireballSpells() {
        return listOfFireballSpells;
    }

    public static ArrayList<Spell> getListOfIceSpells() {
        return listOfIceSpells;
    }

    public static ArrayList<Weapon> getListOfWeapons() {
        return listOfWeapons;
    }

    public static ArrayList<Armor> getListOfArmors() {
        return listOfArmors;
    }
}
