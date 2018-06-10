public class Str {
    public static String productType = "ProductType";
    public static String name = "Name";
    public static String price = "Price";
    public static String manufacturer = "Manufacturer";
    public static String quantity = "Quantity";
    public static String formFactor = "FormFactor";
    public static String coreNumber = "CoreNumber";
    public static String clockRate = "ClockRate";
    public static String fabrication = "Fabrication";
    public static String tdp = "TDP";
    public static String imbeddedGraphic = "ImbeddedGraphic";
    public static String cpuSocket = "CPUSocket";
    public static String slot = "Slot";
    public static String function = "Function";
    public static String chipset = "Chipset";
    public static String memory = "Memory";
    public static String capacity = "Capacity";
    public static String readSpeed = "ReadSpeed";
    public static String writeSpeed = "WriteSpeed";
    public static String diskSize = "DiskSize";
    public static String rpm = "RPM";
    public static String systemMemoryAlloc = "SystemMemoryAlloc";
    public static String errorCheck = "ErrorCheck";
    public static String standard = "Standard";
    public static String ratedOutput = "RatedOutput";
    public static String certification = "Certification";
    public static String memoryType = "MemoryType";
    public static String tbw = "TBW";
    public static String port = "Port";
    public static String connector = "Connector";

    static String getAttributeName(int idx) {
        String attributeName = "";
		switch(idx) {
			case 1: attributeName = Str.capacity; break;
			case 2: attributeName = Str.certification; break;
			case 3: attributeName = Str.chipset; break;
			case 4: attributeName = Str.clockRate; break;
			case 5: attributeName = Str.coreNumber; break;
			case 6: attributeName = Str.cpuSocket; break;
			case 7: attributeName = Str.diskSize; break;
			case 8: attributeName = Str.fabrication; break;
			case 9: attributeName = Str.formFactor; break;
			case 10: attributeName = Str.manufacturer; break;
			case 11: attributeName = Str.memoryType; break;
			case 12: attributeName = Str.name; break;
			case 13: attributeName = Str.price; break;
			case 14: attributeName = Str.productType; break;
			case 15: attributeName = Str.quantity; break;
			case 16: attributeName = Str.ratedOutput; break;
			case 17: attributeName = Str.readSpeed; break;
			case 18: attributeName = Str.rpm; break;
			case 19: attributeName = Str.standard; break;
			case 20: attributeName = Str.tbw; break;
			case 21: attributeName = Str.tdp; break;
			case 22: attributeName = Str.writeSpeed; break;
        }
        return attributeName;
    }
    static String getAttributeType(int idx) {
		String attributeType = "";
		switch(idx) {
			case 1:
			case 2:
			case 3:
			case 6:
			case 7:
			case 9:
			case 10:
			case 11:
			case 12:
			case 14:
			case 19: attributeType = "String"; break;
			case 5:
			case 8:
			case 13:
			case 15:
			case 16:
			case 17:
			case 18:
			case 20:
			case 21:
			case 22: attributeType = "Long"; break;
			case 4: attributeType = "Double"; break;
        }
        return attributeType;
    }
}