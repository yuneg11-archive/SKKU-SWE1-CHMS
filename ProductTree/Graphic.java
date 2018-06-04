import java.util.Scanner;

abstract class Graphic extends Processor {
    protected String chipset;
    protected Memory memory;
    
    @Override
    public void insert() {
    	super.insert();
    	
    	Scanner s = new Scanner(System.in);    	

		System.out.print(" Chipset: ");
		this.chipset = s.nextLine();
		
		System.out.println("===============Graphic Memory===============");
		Memory mem = new Memory();
		mem.insert();
		this.memory = mem;
		
	}
}