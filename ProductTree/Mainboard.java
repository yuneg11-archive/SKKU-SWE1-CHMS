import JSON.JSONObject;
import JSON.parser.JSONParser;

class Mainboard extends Product {
    // Variable
    private String chipset;
    private String formFactor;
    private String socket;
    private StringIntPair[] slots;
    private StringIntPair[] ports;

    // Constructor
    public Mainboard() {
    }
    public Mainboard(String attributes) {
    	setAttribute(attributes);
    }
    
    // Setter & Getter
    public String getProductType() {
    	return "Mainboard";
    }

    public void setAttribute(String attributes) {
    	try {
    		JSONObject obj = (JSONObject)(new JSONParser().parse(attributes));
    		if(obj.containsKey("Name")) 		this.name 			= (String)obj.get("Name");
    		if(obj.containsKey("Price")) 		this.price 			= Integer.parseInt((String)obj.get("Price"));
    		if(obj.containsKey("Manufacturer")) this.manufacturer 	= (String)obj.get("Manufacturer");
    		if(obj.containsKey("Chipset"))		this.chipset 		= (String)obj.get("Chipset");
    		if(obj.containsKey("FormFactor"))	this.formFactor 	= (String)obj.get("FormFactor");
    		if(obj.containsKey("Socket"))		this.socket 		= (String)obj.get("Socket");
    		/*!!!NEED SLOTS AND PORTS*/
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