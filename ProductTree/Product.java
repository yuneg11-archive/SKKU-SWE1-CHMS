import java.util.ArrayList;

abstract class Product {
    // Variable
    protected String name;
    protected int price;
    protected String manufacturer;

    // Setter & Getter
    public abstract String getProductType();

    public abstract void setAttributes(ArrayList<StringStringPair> attributes);
    public abstract void setAttribute(StringStringPair attribute);
    public abstract ArrayList<StringStringPair> getAttributes();
    public abstract String getAttribute(String name);
}