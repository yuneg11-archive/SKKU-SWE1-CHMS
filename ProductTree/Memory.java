import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

class Memory extends Product {
	// Variable
    private Long capacity; // Unit: GB
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

    public void setAttribute(String attributes) {
    	try {
    		JSONObject obj = (JSONObject)(new JSONParser().parse(attributes));
    		if(obj.containsKey("Name")) 		this.name 			= (String)obj.get("Name");
    		if(obj.containsKey("Price")) 		this.price 			= (Long)obj.get("Price");
    		if(obj.containsKey("Manufacturer")) this.manufacturer 	= (String)obj.get("Manufacturer");
    		if(obj.containsKey("Capacity"))		this.capacity 		= (Long)obj.get("Capacity");
    		if(obj.containsKey("ClockRate"))	this.clockRate 		= (Long)obj.get("ClockRate");
    		if(obj.containsKey("ErrorCheck"))	this.errorCheck 	= (Boolean)obj.get("ErrorCheck");
    		if(obj.containsKey("Standard"))		this.standard 		= (String)obj.get("Standard");
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
					case "ProductType":		obj.put(Str.productType, "Memory");
					case "Name":			if(this.name != null) obj.put("Name", this.name);
					case "Price": 			if(this.price != null) obj.put("Price", this.price);
					case "Manufacturer": 	if(this.manufacturer != null) obj.put("Manufacturer", this.manufacturer);
					case "Capacity": 		if(this.capacity != null) obj.put("Capacity", this.capacity);
					case "ClockRate": 		if(this.clockRate != null) obj.put("ClockRate", this.clockRate);
					case "ErrorCheck": 		if(this.errorCheck != null) obj.put("ErrorCheck", this.errorCheck);
					case "Standard": 		if(this.standard != null) obj.put("Standard", this.standard);
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
		keyArray.add(Str.capacity);
		keyArray.add(Str.clockRate);
		keyArray.add(Str.errorCheck);
		keyArray.add(Str.standard);
		obj.put("Keys", keyArray);
    	try {
			return (JSONObject)(new JSONParser().parse(getAttribute(obj.toJSONString())));
		} catch(Exception ex) {
			System.out.println("Unexpected error occurred");
			return null;
		}
	}
}