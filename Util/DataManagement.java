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
    	JSONObject obj = new JSONObject();
        Scanner s = new Scanner(System.in);
        
        int type;
        System.out.println("===============INSERT===============");
        System.out.println("-Type");
        System.out.println("1. CPU \t2. Mainboard \t3. Memory");
        System.out.println("4. Graphic Card \t5. Power Supply");
        System.out.println("6. SSD \t7. HDD \t\t8. Case");
        System.out.println("9. Expansion Card");
        do {
            System.out.print(" Select: ");
            type = s.nextInt();
            if(type >= 1 && type <= 9) break;
            else System.out.println("Invalid number");
        } while(true);
        
		Long quantity;
		ArrayList<Integer> searched= new ArrayList<Integer>();
        switch(type) {
    	case 1://CPU
    		System.out.println("===============CPU===============");
    		CPU cpu = new CPU();
			cpu.insert();
			// Search if product with this name cpu.toJSONObject().get("Name") exists;
			// for all arraylist searched, check if any 
			// products.get(searched).product.toJSONObject().get(Str.producttype) is CPU
			// if exists, products.get(searched).long+=s.nextLong(); then break
			// if nothing happens, we need to add product
			obj.put("Mode", "Match");
			obj.put("Attribute", "Name");
			obj.put("Value", cpu.toJSONObject().get("Name"));
			searched = searchProductCondition(obj.toJSONString());
			System.out.print(" Quantity: ");
			quantity = s.nextLong();
			if(searched.size() == 0)	//new product
				products.add(new ProductLongPair(cpu, quantity));
			else						//existing product
				products.get(searched.get(0)).num += s.nextLong();
			break;
    	case 2://Mainboard
    		System.out.println("===============Mainboard===============");
    		Mainboard mb = new Mainboard();
			mb.insert();
			obj.put("Mode", "Match");
			obj.put("Attribute", "Name");
			obj.put("Value", mb.toJSONObject().get("Name"));
			searched = searchProductCondition(obj.toJSONString());
			System.out.print(" Quantity: ");
			quantity = s.nextLong();
			if(searched.size() == 0)	//new product
				products.add(new ProductLongPair(mb, quantity));
			else						//existing product
				products.get(searched.get(0)).num += s.nextLong();
    		break;
    	case 3://Memory
    		System.out.println("===============Memory===============");
    		Memory mem = new Memory();
			mem.insert();
			obj.put("Mode", "Match");
			obj.put("Attribute", "Name");
			obj.put("Value", mem.toJSONObject().get("Name"));
			searched = searchProductCondition(obj.toJSONString());
			System.out.print(" Quantity: ");
			quantity = s.nextLong();
			if(searched.size() == 0)	//new product
				products.add(new ProductLongPair(mem, quantity));
			else						//existing product
				products.get(searched.get(0)).num += s.nextLong();
    		break;
    	case 4://Graphic Card
    		System.out.println("===============Graphic Card===============");
    		GraphicCard graphic = new GraphicCard();
			graphic.insert();
			obj.put("Mode", "Match");
			obj.put("Attribute", "Name");
			obj.put("Value", graphic.toJSONObject().get("Name"));
			searched = searchProductCondition(obj.toJSONString());
			System.out.print(" Quantity: ");
			quantity = s.nextLong();
			if(searched.size() == 0)	//new product
				products.add(new ProductLongPair(graphic, quantity));
			else						//existing product
				products.get(searched.get(0)).num += s.nextLong();
    		break;
    	case 5://Power Supply
    		System.out.println("===============Power Supply===============");
    		PowerSupply ps = new PowerSupply();
			ps.insert();
			obj.put("Mode", "Match");
			obj.put("Attribute", "Name");
			obj.put("Value", ps.toJSONObject().get("Name"));
			searched = searchProductCondition(obj.toJSONString());
			System.out.print(" Quantity: ");
			quantity = s.nextLong();
			if(searched.size() == 0)	//new product
				products.add(new ProductLongPair(ps, quantity));
			else						//existing product
				products.get(searched.get(0)).num += s.nextLong();
    		break;
    	case 6://SSD
    		System.out.println("===============SSD===============");
    		SSD ssd = new SSD();
			ssd.insert();
			obj.put("Mode", "Match");
			obj.put("Attribute", "Name");
			obj.put("Value", ssd.toJSONObject().get("Name"));
			searched = searchProductCondition(obj.toJSONString());
			System.out.print(" Quantity: ");
			quantity = s.nextLong();
			if(searched.size() == 0)	//new product
				products.add(new ProductLongPair(ssd, quantity));
			else						//existing product
				products.get(searched.get(0)).num += s.nextLong();
    		break;
    	case 7://HDD
    		System.out.println("===============HDD===============");
    		HDD hdd = new HDD();
			hdd.insert();
			obj.put("Mode", "Match");
			obj.put("Attribute", "Name");
			obj.put("Value", hdd.toJSONObject().get("Name"));
			searched = searchProductCondition(obj.toJSONString());
			System.out.print(" Quantity: ");
			quantity = s.nextLong();
			if(searched.size() == 0)	//new product
				products.add(new ProductLongPair(hdd, quantity));
			else						//existing product
				products.get(searched.get(0)).num += s.nextLong();
    		break;
    	case 8://Case
    		System.out.println("===============Case===============");
    		Case c = new Case();
			c.insert();
			obj.put("Mode", "Match");
			obj.put("Attribute", "Name");
			obj.put("Value", c.toJSONObject().get("Name"));
			searched = searchProductCondition(obj.toJSONString());
			System.out.print(" Quantity: ");
			quantity = s.nextLong();
			if(searched.size() == 0)	//new product
				products.add(new ProductLongPair(c, quantity));
			else						//existing product
				products.get(searched.get(0)).num += s.nextLong();
    		break;
    	case 9://Expansion Card
    		System.out.println("===============Expansion Card===============");
    		ExpansionCard expc = new ExpansionCard();
			expc.insert();
			obj.put("Mode", "Match");
			obj.put("Attribute", "Name");
			obj.put("Value", expc.toJSONObject().get("Name"));
			searched = searchProductCondition(obj.toJSONString());
			System.out.print(" Quantity: ");
			quantity = s.nextLong();
			if(searched.size() == 0)	//new product
				products.add(new ProductLongPair(expc, quantity));
			else						//existing product
				products.get(searched.get(0)).num += s.nextLong();
			break;
		}
        s.close();
	}

	ArrayList<Integer> searchProductCondition(String conditionStr) {
		/* conditions : {"Condition":[{"Mode":"Exist", "Attribute":"Price"}]} */
		/* conditions : {"Mode":"Match", "Attribute":"Name", "Value":"i5"} */
		/* conditions : {"Condition":[{"Mode":"Range", "Attribute":"Price", "LowerBound":10000, "UpperBound":50000}]} */
		ArrayList<Integer> productIndex = new ArrayList<>();
		for(int i = 0; i < this.products.size(); i++) {
			productIndex.add(i);
		}
		try {
				JSONObject condition = (JSONObject)(new JSONParser().parse(conditionStr));
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
			return productIndex;
    	} catch(Exception exc) {
			System.out.println("Unexpected error occurred");
			return null;
    	}
	}
    
    void search() {
Scanner s = new Scanner(System.in);
        
        int type;
        System.out.println("===============SEARCH===============");
        System.out.println("-Filter");
        System.out.println("1. Name \t2. Product Type \t3. Manufacturer");
        System.out.println("4. Graphic Card \t5. Power Supply");
        System.out.println("6. SSD \t7. HDD \t\t8. Case");
        System.out.println("9. Expansion Card");
        
        
        s.close();
    }
}