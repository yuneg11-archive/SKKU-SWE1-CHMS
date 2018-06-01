import JSON.JSONObject;
import JSON.parser.JSONParser;

class HDD extends Storage {
	// Variable
    private String diskSize;
    private int rpm;
    
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
    		if(obj.containsKey("Price")) 		this.price 			= Integer.parseInt((String)obj.get("Price"));
    		if(obj.containsKey("Manufacturer")) this.manufacturer 	= (String)obj.get("Manufacturer");
    		if(obj.containsKey("Capacity"))		this.capacity 		= Integer.parseInt((String)obj.get("Capacity"));
    		if(obj.containsKey("ReadSpeed"))	this.readSpeed 		= Integer.parseInt((String)obj.get("ReadSpeed"));
    		if(obj.containsKey("WriteSpeed"))	this.writeSpeed 	= Integer.parseInt((String)obj.get("WriteSpeed"));
    		if(obj.containsKey("Slot"))			this.slot 			= (String)obj.get("Slot");
    		if(obj.containsKey("DiskSize"))		this.diskSize 		= (String)obj.get("DiskSize");
    		if(obj.containsKey("RPM"))			this.rpm 			= Integer.parseInt((String)obj.get("RPM"));
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