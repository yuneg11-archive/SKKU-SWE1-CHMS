import java.util.ArrayList;
import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

class DataManagement {
    private ArrayList<ProductLongPair> products;

    DataManagement(ArrayList<ProductLongPair> products) {
        this.products = products;
    }

    ArrayList<ProductLongPair> getProducts() {
        return products;
    }

    void insert() {
		JSONObject obj = new JSONObject();
		obj.put("Mode", "Match");
		obj.put("Attribute", "Name");
        
        int type = UI.printInsert();
		Long quantity;
		ArrayList<Integer> searched= new ArrayList<Integer>();
        switch(type) {
    	case 1://CPU
    		System.out.println(UI.insertTitle("CPU"));
    		CPU cpu = new CPU();
			cpu.insert("{\"ExcludeKey\":[]}");
			obj.put("Value", cpu.toJSONObject().get("Name"));
			searched = searchProduct(obj.toJSONString());
			quantity = UI.inputLong("Quantity");
			System.out.println(UI.inputEndLine);
			if(searched.size() == 0) {	//new product
				products.add(new ProductLongPair(cpu, quantity));
				printProduct(products.size()-1,1);
				System.out.println(" Product \"" + cpu.toJSONObject().get("Name") + "\" is added.");
			} else {						//existing product
				System.out.println(" Product of same name already exist. Accumulate quantity.");
				products.get(searched.get(0)).num += quantity;
			}
			break;
    	case 2://Mainboard
			System.out.println(UI.insertTitle("Mainboard"));
    		Mainboard mb = new Mainboard();
			mb.insert("{\"ExcludeKey\":[]}");
			obj.put("Value", mb.toJSONObject().get("Name"));
			searched = searchProduct(obj.toJSONString());
			quantity = UI.inputLong("Quantity");
			System.out.println(UI.inputEndLine);
			if(searched.size() == 0) {	//new product
				products.add(new ProductLongPair(mb, quantity));
				printProduct(products.size()-1,1);
				System.out.println(" Product \"" + mb.toJSONObject().get("Name") + "\" is added.");
			} else {						//existing product
				System.out.println(" Product of same name already exist. Accumulate quantity.");
				products.get(searched.get(0)).num += quantity;
			}
    		break;
    	case 3://Memory
			System.out.println(UI.insertTitle("Memory"));
    		Memory mem = new Memory();
			mem.insert("{\"ExcludeKey\":[]}");
			obj.put("Value", mem.toJSONObject().get("Name"));
			searched = searchProduct(obj.toJSONString());
			quantity = UI.inputLong("Quantity");
			System.out.println(UI.inputEndLine);
			if(searched.size() == 0) {	//new product
				products.add(new ProductLongPair(mem, quantity));
				printProduct(products.size()-1,1);
				System.out.println(" Product \"" + mem.toJSONObject().get("Name") + "\" is added.");
			} else {						//existing product
				System.out.println(" Product of same name already exist. Accumulate quantity.");
				products.get(searched.get(0)).num += quantity;
			}
    		break;
    	case 4://Graphic Card
			System.out.println(UI.insertTitle("Graphic Card"));
    		GraphicCard graphic = new GraphicCard();
			graphic.insert("{\"ExcludeKey\":[]}");
			obj.put("Value", graphic.toJSONObject().get("Name"));
			searched = searchProduct(obj.toJSONString());
			quantity = UI.inputLong("Quantity");
			System.out.println(UI.inputEndLine);
			if(searched.size() == 0) {	//new product
				products.add(new ProductLongPair(graphic, quantity));
				printProduct(products.size()-1,1);
				System.out.println(" Product \"" + graphic.toJSONObject().get("Name") + "\" is added.");
			} else {						//existing product
				System.out.println(" Product of same name already exist. Accumulate quantity.");
				products.get(searched.get(0)).num += quantity;
			}
    		break;
    	case 5://Power Supply
			System.out.println(UI.insertTitle("Power Supply"));
    		PowerSupply ps = new PowerSupply();
			ps.insert("{\"ExcludeKey\":[]}");
			obj.put("Value", ps.toJSONObject().get("Name"));
			searched = searchProduct(obj.toJSONString());
			quantity = UI.inputLong("Quantity");
			System.out.println(UI.inputEndLine);
			if(searched.size() == 0) {	//new product
				products.add(new ProductLongPair(ps, quantity));
				printProduct(products.size()-1,1);
				System.out.println(" Product \"" + ps.toJSONObject().get("Name") + "\" is added.");
			} else {						//existing product
				System.out.println(" Product of same name already exist. Accumulate quantity.");
				products.get(searched.get(0)).num += quantity;
			}
    		break;
    	case 6://SSD
			System.out.println(UI.insertTitle("SSD"));
    		SSD ssd = new SSD();
			ssd.insert("{\"ExcludeKey\":[]}");
			obj.put("Value", ssd.toJSONObject().get("Name"));
			searched = searchProduct(obj.toJSONString());
			quantity = UI.inputLong("Quantity");
			System.out.println(UI.inputEndLine);
			if(searched.size() == 0) {	//new product
				products.add(new ProductLongPair(ssd, quantity));
				printProduct(products.size()-1,1);
				System.out.println(" Product \"" + ssd.toJSONObject().get("Name") + "\" is added.");
			} else {						//existing product
				System.out.println(" Product of same name already exist. Accumulate quantity.");
				products.get(searched.get(0)).num += quantity;
			}
    		break;
    	case 7://HDD
			System.out.println(UI.insertTitle("HDD"));
    		HDD hdd = new HDD();
			hdd.insert("{\"ExcludeKey\":[]}");
			obj.put("Value", hdd.toJSONObject().get("Name"));
			searched = searchProduct(obj.toJSONString());
			quantity = UI.inputLong("Quantity");
			System.out.println(UI.inputEndLine);
			if(searched.size() == 0) {	//new product
				products.add(new ProductLongPair(hdd, quantity));
				printProduct(products.size()-1,1);
				System.out.println(" Product \"" + hdd.toJSONObject().get("Name") + "\" is added.");
			} else {						//existing product
				System.out.println(" Product of same name already exist. Accumulate quantity.");
				products.get(searched.get(0)).num += quantity;
			}
    		break;
    	case 8://Case
			System.out.println(UI.insertTitle("Case"));
    		Case c = new Case();
			c.insert("{\"ExcludeKey\":[]}");
			obj.put("Value", c.toJSONObject().get("Name"));
			searched = searchProduct(obj.toJSONString());
			quantity = UI.inputLong("Quantity");
			System.out.println(UI.inputEndLine);
			if(searched.size() == 0) {	//new product
				products.add(new ProductLongPair(c, quantity));
				printProduct(products.size()-1,1);
				System.out.println(" Product \"" + c.toJSONObject().get("Name") + "\" is added.");
			} else {						//existing product
				System.out.println(" Product of same name already exist. Accumulate quantity.");
				products.get(searched.get(0)).num += quantity;
			}
    		break;
    	case 9://Expansion Card
			System.out.println(UI.insertTitle("Expansion Card"));
    		ExpansionCard expc = new ExpansionCard();
			expc.insert("{\"ExcludeKey\":[]}");
			obj.put("Value", expc.toJSONObject().get("Name"));
			searched = searchProduct(obj.toJSONString());
			quantity = UI.inputLong("Quantity");
			System.out.println(UI.inputEndLine);
			if(searched.size() == 0) {	//new product
				products.add(new ProductLongPair(expc, quantity));
				printProduct(products.size()-1,1);
				System.out.println(" Product \"" + expc.toJSONObject().get("Name") + "\" is added.");
			} else {						//existing product
				System.out.println(" Product of same name already exist. Accumulate quantity.");
				products.get(searched.get(0)).num += quantity;
			}
			break;
		}
		//s.close();
	}

	Integer searchProductName(String name) {
		JSONObject obj = new JSONObject();
		obj.put("Mode", "Match");
		obj.put("Attribute", "Name");
		obj.put("Value", name);
		ArrayList<Integer> searched = searchProduct(obj.toJSONString());
		if(searched.size() == 0) {
			return -1;
		} else {
			return searched.get(0);
		}
	}

	ArrayList<Integer> searchProduct(String conditionStr) {
		/* conditions : {"Mode":"Exist", "Attribute":"Price"} */
		/* conditions : {"Mode":"Match", "Attribute":"Name", "Value":"i5"} */
		/* conditions : {"Mode":"Range", "Attribute":"Price", "LowerBound":10000, "UpperBound":50000}]} */
		ArrayList<Integer> productIndex = new ArrayList<Integer>();
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
				if(((String)condition.get("Attribute")).equals("Quantity")) {
					value = products.get(productIndex.get(i)).num;
				}

				if(value == null) { // Attribute doesn't exist in target product
					productIndex.remove(productIndex.get(i));
				} else {
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
	
	void delete() {
		UI.printDelete();
		String name = UI.inputLine("Name");
		Integer searchedIndex = searchProductName(name);
		if(searchedIndex == -1) {
			System.out.println(" Product \"" + name + "\" doesn't exist.");
		} else {
			printProduct(searchedIndex);
			boolean answer = UI.inputYesNo("Delete \"" + name + "\"? (Y/N)");
			if(answer) {
				products.remove((int)searchedIndex);
				System.out.println(" Product \"" + name + "\" is deleted.");
			} else {
				System.out.println(" Delete canceled.");
			}
		}
	}

	void modify() {
		UI.printModify();
		String name = UI.inputLine("Name");
		Integer searchedIndex = searchProductName(name);
		if(searchedIndex == -1) {
			System.out.println("Product \"" + name + "\" doesn't exist.");
		} else {
			printProduct(searchedIndex);
			boolean answer = UI.inputYesNo("Modify \"" + name + "\"? (Y/N)");
			if(answer) {
				JSONObject exclude = new JSONObject();
				JSONArray keyArray = new JSONArray();
				keyArray.add(Str.name);
				exclude.put("ExcludeKey", keyArray);
				products.get((int)searchedIndex).product.insert(exclude.toJSONString());
				products.get((int)searchedIndex).num = UI.inputLong("Quantity");
				printProduct(searchedIndex);
				System.out.println(" Product \"" + name + "\" is modified.");
			} else {
				System.out.println(" Modify canceled.");
			}
		}
	}

	void search() {
		int select = UI.printSearch();

		String attributeName = Str.getAttributeName(select);
		String attributeType = Str.getAttributeType(select);;
		JSONObject obj = new JSONObject();
		int mode = 0;

		if(attributeType.equals("String")) {
			mode = UI.inputRange("Mode (1.Exist, 2.Match)", 1, 2);
		} else if(attributeType.equals("Double") || attributeType.equals("Long")) {
			mode = UI.inputRange("Mode (1.Exist, 2.Match, 3.Range)", 1, 3);
		}
		if(mode == 1) {
			obj.put("Mode", "Exist");
		} else if(mode == 2) {
			obj.put("Mode", "Match");
			Object value = null;
			if(attributeType.equals("String")) {
				value = UI.inputLine("Value");
			} else if(attributeType.equals("Long")) {
				value = UI.inputLong("Value");
			} else if(attributeType.equals("Double")) {
				value = UI.inputDouble("Value");
			}
			obj.put("Value", value);
		} else if(mode == 3) {
			obj.put("Mode", "Range");
			int rangeMode = UI.inputRange("Range Mode (1.<=, 2.>=, 3.Both)", 1, 3);
			Object upperBound = Double.MAX_VALUE;
			Object lowerBound = 0D;
			if(rangeMode == 1 || rangeMode == 3) {
				if(attributeType.equals("Long")) {
					upperBound = UI.inputLong("Upper bound");
				} else if(attributeType.equals("Double")) {
					upperBound = UI.inputDouble("Upper bound");
				}
			}
			if(rangeMode == 2 || rangeMode == 3) {
				if(attributeType.equals("Long")) {
					upperBound = UI.inputLong("Lower bound");
				} else if(attributeType.equals("Double")) {
					upperBound = UI.inputDouble("Lower bound");
				}
			}
			obj.put("LowerBound", lowerBound);
			obj.put("UpperBound", upperBound);
		}
		obj.put("Attribute", attributeName);
		ArrayList<Integer> searched = searchProduct(obj.toJSONString());
		printProduct(searched);
	}

	void sort() {
		int select = UI.printSort();

		String attributeName = Str.getAttributeName(select);
		String attributeType = Str.getAttributeType(select);
		JSONObject obj = new JSONObject();
		obj.put("Mode", "Exist");
		obj.put("Attribute", attributeName);
		ArrayList<Integer> searched = searchProduct(obj.toJSONString());

		int sortDirc = UI.inputRange("Order (1.Ascending, 2.Descending)", 1, 2);
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		try {
			sorted = sortProduct(searched, attributeName, attributeType, sortDirc);
		} catch(Exception e) {}
		printProduct(sorted);
	}

	void list() {
		ArrayList<Integer> require = new ArrayList<>();
		for(int i = 0; i < products.size(); i++) {
			require.add(i);
		}
		printProduct(require);
	}

	void costCalc() {
		ArrayList<Integer> selectedProducts = new ArrayList<Integer>();
		boolean cont;

		UI.printCostCalc();
		do {
			String name = UI.inputLine("#" + (selectedProducts.size()+1) + " Product's name");
			Integer selectedIndex = searchProductName(name);
			if(selectedIndex == -1) {
				System.out.println(UI.prompt("Product \"" + name + "\" doesn't exist."));
			} else {
				printProduct(selectedIndex);
				boolean select = UI.inputYesNo("Add \"" + name + "\" to calculation list? (Y/N)");
				if(select) {
					selectedProducts.add(selectedIndex);
				}
			}
			cont = UI.inputYesNo("Add more products? (Y/N)");
		} while(cont);
		printProduct(selectedProducts);

		Long sum = 0L;
		for(Integer idx : selectedProducts) {
			sum += products.get(idx).product.price * products.get(idx).num;
		}
		System.out.println(UI.prompt("Total price: " + sum.toString()));
	}

	void compatTest() {
		UI.printCompatTest();
		Integer mainboardIndex = -1;
		Integer cpuIndex = -1;
		Integer graphicCardIndex = -1;
		Integer powerSupplyIndex = -1;
		Integer caseIndex = -1;

		if(UI.inputYesNo("Add Mainboard? (Y/N)")) {
			System.out.println(UI.insertTitle("Mainboard"));
			do{
				String name = UI.inputLine("Mainboard name");
				Integer searchedIndex = searchProductName(name);
				if(searchedIndex == -1) {
					System.out.println(UI.prompt("Product \"" + name + "\" doesn't exist."));
				} else if(!(products.get(searchedIndex).product instanceof Mainboard)) {
					System.out.println(UI.prompt("Product \"" + name + "\" is not a mainboard."));
				} else {
					printProduct(searchedIndex);
					if(UI.inputYesNo("Add \"" + name + "\" to compatibility check list? (Y/N)")) {
						mainboardIndex = searchedIndex;
						break;
					}
				}
			} while(UI.inputYesNo("Re-enter name? (Y/N)"));
			System.out.println(UI.inputEndLine);
		}

		if(UI.inputYesNo("Add CPU? (Y/N)")) {
			System.out.println(UI.insertTitle("CPU"));
			do{
				String name = UI.inputLine("CPU name");
				Integer searchedIndex = searchProductName(name);
				if(searchedIndex == -1) {
					System.out.println(UI.prompt("Product \"" + name + "\" doesn't exist."));
				} else if(!(products.get(searchedIndex).product instanceof CPU)) {
					System.out.println(UI.prompt("Product \"" + name + "\" is not a CPU."));
				} else {
					printProduct(searchedIndex);
					if(UI.inputYesNo("Add \"" + name + "\" to compatibility check list? (Y/N)")) {
						cpuIndex = searchedIndex;
						break;
					}
				}
			} while(UI.inputYesNo("Re-enter name? (Y/N)"));
			System.out.println(UI.inputEndLine);
		}
		
		if(UI.inputYesNo("Add Graphic card? (Y/N)")) {
			System.out.println(UI.insertTitle("Graphic card"));
			do{
				String name = UI.inputLine("Graphic card name");
				Integer searchedIndex = searchProductName(name);
				if(searchedIndex == -1) {
					System.out.println(UI.prompt("Product \"" + name + "\" doesn't exist."));
				} else if(!(products.get(searchedIndex).product instanceof GraphicCard)) {
					System.out.println(UI.prompt("Product \"" + name + "\" is not a Graphic card."));
				} else {
					printProduct(searchedIndex);
					if(UI.inputYesNo("Add \"" + name + "\" to compatibility check list? (Y/N)")) {
						graphicCardIndex = searchedIndex;
						break;
					}
				}
			} while(UI.inputYesNo("Re-enter name? (Y/N)"));
			System.out.println(UI.inputEndLine);
		}

		if(UI.inputYesNo("Add Power supply? (Y/N)")) {
			System.out.println(UI.insertTitle("Power supply"));
			do{
				String name = UI.inputLine("Power supply name");
				Integer searchedIndex = searchProductName(name);
				if(searchedIndex == -1) {
					System.out.println(UI.prompt("Product \"" + name + "\" doesn't exist."));
				} else if(!(products.get(searchedIndex).product instanceof PowerSupply)) {
					System.out.println(UI.prompt("Product \"" + name + "\" is not a Power supply."));
				} else {
					printProduct(searchedIndex);
					if(UI.inputYesNo("Add \"" + name + "\" to compatibility check list? (Y/N)")) {
						powerSupplyIndex = searchedIndex;
						break;
					}
				}
			} while(UI.inputYesNo("Re-enter name? (Y/N)"));
			System.out.println(UI.inputEndLine);
		}

		if(UI.inputYesNo("Add Case? (Y/N)")) {
			System.out.println(UI.insertTitle("Case"));
			do{
				String name = UI.inputLine("Case name");
				Integer searchedIndex = searchProductName(name);
				if(searchedIndex == -1) {
					System.out.println(UI.prompt("Product \"" + name + "\" doesn't exist."));
				} else if(!(products.get(searchedIndex).product instanceof Case)) {
					System.out.println(UI.prompt("Product \"" + name + "\" is not a Case."));
				} else {
					printProduct(searchedIndex);
					if(UI.inputYesNo("Add \"" + name + "\" to compatibility check list? (Y/N)")) {
						caseIndex = searchedIndex;
						break;
					}
				}
			} while(UI.inputYesNo("Re-enter name? (Y/N)"));
			System.out.println(UI.inputEndLine);
		}

		System.out.println(UI.title("Compatibility Test Result"));
		if(cpuIndex != -1 && mainboardIndex != -1) {
			try {
				String cpuAtt = products.get(cpuIndex).product.getAttribute("{\"Keys\":[\""+Str.cpuSocket+"\"]}");
				String cpuValue = (String)((JSONObject)(new JSONParser().parse(cpuAtt))).get(Str.cpuSocket);
				String mainboardAtt = products.get(mainboardIndex).product.getAttribute("{\"Keys\":[\""+Str.cpuSocket+"\"]}");
				String mainboardValue = (String)((JSONObject)(new JSONParser().parse(mainboardAtt))).get(Str.cpuSocket);
				if(cpuValue.equals(mainboardValue)) {
					System.out.println(UI.subtitle("CPU <-> Mainboard : Compatible"));
					System.out.println(UI.subcontent("CPU name: " + products.get(cpuIndex).product.name));
					System.out.println(UI.subcontent("Mainboard name: " + products.get(mainboardIndex).product.name));
					System.out.println(UI.subcontent("Socket: " + cpuValue));
				} else {
					System.out.println(UI.subtitle("CPU <-> Mainboard : Incompatible"));
					System.out.println(UI.subcontent("CPU name: " + products.get(cpuIndex).product.name));
					System.out.println(UI.subcontent("Mainboard name: " + products.get(mainboardIndex).product.name));
					System.out.println(UI.subcontent("CPU Socket: " + cpuValue));
					System.out.println(UI.subcontent("Mainboard Socket: " + mainboardValue));
				}
			} catch(Exception ex) {}
		}

		//Incomplete
		if(graphicCardIndex != -1 && mainboardIndex != -1) {
			try {
				String graphicCardAtt = products.get(cpuIndex).product.getAttribute("{\"Keys\":[\""+Str.cpuSocket+"\"]}");
				String cpuValue = (String)((JSONObject)(new JSONParser().parse(graphicCardAtt))).get(Str.cpuSocket);
				String mainboardAtt = products.get(mainboardIndex).product.getAttribute("{\"Keys\":[\""+Str.cpuSocket+"\"]}");
				String mainboardValue = (String)((JSONObject)(new JSONParser().parse(mainboardAtt))).get(Str.cpuSocket);
				if(cpuValue.equals(mainboardValue)) {
					System.out.println(UI.subtitle("CPU <-> Mainboard : Compatible"));
					System.out.println(UI.subcontent("CPU name: " + products.get(cpuIndex).product.name));
					System.out.println(UI.subcontent("Mainboard name: " + products.get(mainboardIndex).product.name));
					System.out.println(UI.subcontent("Socket: " + cpuValue));
				} else {
					System.out.println(UI.subtitle("CPU <-> Mainboard : Incompatible"));
					System.out.println(UI.subcontent("CPU name: " + products.get(cpuIndex).product.name));
					System.out.println(UI.subcontent("Mainboard name: " + products.get(mainboardIndex).product.name));
					System.out.println(UI.subcontent("CPU Socket: " + cpuValue));
					System.out.println(UI.subcontent("Mainboard Socket: " + mainboardValue));
				}
			} catch(Exception ex) {}
		}
	}

	ArrayList<Integer> sortProduct(ArrayList<Integer> lists, String attributeName, String attributeType, int sortDirc) throws Exception {
		if(sortDirc == 1) { // Asc
			sortDirc =  1;
		} else if(sortDirc == 2) { // Desc
			sortDirc = -1;
		}
		for(int i = 1 ; i < lists.size() ; i++){
			int key = lists.get(i);
			String keyElemAtt = products.get(key).product.getAttribute("{\"Keys\":[\""+attributeName+"\"]}");
			Object keyObj = ((JSONObject)(new JSONParser().parse(keyElemAtt))).get(attributeName);
			if(attributeName.equals(Str.quantity)) {
				keyObj = products.get(key).num;
			}
			int j;
			for(j = i-1; j >= 0; j--) {
				String jElemAtt = products.get(lists.get(j)).product.getAttribute("{\"Keys\":[\""+attributeName+"\"]}");
				Object jObj = ((JSONObject)(new JSONParser().parse(jElemAtt))).get(attributeName);
				if(attributeName.equals(Str.quantity)) {
					jObj = products.get(lists.get(j)).num;
				}
				if(attributeType.equals("String")) {
					if(((String)jObj).compareTo((String)keyObj)*sortDirc > 0) {
						lists.set(j+1, lists.get(j));
					} else break;
				} else if(attributeType.equals("Long")) {
					if(((Long)jObj)*sortDirc > ((Long)keyObj)*sortDirc) {
						lists.set(j+1, lists.get(j));
					} else break;
				} else if(attributeType.equals("Double")) {
					if(((Double)jObj)*sortDirc > ((Double)keyObj)*sortDirc) {
						lists.set(j+1, lists.get(j));
					} else break;
				}
			}
			lists.set(j+1, key);
		}
		return lists;
	}

	void printProduct(int index) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(index);
		printProduct(al);
	}

	void printProduct(int index, int added){
		System.out.println(UI.title("New Product"));
		Product pd = products.get(index).product;
		Long qt = products.get(index).num;
		System.out.println(UI.subcontent("< "+pd.getProductType()+" > : "+String.valueOf(qt)+"ea"));
		pd.print("{\"ExcludeKey\":[]}");
		System.out.println(UI.closeBox);
	}

	void printProduct(ArrayList<Integer> index) {
		int size;
		if(index == null) size = 0;
    	else size = index.size();
		System.out.println(UI.title("Product List"));
		if(size == 0) {
			System.out.println(UI.content("No such product"));
		} else {
    	    for (int i = 0; i < size; i++) {
				Product pd = products.get(index.get(i)).product;
    	        Long qt = products.get(index.get(i)).num;

    	        System.out.println(UI.subcontent("< Product #"+String.valueOf(i+1)+" - "+pd.getProductType()+" > : "+String.valueOf(qt)+"ea"));
				pd.print("{\"ExcludeKey\":[]}");
				if(i!=size-1) //not a last product
					System.out.println(UI.seperatingLine);
			}
		}
		System.out.println(UI.closeBox);
	}
}