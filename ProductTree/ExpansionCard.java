import JSON.JSONObject;
import JSON.parser.JSONParser;

class ExpansionCard extends Product {
	// Variable
    private String slot;
    private String function;
    
    // Constructor
    public ExpansionCard() {
    }
    public ExpansionCard(String attributes) {
    	setAttribute(attributes);
    }
    
    // Setter & Getter
    public String getProductType() {
    	return "ExpansionCard";
    }

    public void setAttribute(String attributes) {
    	try {
    		JSONObject obj = (JSONObject)(new JSONParser().parse(attributes));
    		if(obj.containsKey("Name")) 		this.name 			= (String)obj.get("Name");
    		if(obj.containsKey("Price")) 		this.price 			= Integer.parseInt((String)obj.get("Price"));
    		if(obj.containsKey("Manufacturer")) this.manufacturer 	= (String)obj.get("Manufacturer");
    		if(obj.containsKey("Slot"))			this.slot 			= (String)obj.get("Slot");
    		if(obj.containsKey("Function"))		this.function 		= (String)obj.get("Function");
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