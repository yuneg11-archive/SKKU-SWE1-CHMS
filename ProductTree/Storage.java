import java.util.Scanner;

abstract class Storage extends Product {
    protected Long capacity; // Unit: GB
    protected Long readSpeed; // Unit: MB/s
    protected Long writeSpeed; // Unit: MB/s
    protected String slot;
    
    @Override
    public void insert() {
    	super.insert();
    	
    	Scanner s = new Scanner(System.in);    	

		System.out.print(" Capacity (GB): ");
		this.capacity = s.nextLong();
		
		System.out.print(" Read Speed (Mb/s): ");
		this.readSpeed = s.nextLong();
		
		System.out.print(" Write Speed (Mb/s): ");
		this.writeSpeed = s.nextLong();
		s.nextLine();
		
		System.out.print(" Slot: ");
		this.slot = s.nextLine();
		
	}
}