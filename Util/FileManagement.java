import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

class FileManagement {
    private String databaseFileName;

    FileManagement(String databaseFileName) {
        this.databaseFileName = databaseFileName;
    }

    // Load Database 
    ArrayList<Product> loadDatabase() {
        ArrayList<Product> products;
        try {
            BufferedReader br = new BufferedReader(new FileReader(databaseFileName));
            String line = br.readLine();
            while(line != null) {
                products.add(parseInput(line));
                System.out.println(line);
                line = br.readLine();
            }
            br.close();
            return products;
        } catch(IOException ex) {
            //!!!! File Generate
            return null;
        }
    }

    // Save Database
    boolean saveDatabase(ArrayList<Product> products) {
        try {
            //!!!! File Write
            return true;
        } catch(IOException ex) {
            return false;
        }
    }

    private Product parseInput(String line) {
        //!!!! JSON Parsing
        return new Product(); //Temp
    }
}