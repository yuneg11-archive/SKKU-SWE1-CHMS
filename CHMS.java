import java.util.Scanner;
import java.util.ArrayList;

public class CHMS {
    private static final String databaseFileName = "database.txt";

    public static void main(String[] args) {
        FileManagement fm = new FileManagement(databaseFileName);
        DataManagement dm = new DataManagement(fm.loadDatabase());
        Scanner input = new Scanner(System.in);
        // Demo output
        //System.out.println(dm.getProducts().get(0).toJSONObject().toJSONString());
        //System.out.println(dm.getProducts().get(1).toJSONObject().toJSONString());
        //System.out.println(dm.getProducts().get(1).getAttribute("{\"Keys\":[\"Price\",\"ProductType\"]}"));
        //System.out.println(dm.getProducts().get(2).toJSONObject().toJSONString());
        /* Do What You Want */

        ArrayList<Integer> list = dm.searchProductCondition("{\"Condition\":[{\"Mode\":\"Range\", \"Attribute\":\"CoreNumber\", \"LowerBound\":2, \"UpperBound\":3}]}");
        System.out.println(list.toString());
        
        while(true) {
        	int function;
        	System.out.println("===============MAIN MENU===============");
        	System.out.println("-Functions");
        	System.out.println("1. Insert\t2. Modify\t3. Delete");
        	System.out.println("4. Search\t5. Sort \t6. Cost Estimation");
        	while(true) {
                System.out.print(" Select: ");
                function = input.nextInt();
                if(function >= 1 && function <= 6) break;
                else System.out.println("Invalid number");
            } 
        	switch(function) {
        	case 1://Insert
        		dm.insert();
        		break;
        	case 2://Modify
        		break;
        	case 3://Delete
        		break;
        	case 4://Search
        		break;
        	case 5://Sort
        		break;
        	case 6://Cost Estimation
        		break;
        	}
        	break; //for debugging
        }
        
        
        System.out.println("Program over");
        fm.saveDatabase(dm.getProducts());
        input.close();
    }
}