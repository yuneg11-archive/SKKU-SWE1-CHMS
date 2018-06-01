import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class FileManagement {
    private String databaseFileName;

    FileManagement(String databaseFileName) {
        this.databaseFileName = databaseFileName;
    }

    // Load Database 
    ArrayList<Product> loadDatabase() {
        ArrayList<Product> products;
        JSONParser parser = new JSONParser();
        try {
            BufferedReader br = new BufferedReader(new FileReader(databaseFileName));
            String line = br.readLine();
            while(line != null) {
                JSONObject obj = (JSONObject)parser.parse(line);
                /*Debug*/System.out.println(line);
                products.add(JSONtoProduct(obj));
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

    Product JSONtoProduct(JSONObject json) {

    }
}