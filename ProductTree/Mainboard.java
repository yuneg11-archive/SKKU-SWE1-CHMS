import java.util.ArrayList;
import java.util.Scanner;

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

    @Override
    public void insert() {
    	super.insert();
    	
    	Scanner s = new Scanner(System.in);    	
    	long types;
    	String name;
    	long num;
    	
    	System.out.print(" Chipset: ");
		this.chipset = s.nextLine();
		
		System.out.print(" Form Factor: ");
		this.formFactor = s.nextLine();
		
		System.out.print(" CPU Socket: ");
		this.cpuSocket = s.nextLine();
		
		System.out.print(" How many types of slots?: ");
		types = s.nextLong();
		s.nextLine();
		for(int i=0; i<types; i++) {
			System.out.printf(" Name of slot type %d: ",i+1);
			name = s.nextLine();
			System.out.printf(" Number of slot type %d: ",i+1);
			num = s.nextLong();
			s.nextLine();
			this.slots.add(new StringLongPair(name, num));
		}
		
		System.out.print(" How many types of ports?: ");
		types = s.nextLong();
		s.nextLine();
		for(int i=0; i<types; i++) {
			System.out.printf(" Name of port type %d: ",i+1);
			name = s.nextLine();
			System.out.printf(" Number of port type %d: ",i+1);
			num = s.nextLong();
			s.nextLine();
			this.ports.add(new StringLongPair(name, num));
		}		

		
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
					case "ProductType":		obj.put(Str.productType, "Mainboard");break;
					case "Name":			if(this.name != null) obj.put("Name", this.name);break;
					case "Price": 			if(this.price != null) obj.put("Price", this.price);break;
					case "Manufacturer": 	if(this.manufacturer != null) obj.put("Manufacturer", this.manufacturer);break;
					case "Quantity": 		obj.put("Quantity", this.quantity);break;
					case "Chipset": 		if(this.chipset != null) obj.put("Chipset", this.chipset);break;
					case "FormFactor": 		if(this.formFactor != null) obj.put("FormFactor", this.formFactor);break;
					case "Socket": 			if(this.cpuSocket != null) obj.put("Socket", this.cpuSocket);break;
					case "Slot":			if(slots.size() != 0) {
												JSONArray values = new JSONArray();
												for(StringLongPair value : slots) {
													JSONObject slp = new JSONObject();
													slp.put("Name", value.name);
													slp.put("Number", value.num);
													values.add(slp);
												}
												obj.put("Slot", values);
											}break;
					case "Port":			if(ports.size() != 0) {
												JSONArray values = new JSONArray();
												for(StringLongPair value : ports) {
													JSONObject slp = new JSONObject();
													slp.put("Name", value.name);
													slp.put("Number", value.num);
													values.add(slp);
												}
												obj.put("Port", values);
											}break;
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