import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

class HDD extends Storage {
	// Variable
    private String diskSize;
    private Long rpm;
    
 // Constructor
    public HDD() {
    }
    public HDD(String attributes) {
    	setAttribute(attributes);
    }
    
    // Setter & Getter
    public String getProductType() {
    	return "HDD";
    }

    public void setAttribute(String attributes) {
    	try {
    		JSONObject obj = (JSONObject)(new JSONParser().parse(attributes));
    		if(obj.containsKey("Name")) 		this.name 			= (String)obj.get("Name");
    		if(obj.containsKey("Price")) 		this.price 			= (Long)obj.get("Price");
    		if(obj.containsKey("Manufacturer")) this.manufacturer 	= (String)obj.get("Manufacturer");
    		if(obj.containsKey("Capacity"))		this.capacity 		= (Long)obj.get("Capacity");
    		if(obj.containsKey("ReadSpeed"))	this.readSpeed 		= (Long)obj.get("ReadSpeed");
    		if(obj.containsKey("WriteSpeed"))	this.writeSpeed 	= (Long)obj.get("WriteSpeed");
    		if(obj.containsKey("Slot"))			this.slot 			= (String)obj.get("Slot");
    		if(obj.containsKey("DiskSize"))		this.diskSize 		= (String)obj.get("DiskSize");
    		if(obj.containsKey("RPM"))			this.rpm 			= (Long)obj.get("RPM");
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
					case "ProductType":		obj.put(Str.productType, "HDD");
					case "Name":			if(this.name != null) obj.put("Name", this.name);
					case "Price": 			if(this.price != null) obj.put("Price", this.price);
					case "Manufacturer": 	if(this.manufacturer != null) obj.put("Manufacturer", this.manufacturer);
					case "Capacity": 		if(this.capacity != null) obj.put("Capacity", this.capacity);
					case "ReadSpeed": 		if(this.readSpeed != null) obj.put("ReadSpeed", this.readSpeed);
					case "WriteSpeed": 		if(this.writeSpeed != null) obj.put("WriteSpeed", this.writeSpeed);
					case "Slot": 			if(this.slot != null) obj.put("Slot", this.slot);
					case "DiskSize": 		if(this.diskSize != null) obj.put("DiskSize", this.diskSize);
					case "RPM": 			if(this.rpm != null) obj.put("RPM", this.rpm);
				}
			}
    		return obj.toJSONString();
    	} catch(Exception exc) {
    		System.out.println("Unexpected error occurred");
    		return null;
    	}
	}
	public String toJSONString() {
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
		keyArray.add(Str.diskSize);
		keyArray.add(Str.rpm);
		obj.put("Keys", keyArray);
    	return getAttribute(obj.toJSONString());
	}
}