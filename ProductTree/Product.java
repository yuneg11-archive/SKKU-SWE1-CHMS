import JSON.JSONObject;
import java.util.Scanner;

abstract class Product {
    // Variable
    protected String name;
    protected Long price;
    protected String manufacturer;

    // Setter & Getter
    public abstract String getProductType();
    public abstract void setAttribute(String attributes);
    public abstract String getAttribute(String keys);
    public abstract JSONObject toJSONObject();
    
    public void insert() {
    	Scanner s = new Scanner(System.in);
    	
    	System.out.print(" Name: (Name is unique)");
		this.name = s.nextLine();
		
		System.out.print(" Price (Won, 0 if imbedded): ");
		this.price = s.nextLong();
		s.nextLine();
		
		System.out.print(" Manufacturer: ");
		this.manufacturer = s.nextLine();	
    }
    
}