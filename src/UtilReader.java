import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class UtilReader {
    /*
    Name/cost/required level/damage reduction
    Platinum_Shield       150   1   200
    Breastplate           350   3   600
    Full_Body_Armor       1000  8   1100
    Wizard_Shield         1200  10  1500
    Guardian_Angel        1000  10  1000
     */

    static String allDir;

    // read all files in gameUtils folder and append it to dataDump
    public static void getAllFiles() {
        allDir = "";
        File folder = new File("gameUtils");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                allDir += file.getName().substring(0, file.getName().length() - 4) + "\n ";
            }
        }
    }

    // write a method to read all files into respective String created from getAllFiles()
    public static String readThisFiles(String fileName) {
        String dataDump = "";
        try {
            File myObj = new File("gameUtils/" + fileName + ".txt");
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
        getAllFiles();
        System.out.println(allDir);
    }
}
