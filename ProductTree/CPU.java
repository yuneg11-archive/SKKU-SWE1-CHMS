import JSON.JSONObject;
import JSON.parser.JSONParser;
import JSON.parser.ParseException;

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

    public void setAttribute(String attributes) {
    	try {
    		JSONObject obj = (JSONObject)(new JSONParser().parse(attributes));
    		if(obj.containsKey("Name")) 			this.name 			= (String)obj.get("Name");
    		if(obj.containsKey("Price")) 			this.price 			= Integer.parseInt((String)obj.get("Price"));
    		if(obj.containsKey("Manufacturer")) 	this.manufacturer 	= (String)obj.get("Manufacturer");
    		if(obj.containsKey("CoreNumber")) 		this.coreNumber 	= Integer.parseInt((String)obj.get("CoreNumber"));
    		if(obj.containsKey("ClockRate")) 		this.clockRate 		= Double.parseDouble((String)obj.get("ClockRate"));
    		if(obj.containsKey("Fabrication")) 		this.fabrication 	= Integer.parseInt((String)obj.get("Fabrication"));
    		if(obj.containsKey("TDP")) 				this.tdp 			= Integer.parseInt((String)obj.get("TDP"));
    		if(obj.containsKey("ImbeddedGraphic")) 	this.imbeddedGraphic = new ImbeddedGraphic(((JSONObject)obj.get("ImbeddedGraphic")).toJSONString());
    		if(obj.containsKey("CPUSocket")) 		this.cpuSocket 		= (String)obj.get("CPUSocket");
    	} catch(ParseException exc) {
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