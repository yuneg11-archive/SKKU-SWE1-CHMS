import java.util.Scanner;

abstract class Processor extends Product {
    protected Long coreNumber;
    protected Double clockRate; // Unit: GHz
    protected Long fabrication; // Unit: nm
    protected Long tdp; // Unit: W
    
    @Override
    public void insert() {
    	super.insert();
    	
    	Scanner s = new Scanner(System.in);
    	
    	System.out.print(" CoreNumber: ");
		this.coreNumber = s.nextLong();
		
		System.out.print(" ClockRate (GHz): ");
		this.clockRate = s.nextDouble();
		
		System.out.print(" Fabrication (nm): ");
		this.fabrication = s.nextLong();
		
		System.out.print(" TDP (W): ");
		this.tdp = s.nextLong();
		s.nextLine();		
	}
}