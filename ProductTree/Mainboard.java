import java.util.ArrayList;

import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

class Mainboard extends Product {
    // Variable
    private String chipset;
    private String formFactor;
    private String cpuSocket;
    private ArrayList<StringLongPair> slots;
    private ArrayList<StringLongPair> ports;

    // Constructor
    public Mainboard() {
		this.quantity = 1L;
		slots = new ArrayList<StringLongPair>();
		ports = new ArrayList<StringLongPair>();
    }
    public Mainboard(String attributes) {
		this.quantity = 1L;
		slots = new ArrayList<StringLongPair>();
		ports = new ArrayList<StringLongPair>();
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
			if(obj.containsKey(Str.quantity))	this.quantity 		= (Long)obj.get(Str.quantity);
    		if(obj.containsKey("Chipset"))		this.chipset 		= (String)obj.get("Chipset");
    		if(obj.containsKey("FormFactor"))	this.formFactor 	= (String)obj.get("FormFactor");
    		if(obj.containsKey("Socket"))		this.cpuSocket 		= (String)obj.get("Socket");
    		if(obj.containsKey(Str.slot)) {
				JSONArray values = (JSONArray)obj.get(Str.slot);
				for(Object value : values) {
					slots.add(new StringLongPair((String)((JSONObject)value).get("Name"), (Long)((JSONObject)value).get("Number")));
				}
			}
			if(obj.containsKey(Str.port)) {
				JSONArray values = (JSONArray)obj.get(Str.port);
				for(Object value : values) {
					ports.add(new StringLongPair((String)((JSONObject)value).get("Name"), (Long)((JSONObject)value).get("Number")));
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
					case "ProductType":		obj.put(Str.productType, "Mainboard");
					case "Name":			if(this.name != null) obj.put("Name", this.name);
					case "Price": 			if(this.price != null) obj.put("Price", this.price);
					case "Manufacturer": 	if(this.manufacturer != null) obj.put("Manufacturer", this.manufacturer);
					case "Quantity": 		obj.put("Quantity", this.quantity);
					case "Chipset": 		if(this.chipset != null) obj.put("Chipset", this.chipset);
					case "FormFactor": 		if(this.formFactor != null) obj.put("FormFactor", this.formFactor);
					case "Socket": 			if(this.cpuSocket != null) obj.put("Socket", this.cpuSocket);
					case "Slot":			if(slots.size() != 0) {
												JSONArray values = new JSONArray();
												for(StringLongPair value : slots) {
													JSONObject slp = new JSONObject();
													slp.put("Name", value.name);
													slp.put("Number", value.num);
													values.add(slp);
												}
												obj.put("Slot", values);
											}
					case "Port":			if(ports.size() != 0) {
												JSONArray values = new JSONArray();
												for(StringLongPair value : ports) {
													JSONObject slp = new JSONObject();
													slp.put("Name", value.name);
													slp.put("Number", value.num);
													values.add(slp);
												}
												obj.put("Port", values);
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
		keyArray.add(Str.quantity);
		keyArray.add(Str.chipset);
		keyArray.add(Str.formFactor);
		keyArray.add(Str.cpuSocket);
		keyArray.add(Str.slot);
		keyArray.add(Str.port);
		obj.put("Keys", keyArray);
    	try {
			return (JSONObject)(new JSONParser().parse(getAttribute(obj.toJSONString())));
		} catch(Exception ex) {
			System.out.println("Unexpected error occurred");
			return null;
		}
	}
}