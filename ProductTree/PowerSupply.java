import JSON.JSONObject;
import JSON.parser.JSONParser;

class PowerSupply extends Product {
	// Variable
    private int ratedOutput; // Unit: W
    private String formFactor;
    private String certification;
    private StringIntPair[] connectors;
    
    // Constructor
    public PowerSupply() {
    }
    public PowerSupply(String attributes) {
    	setAttribute(attributes);
    }
    
    // Setter & Getter
    public String getProductType() {
    	return "PowerSupply";
    }

    public void setAttribute(String attributes) {
    	try {
    		JSONObject obj = (JSONObject)(new JSONParser().parse(attributes));
    		if(obj.containsKey("Name")) 		this.name 			= (String)obj.get("Name");
    		if(obj.containsKey("Price")) 		this.price 			= Integer.parseInt((String)obj.get("Price"));
    		if(obj.containsKey("Manufacturer")) this.manufacturer 	= (String)obj.get("Manufacturer");
    		if(obj.containsKey("RatedOutput"))	this.ratedOutput 	= Integer.parseInt((String)obj.get("RatedOutput"));
    		if(obj.containsKey("FormFactor"))	this.formFactor 	= (String)obj.get("FormFactor");
    		if(obj.containsKey("Certification"))this.certification 	= (String)obj.get("Certification");
    		/*!!! CONNECTORS NEEDED*/
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