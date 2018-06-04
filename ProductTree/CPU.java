import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

import java.util.Scanner;

class CPU extends Processor {
	// Variable
    private ImbeddedGraphic imbeddedGraphic;
    private String cpuSocket;
    
    // Constructor
    public CPU() {
    }
    public CPU(String attributes) {
    	setAttribute(attributes);
    }
    
    // Setter & Getter
    public String getProductType() {
    	return "CPU";
    }
    
    @Override
    public void insert() {
    	super.insert();
    	
    	Scanner s = new Scanner(System.in);
    	
    	System.out.print(" CPU Socket: ");		
		this.cpuSocket = s.nextLine();
		
		while(true) {
			System.out.print(" Has Imbedded Graphic? (Y/N): ");
			
			if(s.nextLine().compareTo("Y")==0) {
				System.out.println("===============Imbedded Graphic===============");
				ImbeddedGraphic imb = new ImbeddedGraphic();
				imb.insert();
				this.imbeddedGraphic = imb;
				break;
			}
			else if(s.nextLine().compareTo("N")==0) break;
			else System.out.println("Invalid Input");
		}
		
		
		
		
	}
    
    public void setAttribute(String attributes) {
    	try {
    		JSONObject obj = (JSONObject)(new JSONParser().parse(attributes));
    		if(obj.containsKey("Name")) 			this.name 			= (String)obj.get("Name");
    		if(obj.containsKey("Price")) 			this.price 			= (Long)obj.get("Price");
			if(obj.containsKey("Manufacturer")) 	this.manufacturer 	= (String)obj.get("Manufacturer");
    		if(obj.containsKey("CoreNumber")) 		this.coreNumber 	= (Long)obj.get("CoreNumber");
    		if(obj.containsKey("ClockRate")) 		this.clockRate 		= (Double)obj.get("ClockRate");
    		if(obj.containsKey("Fabrication")) 		this.fabrication 	= (Long)obj.get("Fabrication");
    		if(obj.containsKey("TDP")) 				this.tdp 			= (Long)obj.get("TDP");
    		if(obj.containsKey("ImbeddedGraphic")) 	this.imbeddedGraphic = new ImbeddedGraphic(((JSONObject)obj.get("ImbeddedGraphic")).toJSONString());
    		if(obj.containsKey("CPUSocket")) 		this.cpuSocket 		= (String)obj.get("CPUSocket");
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
					case "ProductType":		obj.put(Str.productType, "CPU");break;
					case "Name":			if(this.name != null) obj.put("Name", this.name);break;
					case "Price": 			if(this.price != null) obj.put("Price", this.price);break;
					case "Manufacturer": 	if(this.manufacturer != null) obj.put("Manufacturer", this.manufacturer);break;
					case "CoreNumber": 		if(this.coreNumber != null) obj.put("CoreNumber", this.coreNumber);break;
					case "ClockRate": 		if(this.clockRate != null) obj.put("ClockRate", this.clockRate);break;
					case "Fabrication": 	if(this.fabrication != null) obj.put("Fabrication", this.fabrication);break;
					case "TDP": 			if(this.tdp != null) obj.put("TDP", this.tdp);break;
					case "ImbeddedGraphic": if(this.imbeddedGraphic != null) obj.put("ImbeddedGraphic", this.imbeddedGraphic.toJSONObject());break; //!!! CONVERT TO JSON NEEDED
					case "CPUSocket": 		if(this.cpuSocket != null) obj.put("CPUSocket", this.cpuSocket);
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
		keyArray.add(Str.coreNumber);
		keyArray.add(Str.clockRate);
		keyArray.add(Str.fabrication);
		keyArray.add(Str.tdp);
		keyArray.add(Str.imbeddedGraphic);
		keyArray.add(Str.cpuSocket);
		obj.put("Keys", keyArray);
    	try {
			return (JSONObject)(new JSONParser().parse(getAttribute(obj.toJSONString())));
		} catch(Exception ex) {
			System.out.println("Unexpected error occurred");
			return null;
		}
    	
	}
	
}