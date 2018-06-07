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

class FileManagement {
    private String databaseFileName;

    FileManagement(String databaseFileName) {
        this.databaseFileName = databaseFileName;
    }

    // Load Database 
    public ArrayList<ProductLongPair> loadDatabase() {
        ArrayList<ProductLongPair> products = new ArrayList<ProductLongPair>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(databaseFileName));
            String line = br.readLine();
            while(line != null) {
                /*Debug*///System.out.println(line);
                products.add(stringToProductQuantity(line));
                line = br.readLine();
            }
            br.close();
            System.out.println(UI.prompt("Database loaded."));
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
            System.out.println(UI.prompt("Database not exist. Opening new database."));
            return null;
        } catch(Exception ex) {
            System.out.println("Unexpected error occurred");
        }
        return products;
    }

    // Save Database
    public void saveDatabase(ArrayList<ProductLongPair> products) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(databaseFileName));
            for(ProductLongPair productAndQuantity : products) {
                JSONObject obj = new JSONObject();
                obj.put("Product", productAndQuantity.product.toJSONObject());
                obj.put("Quantity", productAndQuantity.num);
                bw.write(obj.toJSONString());
                bw.newLine();
            }
            bw.close();
        } catch(IOException ex) {
            System.out.println("Unexpected error occurred");
        }
    }

    ProductLongPair stringToProductQuantity(String str) throws Exception {
        JSONObject productAndQuantity = (JSONObject)(new JSONParser().parse(str));
        JSONObject obj = (JSONObject)productAndQuantity.get("Product");
        Long quantity = (Long)productAndQuantity.get("Quantity");
        String productType = (String)obj.get("ProductType");
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
        return new ProductLongPair(product, quantity);
    }
}