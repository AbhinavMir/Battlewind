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

    ArrayList<Hero> listOfPaladins = new ArrayList<>();
    ArrayList<Hero> listOfSorcerers = new ArrayList<>();
    ArrayList<Hero> listOfWarriors = new ArrayList<>();
    ArrayList<Monster> listOfMonsters = new ArrayList<>();
    ArrayList<Spell> listOfSpells = new ArrayList<>();
    ArrayList<itemBaseClass.Potion> listOfPotions = new ArrayList<>();
    ArrayList<itemBaseClass.Weapon> listOfWeapons = new ArrayList<>();
    ArrayList<itemBaseClass.Armor> listOfArmors = new ArrayList<>();


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
}
