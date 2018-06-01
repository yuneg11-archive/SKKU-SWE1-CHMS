import JSON.JSONObject;
import JSON.parser.JSONParser;
import JSON.parser.ParseException;

class Case extends Product {
	// Variable
    private String formFactor;
    
    // Constructor
    public Case() {
    }
    public Case(String attributes) {
    	setAttribute(attributes);
    }
    
    // Setter & Getter
    public String getProductType() {
    	return "Case";
    }

    public void setAttribute(String attributes) {
    	try {
    		JSONObject obj = (JSONObject)(new JSONParser().parse(attributes));
    		if(obj.containsKey("Name")) 		this.name 			= (String)obj.get("Name");
    		if(obj.containsKey("Price")) 		this.price 			= Integer.parseInt((String)obj.get("Price"));
    		if(obj.containsKey("Manufacturer")) this.manufacturer 	= (String)obj.get("Manufacturer");
    		if(obj.containsKey("FormFactor"))	this.formFactor 	= (String)obj.get("FormFactor");
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