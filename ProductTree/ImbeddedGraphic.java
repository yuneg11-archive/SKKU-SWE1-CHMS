import JSON.JSONObject;
import JSON.parser.JSONParser;

class ImbeddedGraphic extends Graphic {
	// Variable
    private int systemMemoryAlloc;
    
    // Constructor
    public ImbeddedGraphic() {
    }
    public ImbeddedGraphic(String attributes) {
    	setAttribute(attributes);
    }
    
    // Setter & Getter
    public String getProductType() {
    	return "ImbeddedGraphic";
    }

    public void setAttribute(String attributes) {
    	try {
    		JSONObject obj = (JSONObject)(new JSONParser().parse(attributes));
    		if(obj.containsKey("Name")) 					this.name 				= (String)obj.get("Name");
    		if(obj.containsKey("Manufacturer")) 			this.manufacturer 		= (String)obj.get("Manufacturer");
    		if(obj.containsKey("CoreNumber"))				this.coreNumber 		= Integer.parseInt((String)obj.get("CoreNumber"));
    		if(obj.containsKey("Fabrication"))				this.fabrication 		= Integer.parseInt((String)obj.get("Fabrication"));
    		if(obj.containsKey("TDP"))						this.tdp 				= Integer.parseInt((String)obj.get("TDP"));
    		if(obj.containsKey("SystemMemoryAllocation"))	this.systemMemoryAlloc 	= Integer.parseInt((String)obj.get("SystemMemoryAllocation"));
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