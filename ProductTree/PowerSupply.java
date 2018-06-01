import java.util.ArrayList;

import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

class PowerSupply extends Product {
	// Variable
    private Long ratedOutput; // Unit: W
    private String formFactor;
    private String certification;
    private ArrayList<StringLongPair> connectors;
    
    // Constructor
    public PowerSupply() {
		connectors = new ArrayList<>();
    }
    public PowerSupply(String attributes) {
		connectors = new ArrayList<>();
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
    		if(obj.containsKey(Str.connector)) {
				JSONArray values = (JSONArray)obj.get(Str.connector);
				for(Object value : values) {
					connectors.add(new StringLongPair((String)((JSONObject)value).get("Name"), (Long)((JSONObject)value).get("Number")));
				}
			}
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
					case "Port":			if(connectors.size() != 0) {
												JSONArray values = new JSONArray();
												for(StringLongPair value : connectors) {
													JSONObject slp = new JSONObject();
													slp.put("Name", value.name);
													slp.put("Number", value.num);
													values.add(slp);
												}
												obj.put("Connector", values);
											}
				}
			}
    		return obj.toJSONString();
    	} catch(Exception exc) {
    		System.out.println("Unexpected error occurred");
    		return null;
    	}
	}
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();
		JSONArray keyArray = new JSONArray();
		keyArray.add(Str.productType);
		keyArray.add(Str.name);
		keyArray.add(Str.price);
		keyArray.add(Str.manufacturer);
		keyArray.add(Str.ratedOutput);
		keyArray.add(Str.formFactor);
		keyArray.add(Str.certification);
		keyArray.add(Str.connector);
		obj.put("Keys", keyArray);
    	try {
			return (JSONObject)(new JSONParser().parse(getAttribute(obj.toJSONString())));
		} catch(Exception ex) {
			System.out.println("Unexpected error occurred");
			return null;
		}
	}
}