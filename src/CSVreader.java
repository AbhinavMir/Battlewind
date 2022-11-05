import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class CSVreader
{
    // write a method to read CSV files using the "," delimiter and return a 2D array
    public static String[][] readCSV(String pathdir) {
        String[][] dataDump = new String[100][100];
        try {
            File myObj = new File(pathdir);
            Scanner myReader = new Scanner(myObj);
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                dataDump[i] = data.split(",");
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return dataDump;
    }

    public static void writeToCSV(String pathdir, String[][] data) {
       // write a CSV file as needed

    }

    public static void main(String[] args) {
        String[][] dataDump = readCSV("db.csv");
        for (int i = 0; i < dataDump.length-1; i++) {
            for (int j = 0; j < dataDump[i].length; j++) {
                System.out.print(dataDump[i][j] + " ");
            }
            System.out.println();
        }
    }
}