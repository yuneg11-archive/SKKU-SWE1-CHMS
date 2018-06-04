import JSON.JSONObject;

import java.util.Scanner;

import JSON.JSONArray;
import JSON.parser.JSONParser;

class Case extends Product {
	// Variable
    private String formFactor;
    
    // Constructor
    public Case() {
		this.quantity = 1L;
    }
    public Case(String attributes) {
		this.quantity = 1L;
    	setAttribute(attributes);
    }
    
    // Setter & Getter
    public String getProductType() {
    	return "Case";
    }

    @Override
    public void insert() {
    	super.insert();
    	
    	Scanner s = new Scanner(System.in);    	

		System.out.print(" Form Factor: ");
		this.formFactor = s.nextLine();
		
		
    }
    
    public void setAttribute(String attributes) {
    	try {
    		JSONObject obj = (JSONObject)(new JSONParser().parse(attributes));
    		if(obj.containsKey(Str.name)) 		this.name 			= (String)obj.get(Str.name);
    		if(obj.containsKey(Str.price)) 		this.price 			= (Long)obj.get(Str.price);
			if(obj.containsKey(Str.manufacturer)) this.manufacturer = (String)obj.get(Str.manufacturer);
			if(obj.containsKey(Str.quantity))	this.quantity 		= (Long)obj.get(Str.quantity);
    		if(obj.containsKey(Str.formFactor))	this.formFactor 	= (String)obj.get(Str.formFactor);
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
					case "ProductType":		obj.put(Str.productType, "Case");break;
					case "Name":			if(this.name != null) obj.put(Str.name, this.name);break;
					case "Price": 			if(this.price != null) obj.put(Str.price, this.price);break;
					case "Manufacturer": 	if(this.manufacturer != null) obj.put(Str.manufacturer, this.manufacturer);break;
					case "Quantity": 		obj.put("Quantity", this.quantity);break;
					case "FormFactor": 		if(this.formFactor != null) obj.put(Str.formFactor, this.formFactor);break;
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
		keyArray.add(Str.formFactor);
		obj.put("Keys", keyArray);
		try {
			return (JSONObject)(new JSONParser().parse(getAttribute(obj.toJSONString())));
		} catch(Exception ex) {
			System.out.println("Unexpected error occurred");
			return null;
		}
	}
}