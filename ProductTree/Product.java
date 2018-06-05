import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;
import java.util.Scanner;

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

    public void insert(String excludeKeys) {
        Scanner s = new Scanner(System.in);
        try {
            JSONObject required = (JSONObject) (new JSONParser().parse(excludeKeys));
            JSONArray keyArray = (JSONArray) required.get("ExcludeKey");

            if (!keyArray.contains(Str.name)) {
                System.out.print(" Name (Name is unique): ");
                this.name = s.nextLine();
            }

            if (!keyArray.contains(Str.price)) {
                System.out.print(" Price (Won): ");
                this.price = s.nextLong();
                s.nextLine();
            }

            if (!keyArray.contains(Str.manufacturer)) {
                System.out.print(" Manufacturer: ");
                this.manufacturer = s.nextLine();
            }
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