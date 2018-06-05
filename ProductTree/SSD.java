import java.util.Scanner;
import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

class SSD extends Storage {
	// Variable
	private String memoryType;
	private Long tbw; // Unit: TBW

	// Constructor
	public SSD() {
	}

	public SSD(String attributes) {
		setAttribute(attributes);
	}

	// Setter & Getter
	public String getProductType() {
		return "SSD";
	}

	
	public void insert(String excludeKeys) {
		super.insert(excludeKeys);

		try {
			JSONObject required = (JSONObject) (new JSONParser().parse(excludeKeys));
			JSONArray keyArray = (JSONArray) required.get("ExcludeKey");
			Scanner s = new Scanner(System.in);

			if (!keyArray.contains(Str.memoryType)) {
				System.out.print(" Flash Memory Type: ");
				this.memoryType = s.nextLine();
			}

			if (!keyArray.contains(Str.tbw)) {
				System.out.print(" TBW (Tera Byte Written): ");
				this.tbw = s.nextLong();
				s.nextLine();
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
			if (obj.containsKey("ReadSpeed"))
				this.readSpeed = (Long) obj.get("ReadSpeed");
			if (obj.containsKey("WriteSpeed"))
				this.writeSpeed = (Long) obj.get("WriteSpeed");
			if (obj.containsKey("Slot"))
				this.slot = (String) obj.get("Slot");
			if (obj.containsKey("MemoryType"))
				this.memoryType = (String) obj.get("MemoryType");
			if (obj.containsKey("TBW"))
				this.tbw = (Long) obj.get("TBW");
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
					obj.put(Str.productType, "SSD");
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
				case "ReadSpeed":
					if (this.readSpeed != null)
						obj.put("ReadSpeed", this.readSpeed);
					break;
				case "WriteSpeed":
					if (this.writeSpeed != null)
						obj.put("WriteSpeed", this.writeSpeed);
					break;
				case "Slot":
					if (this.slot != null)
						obj.put("Slot", this.slot);
					break;
				case "MemoryType":
					if (this.memoryType != null)
						obj.put("MemoryType", this.memoryType);
					break;
				case "TBW":
					if (this.tbw != null)
						obj.put("TBW", this.tbw);
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
		keyArray.add(Str.readSpeed);
		keyArray.add(Str.writeSpeed);
		keyArray.add(Str.slot);
		keyArray.add(Str.memoryType);
		keyArray.add(Str.tbw);
		obj.put("Keys", keyArray);
		try {
			return (JSONObject) (new JSONParser().parse(getAttribute(obj.toJSONString())));
		} catch (Exception ex) {
			System.out.println("Unexpected error occurred");
			return null;
		}
	}
}