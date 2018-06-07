import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

abstract class Processor extends Product {
	protected Long coreNumber;
	protected Double clockRate; // Unit: GHz
	protected Long fabrication; // Unit: nm
	protected Long tdp; // Unit: W

	
	public void insert(String excludeKeys) {
		super.insert(excludeKeys);

		try {
			JSONObject required = (JSONObject) (new JSONParser().parse(excludeKeys));
			JSONArray keyArray = (JSONArray) required.get("ExcludeKey");

			if (!keyArray.contains(Str.coreNumber))
				this.coreNumber = UI.inputLong("Core Number");

			if (!keyArray.contains(Str.clockRate))
				this.clockRate = UI.inputDouble("Clock Rate (GHz)");

			if (!keyArray.contains(Str.fabrication))
				this.fabrication = UI.inputLong("Fabrication (nm)");

			if (!keyArray.contains(Str.tdp))
				this.tdp = UI.inputLong("TDP (W)");
		} catch (Exception exc) {
			System.out.println("Unexpected error occurred");
		}
	}

	public void print(String excludeKeys) {
		super.print(excludeKeys);

		try {
			JSONObject required = (JSONObject) (new JSONParser().parse(excludeKeys));
			JSONArray keyArray = (JSONArray) required.get("ExcludeKey");

			if (!keyArray.contains(Str.coreNumber))
				System.out.println(UI.content("Core Number: "+this.coreNumber));

			if (!keyArray.contains(Str.clockRate))
				System.out.println(UI.content("Clock Rate: "+this.clockRate+"GHz"));


			if (!keyArray.contains(Str.fabrication))
				System.out.println(UI.content("Fabrication: "+this.fabrication+"nm"));


			if (!keyArray.contains(Str.tdp))
				System.out.println(UI.content("TDP: "+this.tdp+"W"));

		} catch (Exception exc) {
			System.out.println("Unexpected error occurred");
		}
	}
}