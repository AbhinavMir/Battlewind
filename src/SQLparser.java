public class SQLparser {

    // write a simple simple query language for CSV (minimal)

    // write a method to parse a query string and return a 2D array of results
    public static String[] tokenizeQuery(String query) {
        String[] tokens = query.split(" ");
        return tokens;
    }

    public static String[][] parseQuery(String query) {
        String[] tokens = tokenizeQuery(query);
        String[][] results = new String[0][0];
        for(int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("SELECT")) {
                String[] columns = tokens[i + 1].split(",");
                results = new String[CSVreader.readCSV("db.csv").size()][columns.length];
                for (int j = 0; j < CSVreader.readCSV("db.csv").size(); j++) {
                    for (int k = 0; k < columns.length; k++) {
                        results[j][k] = CSVreader.readCSV("db.csv").get(j)[Integer.parseInt(columns[k])];
                    }
                }
            }
        }
    }
}
