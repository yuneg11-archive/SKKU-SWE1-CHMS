import java.util.ArrayList;
import java.util.Scanner;

class DataManagement {
    ArrayList<Product> products;

    DataManagement(ArrayList<Product> products) {
        this.products = products;
    }

    ArrayList<Product> getProducts() {
        return products;
    }

    void insert() {
        Scanner s = new Scanner(System.in);
        System.out.println("===============INSERT===============");
        System.out.println("-Type");
        System.out.println(" 1. CPU    2. Mainboard   3. Memory");
        System.out.println(" 4. Graphic Card    5. Power Supply");
        System.out.println(" 6. SSD    7. HDD         8. Case");
        System.out.println(" 9. Expansion Card");
        do {
            System.out.print(" Select: ");
            int type = s.nextInt();
            if(type >= 1 && type <= 9) break;
            else System.out.println("Invalid number");
        } while(true);
        // Do more
    }
}