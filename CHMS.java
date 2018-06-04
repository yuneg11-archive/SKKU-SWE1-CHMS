import java.util.ArrayList;

public class CHMS {
    private static final String databaseFileName = "database.txt";

    public static void main(String[] args) {
        FileManagement fm = new FileManagement(databaseFileName);
        DataManagement dm = new DataManagement(fm.loadDatabase());
        boolean exit = false;
        
        do {
        	int function = UI.printMain();
        	switch(function) {
        	case 1://Insert
        		dm.insert();
        		break;
        	case 2://Modify
        		dm.modify();
        		break;
            case 3://Delete
                dm.delete();
        		break;
            case 4://Search
                dm.search();
        		break;
        	case 5://Sort
        		break;
        	case 6://Cost Estimation
                break;
            case 7://Exit
                exit = true;
                break;
            }
        	//break; //for debugging
        } while(!exit);
        
        
        System.out.println("Program over");
        fm.saveDatabase(dm.getProducts());
    }
}