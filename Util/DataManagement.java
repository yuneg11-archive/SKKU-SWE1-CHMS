import java.util.ArrayList;
import java.util.Scanner;


import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

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
        
        int type;
        System.out.println("===============INSERT===============");
        System.out.println("-Type");
        System.out.println("1. CPU    2. Mainboard   3. Memory");
        System.out.println("4. Graphic Card    5. Power Supply");
        System.out.println("6. SSD    7. HDD         8. Case");
        System.out.println("9. Expansion Card");
        do {
            System.out.print(" Select: ");
            type = s.nextInt();
            if(type >= 1 && type <= 9) break;
            else System.out.println("Invalid number");
        } while(true);
        
        
        switch(type) {
    	case 1://CPU
    		System.out.println("===============CPU===============");
    		CPU cpu = new CPU();
    		cpu.insert();
    		products.add(cpu);
    		break;
    	case 2://Mainboard
    		System.out.println("===============Mainboard===============");
    		Mainboard mb = new Mainboard();
    		mb.insert();
    		products.add(mb);
    		break;
    	case 3://Memory
    		System.out.println("===============Memory===============");
    		Memory mem = new Memory();
    		mem.insert();
    		products.add(mem);
    		break;
    	case 4://Graphic Card
    		System.out.println("===============Graphic Card===============");
    		GraphicCard graphic = new GraphicCard();
    		graphic.insert();
    		products.add(graphic);
    		break;
    	case 5://Power Supply
    		System.out.println("===============Power Supply===============");
    		PowerSupply ps = new PowerSupply();
    		ps.insert();
    		products.add(ps);
    		break;
    	case 6://SSD
    		System.out.println("===============SSD===============");
    		SSD ssd = new SSD();
    		ssd.insert();
    		products.add(ssd);
    		break;
    	case 7://HDD
    		System.out.println("===============HDD===============");
    		HDD hdd = new HDD();
    		hdd.insert();
    		products.add(hdd);
    		break;
    	case 8://Case
    		System.out.println("===============Case===============");
    		Case c = new Case();
    		c.insert();
    		products.add(c);
    		break;
    	case 9://Expansion Card
    		System.out.println("===============Expansion Card===============");
    		ExpansionCard expc = new ExpansionCard();
    		expc.insert();
    		products.add(expc);
    		break;
    	}        
        
        s.close();
    }
}