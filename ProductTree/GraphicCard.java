import java.util.ArrayList;
import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

class GraphicCard extends Graphic {
	// Variable
	private String slot;
	private ArrayList<StringLongPair> ports;

	// Constructor
	public GraphicCard() {
		this.productType = "GraphicCard";
		ports = new ArrayList<StringLongPair>();
	}

	public GraphicCard(String attributes) {
		this.productType = "GraphicCard";
		ports = new ArrayList<StringLongPair>();
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

			if (!keyArray.contains(Str.slot))
				this.slot = UI.inputLine("Slot");

			if (!keyArray.contains(Str.port)) {
				types = UI.inputLong("How many types of ports?");
				for (int i = 0; i < types; i++) {
					name = UI.inputLine("Name of port type "+String.valueOf(i+1));
					num = UI.inputLong("Number of port type "+String.valueOf(i+1));
					this.ports.add(new StringLongPair(name, num));
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

			if (!keyArray.contains(Str.slot))
				System.out.println(UI.content("Slot: "+this.slot));

			if (!keyArray.contains(Str.port)) {
				types = ports.size();
				for (int i = 0; i < types; i++) {
					System.out.println(UI.subtitle("Port #"+String.valueOf(i+1)));
					System.out.println(UI.content(this.ports.get(i).name+" - "+String.valueOf(this.ports.get(i).num)+"ea"));
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
			if (obj.containsKey("CoreNumber"))
				this.coreNumber = (Long) obj.get("CoreNumber");
			if (obj.containsKey("ClockRate"))
				this.clockRate = (Double) obj.get("ClockRate");
			if (obj.containsKey("Fabrication"))
				this.fabrication = (Long) obj.get("Fabrication");
			if (obj.containsKey("TDP"))
				this.tdp = (Long) obj.get("TDP");
			if (obj.containsKey("Chipset"))
				this.chipset = (String) obj.get("Chipset");
			if (obj.containsKey("Memory"))
				this.memory = new Memory(((JSONObject) obj.get("Memory")).toJSONString());
			if (obj.containsKey("Slot"))
				this.slot = (String) obj.get("Slot");
			if (obj.containsKey(Str.port)) {
				JSONArray values = (JSONArray) obj.get(Str.port);
				for (Object value : values) {
					ports.add(new StringLongPair((String) ((JSONObject) value).get("Name"),
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
					obj.put(Str.productType, "GraphicCard");
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
				case "CoreNumber":
					if (this.coreNumber != null)
						obj.put("CoreNumber", this.coreNumber);
					break;
				case "ClockRate":
					if (this.clockRate != null)
						obj.put("ClockRate", this.clockRate);
					break;
				case "Fabrication":
					if (this.fabrication != null)
						obj.put("Fabrication", this.fabrication);
					break;
				case "TDP":
					if (this.tdp != null)
						obj.put("TDP", this.tdp);
					break;
				case "Chipset":
					if (this.chipset != null)
						obj.put("Chipset", this.chipset);
					break;
				case "Memory":
					if (this.memory != null)
						obj.put("Memory", this.memory.toJSONObject());
					break; // !!! CONVERT TO JSON NEEDED
				case "Slot":
					if (this.slot != null)
						obj.put("Slot", this.slot);
					break;
				case "Port":
					if (ports.size() != 0) {
						JSONArray values = new JSONArray();
						for (StringLongPair value : ports) {
							JSONObject slp = new JSONObject();
							slp.put("Name", value.name);
							slp.put("Number", value.num);
							values.add(slp);
						}
						obj.put("Port", values);
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
		keyArray.add(Str.quantity);
		keyArray.add(Str.coreNumber);
		keyArray.add(Str.clockRate);
		keyArray.add(Str.fabrication);
		keyArray.add(Str.tdp);
		keyArray.add(Str.chipset);
		keyArray.add(Str.memory);
		keyArray.add(Str.slot);
		keyArray.add(Str.port);
		obj.put("Keys", keyArray);
		try {
			return (JSONObject) (new JSONParser().parse(getAttribute(obj.toJSONString())));
		} catch (Exception ex) {
			System.out.println("Unexpected error occurred");
			return null;
		}
	}
}