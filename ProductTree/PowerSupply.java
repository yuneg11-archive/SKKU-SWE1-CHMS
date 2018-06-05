import java.util.ArrayList;
import java.util.Scanner;

import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

class PowerSupply extends Product {
	// Variable
	private Long ratedOutput; // Unit: W
	private String formFactor;
	private String certification;
	private ArrayList<StringLongPair> connectors;

	// Constructor
	public PowerSupply() {
		connectors = new ArrayList<>();
	}

	public PowerSupply(String attributes) {
		connectors = new ArrayList<>();
		setAttribute(attributes);
	}

	// Setter & Getter
	public String getProductType() {
		return "PowerSupply";
	}

	
	public void insert(String excludeKeys) {
		super.insert(excludeKeys);

		try {
			JSONObject required = (JSONObject) (new JSONParser().parse(excludeKeys));
			JSONArray keyArray = (JSONArray) required.get("ExcludeKey");
			Scanner s = new Scanner(System.in);
			long types;
			String name;
			long num;

			if (!keyArray.contains(Str.ratedOutput)) {
				System.out.print(" Rated output (W): ");
				this.ratedOutput = s.nextLong();
				s.nextLine();
			}

			if (!keyArray.contains(Str.formFactor)) {
				System.out.print(" Form Factor: ");
				this.formFactor = s.nextLine();
			}

			if (!keyArray.contains(Str.certification)) {
				System.out.print(" Certification: ");
				this.certification = s.nextLine();
			}

			if (!keyArray.contains(Str.connector)) {
				System.out.print(" How many types of connectors?: ");
				types = s.nextLong();
				s.nextLine();
				for (int i = 0; i < types; i++) {
					System.out.printf(" Name of connector type %d: ", i + 1);
					name = s.nextLine();
					System.out.printf(" Number of connector type %d: ", i + 1);
					num = s.nextLong();
					s.nextLine();
					this.connectors.add(new StringLongPair(name, num));
				}
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
			if (obj.containsKey("RatedOutput"))
				this.ratedOutput = (Long) obj.get("RatedOutput");
			if (obj.containsKey("FormFactor"))
				this.formFactor = (String) obj.get("FormFactor");
			if (obj.containsKey("Certification"))
				this.certification = (String) obj.get("Certification");
			if (obj.containsKey(Str.connector)) {
				JSONArray values = (JSONArray) obj.get(Str.connector);
				for (Object value : values) {
					connectors.add(new StringLongPair((String) ((JSONObject) value).get("Name"),
							(Long) ((JSONObject) value).get("Number")));
				}
			}
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
					obj.put(Str.productType, "PowerSupply");
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
				case "RatedOutput":
					if (this.ratedOutput != null)
						obj.put("RatedOutput", this.ratedOutput);
					break;
				case "FormFactor":
					if (this.formFactor != null)
						obj.put("FormFactor", this.formFactor);
					break;
				case "Certification":
					if (this.certification != null)
						obj.put("Certification", this.certification);
					break;
				case "Port":
					if (connectors.size() != 0) {
						JSONArray values = new JSONArray();
						for (StringLongPair value : connectors) {
							JSONObject slp = new JSONObject();
							slp.put("Name", value.name);
							slp.put("Number", value.num);
							values.add(slp);
						}
						obj.put("Connector", values);
					}
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
		keyArray.add(Str.ratedOutput);
		keyArray.add(Str.formFactor);
		keyArray.add(Str.certification);
		keyArray.add(Str.connector);
		obj.put("Keys", keyArray);
		try {
			return (JSONObject) (new JSONParser().parse(getAttribute(obj.toJSONString())));
		} catch (Exception ex) {
			System.out.println("Unexpected error occurred");
			return null;
		}
	}
}