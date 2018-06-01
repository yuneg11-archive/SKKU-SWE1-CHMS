import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

class Mainboard extends Product {
    // Variable
    private String chipset;
    private String formFactor;
    private String cpuSocket;
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
    		if(obj.containsKey("Price")) 		this.price 			= (Long)obj.get("Price");
    		if(obj.containsKey("Manufacturer")) this.manufacturer 	= (String)obj.get("Manufacturer");
    		if(obj.containsKey("Chipset"))		this.chipset 		= (String)obj.get("Chipset");
    		if(obj.containsKey("FormFactor"))	this.formFactor 	= (String)obj.get("FormFactor");
    		if(obj.containsKey("Socket"))		this.cpuSocket 		= (String)obj.get("Socket");
    		/*!!!NEED SLOTS AND PORTS*/
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
					case "ProductType":		obj.put(Str.productType, "Mainboard");
					case "Name":			if(this.name != null) obj.put("Name", this.name);
					case "Price": 			if(this.price != null) obj.put("Price", this.price);
					case "Manufacturer": 	if(this.manufacturer != null) obj.put("Manufacturer", this.manufacturer);
					case "Chipset": 		if(this.chipset != null) obj.put("Chipset", this.chipset);
					case "FormFactor": 		if(this.formFactor != null) obj.put("FormFactor", this.formFactor);
					case "Socket": 			if(this.cpuSocket != null) obj.put("Socket", this.cpuSocket);
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
		keyArray.add(Str.chipset);
		keyArray.add(Str.formFactor);
		keyArray.add(Str.cpuSocket);
    	return getAttribute(obj.toJSONString());
	}
}