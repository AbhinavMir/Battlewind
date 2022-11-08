import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class readHandler {

    private static final Logger logger = Logger.getLogger(readHandler.class.getName());

    String armory = "Name/cost/required level/damage reduction";
    String monster = "Name/level/damage/defense/dodge chance";
    String hero = "Name/mana/strength/agility/dexterity/starting money/starting experience";

    static ArrayList<Hero> listOfPaladins = new ArrayList<>(); // heroes
    static ArrayList<Hero> listOfSorcerers = new ArrayList<>(); // heroes
    static ArrayList<Hero> listOfWarriors = new ArrayList<>(); // heroes
    ArrayList<Monster> listOfMonsters = new ArrayList<>(); // monsters
    ArrayList<Spell> listOfSpells = new ArrayList<>(); // spells
    ArrayList<itemBaseClass.Potion> listOfPotions = new ArrayList<>(); // potions
    ArrayList<itemBaseClass.Weapon> listOfWeapons = new ArrayList<>(); // weapons
    ArrayList<itemBaseClass.Armor> listOfArmors = new ArrayList<>();    // armors

    public static void readHeroes(String heroData, Hero.heroType type)
    {
        /*
        Name/mana/strength/agility/dexterity/starting money/starting experience
        Parzival             300     750     650     700     2500    7
        Sehanine_Moonbow     300     750     700     700     2500    7
        Skoraeus_Stonebones  250     650     600     350     2500    4
        Garl_Glittergold     100     600     500     400     2500    5
        Amaryllis_Astra      500     500     500     500     2500    5
        Caliber_Heist        400     400     400     400     2500    8
         */

        String keys = "Name/mana/strength/agility/dexterity/starting money/starting experience";
        // remove Name/mana/strength/agility/dexterity/starting money/starting experience from heroData using replace
        heroData = heroData.replace(keys, "");
        // remove first element from heroData using replace
        heroData = heroData.replaceFirst(" ", "");
        // turn it into an array, split by space. If multiple spaces, split by multiple spaces
        String[] heroDataArray = heroData.split(" +");
        for (int i = 0; i < heroDataArray.length; i++)
        {
            for (int j = 0; j<6;j++)
            {
                // create a new hero object
                Hero hero = new Hero();
                hero.setName(heroDataArray[i]);
                hero.setMana(Integer.parseInt(heroDataArray[i+1]));
                hero.setStrength(Integer.parseInt(heroDataArray[i+2]));
                hero.setAgility(Integer.parseInt(heroDataArray[i+3]));
                hero.setDexterity(Integer.parseInt(heroDataArray[i+4]));
                hero.setStartingMoney(Integer.parseInt(heroDataArray[i+5]));
                hero.setStartingExperience(Integer.parseInt(heroDataArray[i+6]));
                // add hero to list of heroes
                if(type == Hero.heroType.PALADIN)
                {
                    listOfPaladins.add(hero);
                }
                else if(type == Hero.heroType.SORCERER)
                {
                    listOfSorcerers.add(hero);
                }
                else if(type == Hero.heroType.WARRIOR)
                {
                    listOfWarriors.add(hero);
                }
            }
        }
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

    public static void main(String[] args) {
        String[] x = getAllFiles("gameUtils/");
        String y = readThisFiles("gameUtils/", "Paladins");
        System.out.println(y);
        readHeroes(y);
    }
}
