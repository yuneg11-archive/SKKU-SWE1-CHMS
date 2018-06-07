import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

abstract class Product {
    // Variable
    protected String productType;
    protected String name;
    protected Long price;
    protected String manufacturer;

    // Setter & Getter
    public abstract void setAttribute(String attributes);

    public abstract String getAttribute(String keys);

    public abstract JSONObject toJSONObject();

    public String getProductType(){
        return productType;
    }

    public void insert(String excludeKeys) {
        try {
            JSONObject required = (JSONObject) (new JSONParser().parse(excludeKeys));
            JSONArray keyArray = (JSONArray) required.get("ExcludeKey");

            if (!keyArray.contains(Str.name))
                this.name = UI.inputLine("Name (Used as ID)");

            if (!keyArray.contains(Str.price))
                this.price = UI.inputLong("Price (Won)");

            if (!keyArray.contains(Str.manufacturer))
                this.manufacturer = UI.inputLine("Manufacturer");
        } catch (Exception exc) {
            System.out.println("Unexpected error occurred");
        }
    }

    public void print(String excludeKeys) {
        try {
            JSONObject required = (JSONObject) (new JSONParser().parse(excludeKeys));
            JSONArray keyArray = (JSONArray) required.get("ExcludeKey");

            if (!keyArray.contains(Str.name))
                System.out.println(UI.content("Name: "+this.name));

            if (!keyArray.contains(Str.price))
                System.out.println(UI.content("Price: "+this.price+"Won"));

            if (!keyArray.contains(Str.manufacturer))
                System.out.println(UI.content("Manufacturer: "+this.manufacturer));

        } catch (Exception exc) {
            System.out.println("Unexpected error occurred");
        }
    }
}