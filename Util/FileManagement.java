import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import JSON.JSONObject;
import JSON.parser.JSONParser;
import JSON.parser.ParseException;

class FileManagement {
    private String databaseFileName;

    FileManagement(String databaseFileName) {
        this.databaseFileName = databaseFileName;
    }

    // Load Database 
    ArrayList<Product> loadDatabase() {
        ArrayList<Product> products = new ArrayList<Product>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(databaseFileName));
            String line = br.readLine();
            while(line != null) {
                /*Debug*///System.out.println(line);
                products.add(StringtoProduct(line));
                line = br.readLine();
            }
            br.close();
            return products;
        } catch(FileNotFoundException ex) {
            File file = new File(databaseFileName);
            try {
                FileWriter writer = new FileWriter(file);
                writer.write("");
                writer.flush();
                writer.close();
            } catch(IOException e) {
                System.out.println("Unexpected error occurred");
            }
            /*Debug*/System.out.println("Database not exist. Opening new database.");
            return null;
        } catch(Exception ex) {
            System.out.println("Unexpected error occurred");
        }
        return products;
    }

    // Save Database
    boolean saveDatabase(ArrayList<Product> products) {
        /*try {
            //!!!! File Write
            return true;
        } catch(IOException ex) {
            return false;
        }*/
        return false;//temp
    }

    Product StringtoProduct(String str) throws Exception {
    	JSONObject obj = (JSONObject)(new JSONParser().parse(str));
        String productType = (String)obj.get("ProductType");
        obj.remove("ProductType");
        
        Product product;
        switch(productType) {
        	case "Case": 			product = new Case(obj.toJSONString()); break;
        	case "CPU": 			product = new CPU(obj.toJSONString()); break;
        	case "ExpansionCard": 	product = new ExpansionCard(obj.toJSONString()); break;
        	case "GraphicCard": 	product = new GraphicCard(obj.toJSONString()); break;
        	case "HDD": 			product = new HDD(obj.toJSONString()); break;
        	case "ImbeddedGraphic": product = new ImbeddedGraphic(obj.toJSONString()); break;
        	case "Mainboard": 		product = new Mainboard(obj.toJSONString()); break;
        	case "Memory": 			product = new Memory(obj.toJSONString()); break;
        	case "PowerSupply": 	product = new PowerSupply(obj.toJSONString()); break;
        	case "SSD": 			product = new SSD(obj.toJSONString()); break;
        	default: 				product = null;
        }
        return product;
    }
}