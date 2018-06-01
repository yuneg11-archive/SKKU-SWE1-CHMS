import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

class PowerSupply extends Product {
	// Variable
    private Long ratedOutput; // Unit: W
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
    		if(obj.containsKey("Price")) 		this.price 			= (Long)obj.get("Price");
    		if(obj.containsKey("Manufacturer")) this.manufacturer 	= (String)obj.get("Manufacturer");
    		if(obj.containsKey("RatedOutput"))	this.ratedOutput 	= (Long)obj.get("RatedOutput");
    		if(obj.containsKey("FormFactor"))	this.formFactor 	= (String)obj.get("FormFactor");
    		if(obj.containsKey("Certification"))this.certification 	= (String)obj.get("Certification");
    		/*!!! CONNECTORS NEEDED*/
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
					case "ProductType":		obj.put(Str.productType, "PowerSupply");
					case "Name":			if(this.name != null) obj.put("Name", this.name);
					case "Price": 			if(this.price != null) obj.put("Price", this.price);
					case "Manufacturer": 	if(this.manufacturer != null) obj.put("Manufacturer", this.manufacturer);
					case "RatedOutput": 	if(this.ratedOutput != null) obj.put("RatedOutput", this.ratedOutput);
					case "FormFactor": 		if(this.formFactor != null) obj.put("FormFactor", this.formFactor);
					case "Certification": 	if(this.certification != null) obj.put("Certification", this.certification);
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
		keyArray.add(Str.ratedOutput);
		keyArray.add(Str.formFactor);
		keyArray.add(Str.certification);
		obj.put("Keys", keyArray);
    	return getAttribute(obj.toJSONString());
	}
}