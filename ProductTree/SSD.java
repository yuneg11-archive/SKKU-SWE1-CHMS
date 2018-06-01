import JSON.JSONObject;
import JSON.parser.JSONParser;

class SSD extends Storage {
	// Variable
    private String memoryType;
    private int tbw; // Unit: TBW
    
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

    public void setAttribute(String attributes) {
    	try {
    		JSONObject obj = (JSONObject)(new JSONParser().parse(attributes));
    		if(obj.containsKey("Name")) 		this.name 			= (String)obj.get("Name");
    		if(obj.containsKey("Price")) 		this.price 			= Integer.parseInt((String)obj.get("Price"));
    		if(obj.containsKey("Manufacturer")) this.manufacturer 	= (String)obj.get("Manufacturer");
    		if(obj.containsKey("Capacity"))		this.capacity		= Integer.parseInt((String)obj.get("Capacity"));
    		if(obj.containsKey("ReadSpeed"))	this.readSpeed 		= Integer.parseInt((String)obj.get("ReadSpeed"));
    		if(obj.containsKey("WriteSpeed"))	this.writeSpeed 	= Integer.parseInt((String)obj.get("WriteSpeed"));
    		if(obj.containsKey("Slot"))			this.slot 			= (String)obj.get("Slot");
    		if(obj.containsKey("MemoryType"))	this.memoryType 	= (String)obj.get("MemoryType");
    		if(obj.containsKey("TBW"))			this.tbw 			= Integer.parseInt((String)obj.get("TBW"));
    	} catch(Exception exc) {
    		System.out.println("Unexpected error occurred");
    	}
    }
    /*public String getAttribute(String keys) {
    	try {
    		JSONObject required = (JSONObject)(new JSONParser().parse(keys));
    		JSONObject obj = new JSONObject();
    		
    		//for()
    		
    		return "";
    	} catch(Exception exc) {
    		System.out.println("Unexpected error occurred");
    		return null;
    	}
    }*/
}