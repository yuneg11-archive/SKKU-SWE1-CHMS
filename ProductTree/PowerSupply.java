import java.util.ArrayList;
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
		this.productType = "PowerSupply";
		connectors = new ArrayList<>();
	}

	public PowerSupply(String attributes) {
		this.productType = "PowerSupply";
		connectors = new ArrayList<>();
		setAttribute(attributes);
	}

	// Setter & Getter
	public void insert(String excludeKeys) {
		super.insert(excludeKeys);

		try {
			JSONObject required = (JSONObject) (new JSONParser().parse(excludeKeys));
			JSONArray keyArray = (JSONArray) required.get("ExcludeKey");
			long types;
			String name;
			long num;

			if (!keyArray.contains(Str.ratedOutput))
				this.ratedOutput = UI.inputLong("Rated output (W)");

			if (!keyArray.contains(Str.formFactor))
				this.formFactor = UI.inputLine("Form Factor");

			if (!keyArray.contains(Str.certification))
				this.certification = UI.inputLine("Certification");

			if (!keyArray.contains(Str.connector)) {
				types = UI.inputLong("How many types of connectors?");
				for (int i = 0; i < types; i++) {
					name = UI.inputLine("Name of connector type "+String.valueOf(i+1));
					num = UI.inputLong("Number of connector type "+String.valueOf(i+1));
					this.connectors.add(new StringLongPair(name, num));
				}
			}
		} catch (Exception exc) {
			System.out.println("Unexpected error occurred");
		}

	}

	public void print(String excludeKeys) {
		super.print(excludeKeys);

		try {
			JSONObject required = (JSONObject) (new JSONParser().parse(excludeKeys));
			JSONArray keyArray = (JSONArray) required.get("ExcludeKey");
			long types;

			if (!keyArray.contains(Str.ratedOutput))
				System.out.println(UI.content("Rated Output: "+this.ratedOutput+"W"));

			if (!keyArray.contains(Str.formFactor))
				System.out.println(UI.content("Form Factor: "+this.formFactor));

			if (!keyArray.contains(Str.certification))
				System.out.println(UI.content("Certification: "+this.certification));

			if (!keyArray.contains(Str.connector)) {
				types = connectors.size();
				for (int i = 0; i < types; i++) {
					System.out.println(UI.subtitle("Connector #"+String.valueOf(i+1)));
					System.out.println(UI.content(this.connectors.get(i).name+" - "+String.valueOf(this.connectors.get(i).num)+"ea"));
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
			if (obj.containsKey(Str.productType))
				this.productType = (String) obj.get(Str.productType);
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