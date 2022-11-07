import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.logging.Logger;

public class readHandler {
    // logger
    private static final Logger logger = Logger.getLogger(readHandler.class.getName());

    /*
    There are four types of files that can be read:
    1. Moves, which are the moves that the player can make
    2. Items, which are the items that the player can use
    3. Monsters, which are the monsters that the player can fight
    4. Heroes, which are the heroes that the player can play as
     */

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

    public static String parseKeyData(String data) {
        String tempData = "";
        while (data.contains(" ")) {
            tempData = data.substring(0, data.indexOf(" "));
            break;
        }

        return tempData;
    }

    public static String removeKeysFromString(String keys, String data)
    {
        // remove keys string from data
        data = data.replace(keys, "");
        // remove first element
        //data = data.substring(1);
        return data;
    }

    public static void main(String[] args) {
        String path = "gameUtils/";
        String[] allFiles = getAllFiles(path);
        String[] fileRead = new String[allFiles.length];

        for (int i = 0; i < allFiles.length; i++) {
            fileRead[i] = readThisFiles(path, allFiles[i]);
            // System.out.println(fileRead[i]);
        }

        String someString = parseKeyData(fileRead[0]);
        System.out.println(removeKeysFromString(someString, fileRead[0]));

      }
}
