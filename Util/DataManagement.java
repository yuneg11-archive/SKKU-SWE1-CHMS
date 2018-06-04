import java.util.ArrayList;
import java.util.Scanner;


import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

class DataManagement {
    ArrayList<ProductLongPair> products;

    DataManagement(ArrayList<ProductLongPair> products) {
        this.products = products;
    }

    ArrayList<ProductLongPair> getProducts() {
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
        
		Long quantity;
        switch(type) {
    	case 1://CPU
    		System.out.println("===============CPU===============");
    		CPU cpu = new CPU();
			cpu.insert();
			System.out.print(" Quantity: ");
			quantity = s.nextLong();	
    		products.add(new ProductLongPair(cpu, quantity));
    		break;
    	case 2://Mainboard
    		System.out.println("===============Mainboard===============");
    		Mainboard mb = new Mainboard();
			mb.insert();
			System.out.print(" Quantity: ");
			quantity = s.nextLong();
    		products.add(new ProductLongPair(mb, quantity));
    		break;
    	case 3://Memory
    		System.out.println("===============Memory===============");
    		Memory mem = new Memory();
			mem.insert();
			System.out.print(" Quantity: ");
			quantity = s.nextLong();
    		products.add(new ProductLongPair(mem, quantity));
    		break;
    	case 4://Graphic Card
    		System.out.println("===============Graphic Card===============");
    		GraphicCard graphic = new GraphicCard();
			graphic.insert();
			System.out.print(" Quantity: ");
			quantity = s.nextLong();
    		products.add(new ProductLongPair(graphic, quantity));
    		break;
    	case 5://Power Supply
    		System.out.println("===============Power Supply===============");
    		PowerSupply ps = new PowerSupply();
			ps.insert();
			System.out.print(" Quantity: ");
			quantity = s.nextLong();
    		products.add(new ProductLongPair(ps, quantity));
    		break;
    	case 6://SSD
    		System.out.println("===============SSD===============");
    		SSD ssd = new SSD();
			ssd.insert();
			System.out.print(" Quantity: ");
			quantity = s.nextLong();
    		products.add(new ProductLongPair(ssd, quantity));
    		break;
    	case 7://HDD
    		System.out.println("===============HDD===============");
    		HDD hdd = new HDD();
			hdd.insert();
			System.out.print(" Quantity: ");
			quantity = s.nextLong();
    		products.add(new ProductLongPair(hdd, quantity));
    		break;
    	case 8://Case
    		System.out.println("===============Case===============");
    		Case c = new Case();
			c.insert();
			System.out.print(" Quantity: ");
			quantity = s.nextLong();
    		products.add(new ProductLongPair(c, quantity));
    		break;
    	case 9://Expansion Card
    		System.out.println("===============Expansion Card===============");
    		ExpansionCard expc = new ExpansionCard();
			expc.insert();
			System.out.print(" Quantity: ");
			quantity = s.nextLong();
    		products.add(new ProductLongPair(expc, quantity));
			break;
		}
        s.close();
	}

	ArrayList<Integer> searchProductCondition(String conditions) {
		/* conditions : {"Condition":[{"Mode":"Exist", "Attribute":"Price"}]} */
		/* conditions : {"Condition":[{"Mode":"Match", "Attribute":"Name", "Value":"i5"}]} */
		/* conditions : {"Condition":[{"Mode":"Range", "Attribute":"Price", "LowerBound":10000, "UpperBound":50000}]} */
		ArrayList<Integer> productIndex = new ArrayList<>();
		for(int i = 0; i < this.products.size(); i++) {
			productIndex.add(i);
		}
		try {
			JSONObject obj = (JSONObject)(new JSONParser().parse(conditions));
			JSONArray conditionArray = (JSONArray)obj.get("Condition");
			for(Object conditionObj : conditionArray) {
				JSONObject condition = (JSONObject)conditionObj;
				for(int i = productIndex.size()-1; i >= 0; i--) {
					JSONObject require = new JSONObject();
					JSONArray key = new JSONArray();
					key.add((String)condition.get("Attribute"));
					require.put("Keys", key);
					String attribute = products.get(productIndex.get(i)).product.getAttribute(require.toJSONString());
					JSONObject result = (JSONObject)(new JSONParser().parse(attribute));
					Object value = result.get((String)condition.get("Attribute"));

					if(value == null) { // Attribute doesn't exist in target product
						productIndex.remove(productIndex.get(i));
					}

					if(((String)condition.get("Mode")).equals("Match")) {
						if(!value.toString().equals(condition.get("Value").toString())) {
							productIndex.remove(productIndex.get(i));
						}
					} else if(((String)condition.get("Mode")).equals("Range")) {
						Double doubleValue = Double.parseDouble(value.toString());
						Double lowerBound = Double.parseDouble(condition.get("LowerBound").toString());
						Double upperBound = Double.parseDouble(condition.get("UpperBound").toString());
						if(doubleValue < lowerBound || doubleValue > upperBound) {
							productIndex.remove(productIndex.get(i));
						}
					}
				}
			}
			return productIndex;
    	} catch(Exception exc) {
			System.out.println("Unexpected error occurred");
			return null;
    	}
	}
}