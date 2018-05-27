import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

class DataManagement {
    ArrayList<Product> products;

    DataManagement(ArrayList<Product> products) {
        this.products = products;
    }

    ArrayList<Product> getProducts() {
        return products;
    }
}