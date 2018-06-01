abstract class Product {
    // Variable
    protected String name;
    protected Long price;
    protected String manufacturer;

    // Setter & Getter
    public abstract String getProductType();
    public abstract void setAttribute(String attributes);
    public abstract String getAttribute(String keys);
    public abstract String toJSONString();
}