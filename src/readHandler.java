import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class readWriteHandler {
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

    public static HashMap<String, String> commaSep(String toConvert) {
        toConvert = toConvert.replaceAll("\\s+", ", ");
        System.out.println(toConvert);
        HashMap<String, String> data = new HashMap<String, String>();
        return data;
    }

    public static void main(String[] args) {
        String[] allDirs = getAllFiles("gameUtils/");
        // read first file from allDirs
        System.out.println(allDirs[0]);
        String dataDump = readThisFiles("gameUtils/", allDirs[0]);
        HashMap<String, String> data = commaSep(dataDump);
        System.out.println(data);
    }
}
