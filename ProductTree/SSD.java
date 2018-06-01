import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

class SSD extends Storage {
	// Variable
    private String memoryType;
    private Long tbw; // Unit: TBW
    
 // Constructor
    public SSD() {
		this.quantity = 1L;
    }
    public SSD(String attributes) {
		this.quantity = 1L;
    	setAttribute(attributes);
    }
    
    // Setter & Getter
    public String getProductType() {
    	return "SSD";
    }

    public void setAttribute(String attributes) {
    	try {
    		JSONObject obj = (JSONObject)(new JSONParser().parse(attributes));
    		if(obj.containsKey("Name")) 		this.name 			= (String)obj.get("Name");
    		if(obj.containsKey("Price")) 		this.price 			= (Long)obj.get("Price");
			if(obj.containsKey("Manufacturer")) this.manufacturer 	= (String)obj.get("Manufacturer");
			if(obj.containsKey(Str.quantity))	this.quantity 		= (Long)obj.get(Str.quantity);
    		if(obj.containsKey("Capacity"))		this.capacity		= (Long)obj.get("Capacity");
    		if(obj.containsKey("ReadSpeed"))	this.readSpeed 		= (Long)obj.get("ReadSpeed");
    		if(obj.containsKey("WriteSpeed"))	this.writeSpeed 	= (Long)obj.get("WriteSpeed");
    		if(obj.containsKey("Slot"))			this.slot 			= (String)obj.get("Slot");
    		if(obj.containsKey("MemoryType"))	this.memoryType 	= (String)obj.get("MemoryType");
    		if(obj.containsKey("TBW"))			this.tbw 			= (Long)obj.get("TBW");
    	} catch(Exception exc) {
    		System.out.println("Unexpected error occurred");
    	}
    }
    public String getAttribute(String keys) {
    	try {
			JSONObject required = (JSONObject)(new JSONParser().parse(keys));
			JSONArray keyArray = (JSONArray)required.get("Keys");
    		JSONObject obj = new JSONObject();
    		for(Object key : keyArray) {
				switch((String)key) {
					case "ProductType":		obj.put(Str.productType, "SSD");
					case "Name":			if(this.name != null) obj.put("Name", this.name);
					case "Price": 			if(this.price != null) obj.put("Price", this.price);
					case "Manufacturer": 	if(this.manufacturer != null) obj.put("Manufacturer", this.manufacturer);
					case "Quantity": 		obj.put("Quantity", this.quantity);
					case "Capacity": 		if(this.capacity != null) obj.put("Capacity", this.capacity);
					case "ReadSpeed": 		if(this.readSpeed != null) obj.put("ReadSpeed", this.readSpeed);
					case "WriteSpeed": 		if(this.writeSpeed != null) obj.put("WriteSpeed", this.writeSpeed);
					case "Slot": 			if(this.slot != null) obj.put("Slot", this.slot);
					case "MemoryType": 		if(this.memoryType != null) obj.put("MemoryType", this.memoryType);
					case "TBW": 			if(this.tbw != null) obj.put("TBW", this.tbw);
				}
			}
    		return obj.toJSONString();
    	} catch(Exception exc) {
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
		keyArray.add(Str.capacity);
		keyArray.add(Str.readSpeed);
		keyArray.add(Str.writeSpeed);
		keyArray.add(Str.slot);
		keyArray.add(Str.memoryType);
		keyArray.add(Str.tbw);
		obj.put("Keys", keyArray);
    	try {
			return (JSONObject)(new JSONParser().parse(getAttribute(obj.toJSONString())));
		} catch(Exception ex) {
			System.out.println("Unexpected error occurred");
			return null;
		}
	}
}