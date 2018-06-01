import java.util.ArrayList;

abstract class Product {
    // Variable
    protected String name;
    protected int price;
    protected String manufacturer;

    // Setter & Getter
    public abstract String getProductType();

    public abstract void setAttribute(String attributes);
    //public abstract String getAttribute(String keys);
}