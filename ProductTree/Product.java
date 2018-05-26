abstract class Product {
    // Variable
    protected String name;
    protected int price;
    protected String manufacturer;

    // Setter & Getter
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }

    public abstract getProductType();

    public abstract inputAttribute();
    public abstract getAttribute();
}