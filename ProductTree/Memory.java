import JSON.JSONObject;
import JSON.parser.JSONParser;

class Memory extends Product {
	// Variable
    private int capacity; // Unit: GB
    private int clockRate; // Unit: MHz
    private boolean errorCheck; // ECC
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
    		if(obj.containsKey("Price")) 		this.price 			= Integer.parseInt((String)obj.get("Price"));
    		if(obj.containsKey("Manufacturer")) this.manufacturer 	= (String)obj.get("Manufacturer");
    		if(obj.containsKey("Capacity"))		this.capacity 		= Integer.parseInt((String)obj.get("Capacity"));
    		if(obj.containsKey("ClockRate"))	this.clockRate 		= Integer.parseInt((String)obj.get("ClockRate"));
    		if(obj.containsKey("ErrorCheck"))	this.errorCheck 	= Boolean.parseBoolean((String)obj.get("ErrorCheck"));
    		if(obj.containsKey("Standard"))		this.standard 		= (String)obj.get("Standard");
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