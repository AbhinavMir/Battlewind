import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

class CSVreader
{
    public static ArrayList<String[]> readCSV(String pathdir) {
        ArrayList<String[]> data = new ArrayList<String[]>();
        try {
            File myObj = new File(pathdir);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String dataLine = myReader.nextLine();
                String[] dataLineArray = dataLine.split(",");
                data.add(dataLineArray);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static void writeToCSV(String pathdir, String[][] data) {
       // write a CSV file as needed

    }

    public static void main(String[] args) {
        ArrayList<String[]> data = readCSV("db.csv");
        for (String[] line : data) {
            for (String word : line) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}