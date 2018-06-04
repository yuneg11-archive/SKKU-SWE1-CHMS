import JSON.JSONObject;
import java.util.Scanner;

abstract class Product {
    // Variable
    protected String name;
    protected Long price;
    protected String manufacturer;
    protected Long quantity;

    // Setter & Getter
    public abstract String getProductType();
    public abstract void setAttribute(String attributes);
    public abstract String getAttribute(String keys);
    public abstract JSONObject toJSONObject();
    
    public void insert() {
    	Scanner s = new Scanner(System.in);
    	
    	System.out.print(" Name: ");
		this.name = s.nextLine();
		
		System.out.print(" Price (Won): ");
		this.price = s.nextLong();
		s.nextLine();
		
		System.out.print(" Manufacturer: ");
		this.manufacturer = s.nextLine();
		
		System.out.print(" Quantity: ");
		this.quantity = s.nextLong();		
    }
    
}