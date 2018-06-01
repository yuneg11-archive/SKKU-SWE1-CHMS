import java.util.ArrayList;

class Mainboard extends Product {
    // Variable
    private String chipset;
    private String formFactor;
    private String socket;
    private StringIntPair[] slots;
    private StringIntPair[] ports;

    // Setter & Getter
    public String getProductType() {
        return "Mainboard";
    }

    public void setAttributes(ArrayList<StringStringPair> attributes) {

    }
    public void setAttribute(StringStringPair attribute) {

    }
    public ArrayList<StringStringPair> getAttributes() {

    }
    public String getAttribute(String name) {
        switch(name) {
            case "Chipset" : return chipset;
            case "FormFactor" : return formFactor;
            case "Socket" : return socket;
            
            default : return "Invalid attribute";
        }
    }
}