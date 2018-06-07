import JSON.JSONObject;

import java.util.Scanner;

import JSON.JSONArray;
import JSON.parser.JSONParser;

class ImbeddedGraphic extends Graphic {
	// Variable
	private Long systemMemoryAlloc;// Unit: MB

	// Constructor
	public ImbeddedGraphic() {
		this.productType = "ImbeddedGraphic";
	}

	public ImbeddedGraphic(String attributes) {
		this.productType = "ImbeddedGraphic";
		setAttribute(attributes);
	}

	// Setter & Getter
	public void insert(String excludeKeys) {
		try {
			JSONObject exclude = (JSONObject) (new JSONParser().parse(excludeKeys));
			JSONArray keyArray = (JSONArray) exclude.get("ExcludeKey");
			keyArray.add(Str.memory);
			keyArray.add(Str.price);
			keyArray.add(Str.name);
			keyArray.add(Str.tdp);
			super.insert(exclude.toJSONString());
			Scanner s = new Scanner(System.in);

			if (!keyArray.contains(Str.systemMemoryAlloc)) {
				System.out.print(" System Memory Allocation (MB): ");
				this.systemMemoryAlloc = s.nextLong();
				s.nextLine();
			}
		} catch (Exception exc) {
			System.out.println("Unexpected error occurred");
		}
	}

	public void print(String excludeKeys) {
		try {
			JSONObject exclude = (JSONObject) (new JSONParser().parse(excludeKeys));
			JSONArray keyArray = (JSONArray) exclude.get("ExcludeKey");
			keyArray.add(Str.memory);
			keyArray.add(Str.price);
			keyArray.add(Str.name);
			keyArray.add(Str.tdp);
			super.print(exclude.toJSONString());

			if (!keyArray.contains(Str.systemMemoryAlloc))
				System.out.println(UI.content("System Memory Allocation: "+this.systemMemoryAlloc+"MB"));

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
			if (obj.containsKey("Manufacturer"))
				this.manufacturer = (String) obj.get("Manufacturer");
			if (obj.containsKey(Str.coreNumber))
				this.coreNumber = (Long) obj.get(Str.coreNumber);
			if (obj.containsKey(Str.clockRate))
				this.clockRate = (Double) obj.get(Str.clockRate);
			if (obj.containsKey(Str.chipset))
				this.chipset = (String) obj.get(Str.chipset);
			if (obj.containsKey("Fabrication"))
				this.fabrication = (Long) obj.get("Fabrication");
			if (obj.containsKey("SystemMemoryAllocation"))
				this.systemMemoryAlloc = (Long) obj.get("SystemMemoryAllocation");
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
					obj.put(Str.productType, "ImbeddedGraphic");
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
					if (this.coreNumber != null)
						obj.put(Str.clockRate, this.coreNumber);
					break;
				case "Fabrication":
					if (this.fabrication != null)
						obj.put("Fabrication", this.fabrication);
					break;
				case "Chipset":
					if (this.tdp != null)
						obj.put(Str.chipset, this.tdp);
					break;
				case "SystemMemoryAllocation":
					if (this.systemMemoryAlloc != null)
						obj.put("SystemMemoryAllocation", this.systemMemoryAlloc);
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
		keyArray.add(Str.manufacturer);
		keyArray.add(Str.clockRate);
		keyArray.add(Str.fabrication);
		keyArray.add(Str.coreNumber);
		keyArray.add(Str.chipset);
		keyArray.add(Str.systemMemoryAlloc);
		obj.put("Keys", keyArray);
		try {
			return (JSONObject) (new JSONParser().parse(getAttribute(obj.toJSONString())));
		} catch (Exception ex) {
			System.out.println("Unexpected error occurred");
			return null;
		}
	}
}