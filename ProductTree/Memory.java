import JSON.JSONObject;

import java.util.Scanner;

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
	}

	public Memory(String attributes) {
		setAttribute(attributes);
	}

	// Setter & Getter
	public String getProductType() {
		return "Memory";
	}

	
	public void insert(String excludeKeys) {
		super.insert(excludeKeys);

		try {
			JSONObject required = (JSONObject) (new JSONParser().parse(excludeKeys));
			JSONArray keyArray = (JSONArray) required.get("ExcludeKeys");
			Scanner s = new Scanner(System.in);

			if (!keyArray.contains(Str.capacity)) {
				System.out.print(" Capacity (MB): ");
				this.capacity = s.nextLong();
				s.nextLine();
			}

			if (!keyArray.contains(Str.clockRate)) {
				System.out.print(" Clock Rate (MHz): ");
				this.clockRate = s.nextLong();
				s.nextLine();
			}

			if (!keyArray.contains(Str.errorCheck)) {
				while (true) {
					System.out.print(" Error Check (Y/N): ");
					String answer = s.nextLine();
					if (answer.compareTo("Y") == 0) {
						this.errorCheck = true;
						break;
					} else if (answer.compareTo("N") == 0) {
						this.errorCheck = false;
						break;
					} else
						System.out.println("Invalid Input");
				}
			}

			if (!keyArray.contains(Str.standard)) {
				System.out.print(" Standard (\"DDR#\"): ");
				this.standard = s.nextLine();
			}
		} catch (Exception exc) {
			System.out.println("Unexpected error occurred");
		}

	}

	public void setAttribute(String attributes) {
		/* attributes : {"Name":"i5-750", "Price":210000, "Manufacturer":"Intel"} */
		try {
			JSONObject obj = (JSONObject) (new JSONParser().parse(attributes));
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