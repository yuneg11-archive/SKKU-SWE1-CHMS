import JSON.JSONObject;

import java.util.Scanner;

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

    @Override
    public void insert() {
    	super.insert();
    	
    	Scanner s = new Scanner(System.in);    	
    	
    	System.out.print(" Flash Memory Type: ");
		this.memoryType = s.nextLine();
		
		System.out.print(" TBW (Tera Byte Written): ");
		this.tbw = s.nextLong();
		s.nextLine();
		
		
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
					case "ProductType":		obj.put(Str.productType, "SSD");break;
					case "Name":			if(this.name != null) obj.put("Name", this.name);break;
					case "Price": 			if(this.price != null) obj.put("Price", this.price);break;
					case "Manufacturer": 	if(this.manufacturer != null) obj.put("Manufacturer", this.manufacturer);break;
					case "Quantity": 		obj.put("Quantity", this.quantity);break;
					case "Capacity": 		if(this.capacity != null) obj.put("Capacity", this.capacity);break;
					case "ReadSpeed": 		if(this.readSpeed != null) obj.put("ReadSpeed", this.readSpeed);break;
					case "WriteSpeed": 		if(this.writeSpeed != null) obj.put("WriteSpeed", this.writeSpeed);break;
					case "Slot": 			if(this.slot != null) obj.put("Slot", this.slot);break;
					case "MemoryType": 		if(this.memoryType != null) obj.put("MemoryType", this.memoryType);break;
					case "TBW": 			if(this.tbw != null) obj.put("TBW", this.tbw);break;
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