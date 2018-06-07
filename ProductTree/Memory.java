import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

class Memory extends Product {
	// Variable
	private Long capacity; // Unit: MB
	private Long clockRate; // Unit: MHz
	private Boolean errorCheck; // ECC
	private String standard; // DDR#

	// Constructor
	public Memory() {
		this.productType = "Memory";
	}

	public Memory(String attributes) {
		this.productType = "Memory";
		setAttribute(attributes);
	}

	// Setter & Getter
	public void insert(String excludeKeys) {
		super.insert(excludeKeys);
		try {
			JSONObject required = (JSONObject) (new JSONParser().parse(excludeKeys));
			JSONArray keyArray = (JSONArray) required.get("ExcludeKey");

			if (!keyArray.contains(Str.capacity))
				this.capacity = UI.inputLong("Capacity (MB)");

			if (!keyArray.contains(Str.clockRate))
				this.clockRate = UI.inputLong("Clock Rate (MHz)");

			if (!keyArray.contains(Str.errorCheck))
				this.errorCheck = UI.inputYesNo("Error Check (Y/N)");

			if (!keyArray.contains(Str.standard))
				this.standard = UI.inputLine("Standard (\"DDR#\")");
		} catch (Exception exc) {
			System.out.println("Unexpected error occurred");
		}

	}

	public void print(String excludeKeys) {
		super.print(excludeKeys);

		try {
			JSONObject required = (JSONObject) (new JSONParser().parse(excludeKeys));
			JSONArray keyArray = (JSONArray) required.get("ExcludeKey");

			if (!keyArray.contains(Str.capacity))
				System.out.println(UI.content("Capacity: "+this.capacity+"MB"));

			if (!keyArray.contains(Str.clockRate))
				System.out.println(UI.content("Clock Rate: "+this.clockRate+"MHz"));

			if (!keyArray.contains(Str.errorCheck)) {
				if(this.errorCheck)
					System.out.println(UI.content("Error Check: Yes"));
				else
					System.out.println(UI.content("Error Check: No"));
			}

			if (!keyArray.contains(Str.standard)) {
				System.out.println(UI.content("Standard: "+this.standard));
			}
		} catch (Exception exc) {
			System.out.println("Unexpected error occurred");
		}

	}

	public void setAttribute(String attributes) {
		/* attributes : {"Name":"i5-750", "Price":210000, "Manufacturer":"Intel"} */
		try {
			JSONObject obj = (JSONObject) (new JSONParser().parse(attributes));
			if (obj.containsKey(Str.productType))
				this.productType = (String) obj.get(Str.productType);
			if (obj.containsKey("Name"))
				this.name = (String) obj.get("Name");
			if (obj.containsKey("Price"))
				this.price = (Long) obj.get("Price");
			if (obj.containsKey("Manufacturer"))
				this.manufacturer = (String) obj.get("Manufacturer");
			if (obj.containsKey("Capacity"))
				this.capacity = (Long) obj.get("Capacity");
			if (obj.containsKey("ClockRate"))
				this.clockRate = (Long) obj.get("ClockRate");
			if (obj.containsKey("ErrorCheck"))
				this.errorCheck = (Boolean) obj.get("ErrorCheck");
			if (obj.containsKey("Standard"))
				this.standard = (String) obj.get("Standard");
		} catch (Exception exc) {
			System.out.println("Unexpected error occurred");
		}
	}

	public String getAttribute(String keys) {
		/* keys : {"Keys":["ProductType", "Name", "Price"]} */
		try {
			JSONObject required = (JSONObject) (new JSONParser().parse(keys));
			JSONArray keyArray = (JSONArray) required.get("Keys");
			JSONObject obj = new JSONObject();
			for (Object key : keyArray) {
				switch ((String) key) {
				case "ProductType":
					obj.put(Str.productType, "Memory");
					break;
				case "Name":
					if (this.name != null)
						obj.put("Name", this.name);
					break;
				case "Price":
					if (this.price != null)
						obj.put("Price", this.price);
					break;
				case "Manufacturer":
					if (this.manufacturer != null)
						obj.put("Manufacturer", this.manufacturer);
					break;
				case "Capacity":
					if (this.capacity != null)
						obj.put("Capacity", this.capacity);
					break;
				case "ClockRate":
					if (this.clockRate != null)
						obj.put("ClockRate", this.clockRate);
					break;
				case "ErrorCheck":
					if (this.errorCheck != null)
						obj.put("ErrorCheck", this.errorCheck);
					break;
				case "Standard":
					if (this.standard != null)
						obj.put("Standard", this.standard);
					break;
				}
			}
			return obj.toJSONString();
		} catch (Exception exc) {
			System.out.println("Unexpected error occurred");
			return null;
		}
	}

	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();
		JSONArray keyArray = new JSONArray();
		keyArray.add(Str.productType);
		keyArray.add(Str.name);
		keyArray.add(Str.price);
		keyArray.add(Str.manufacturer);
		keyArray.add(Str.capacity);
		keyArray.add(Str.clockRate);
		keyArray.add(Str.errorCheck);
		keyArray.add(Str.standard);
		obj.put("Keys", keyArray);
		try {
			return (JSONObject) (new JSONParser().parse(getAttribute(obj.toJSONString())));
		} catch (Exception ex) {
			System.out.println("Unexpected error occurred");
			return null;
		}
	}
}