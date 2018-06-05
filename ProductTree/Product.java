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
                System.out.print(" Name: ");
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

}