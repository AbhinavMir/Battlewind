import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class readHandler {

    private static final Logger logger = Logger.getLogger(readHandler.class.getName());
    static ArrayList<Hero> listOfPaladins = new ArrayList<>(); // heroes
    static ArrayList<Hero> listOfSorcerers = new ArrayList<>(); // heroes
    static ArrayList<Hero> listOfWarriors = new ArrayList<>(); // heroes
    String armory = "Name/cost/required level/damage reduction";
    String monster = "Name/level/damage/defense/dodge chance";
    String hero = "Name/mana/strength/agility/dexterity/starting money/starting experience";
    ArrayList<Monster> listOfMonsters = new ArrayList<>(); // monsters
    ArrayList<Spell> listOfSpells = new ArrayList<>(); // spells
    ArrayList<itemBaseClass.Potion> listOfPotions = new ArrayList<>(); // potions
    ArrayList<itemBaseClass.Weapon> listOfWeapons = new ArrayList<>(); // weapons
    ArrayList<itemBaseClass.Armor> listOfArmors = new ArrayList<>();    // armors

    public static void readHeroes(String heroData, Hero.heroType type) {
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
            // String name, int mana, int strength, int agility,
            // int dexterity, int startingMoney, int startingExperience, heroType type,
            // int level, int exp, int hp, int baseDamage

            Hero hero = new Hero(name, mana, strength, agility, dexterity, startingMoney, startingExp, type);

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

    public static void printHeroes(Hero.heroType type) {
        // print keys
        System.out.println("Name | mana | strength | agility | dexterity | starting money | starting experience");
        if (type == Hero.heroType.PALADIN) {
            for (Hero hero : listOfPaladins) {
                System.out.println(hero.getName() + " | " + hero.getMana() + " | " + hero.getStrength() + " | " + hero.getAgility() + " | " + hero.getDexterity() + " | " + hero.getStartingMoney() + " | " + hero.getStartingExperience());
            }
        } else if (type == Hero.heroType.SORCERER) {
            for (Hero hero : listOfSorcerers) {
                System.out.println(hero.getName() + " | " + hero.getMana() + " | " + hero.getStrength() + " | " + hero.getAgility() + " | " + hero.getDexterity() + " | " + hero.getStartingMoney() + " | " + hero.getStartingExperience());
            }
        } else if (type == Hero.heroType.WARRIOR) {
            for (Hero hero : listOfWarriors) {
                System.out.println(hero.getName() + " | " + hero.getMana() + " | " + hero.getStrength() + " | " + hero.getAgility() + " | " + hero.getDexterity() + " | " + hero.getStartingMoney() + " | " + hero.getStartingExperience());
            }
        }
    }

    public static Hero getHero(String chosenHero, int index) {
        // string to enum
        Hero.heroType type = Hero.heroType.valueOf(chosenHero.toUpperCase());
        if (type == Hero.heroType.PALADIN) {
            return listOfPaladins.get(index);
        } else if (type == Hero.heroType.SORCERER) {
            return listOfSorcerers.get(index);
        } else if (type == Hero.heroType.WARRIOR) {
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
        String[] x = getAllFiles("gameUtils/");
        String paladins = readThisFiles("gameUtils/", "Paladins");
        String sorcerers = readThisFiles("gameUtils/", "Sorcerers");
        String warriors = readThisFiles("gameUtils/", "Warriors");
        readHeroes(paladins, Hero.heroType.PALADIN);
        readHeroes(sorcerers, Hero.heroType.SORCERER);
        readHeroes(warriors, Hero.heroType.WARRIOR);
    }
}
