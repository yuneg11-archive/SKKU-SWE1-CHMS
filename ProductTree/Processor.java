import java.util.Scanner;
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
			Scanner s = new Scanner(System.in);

			if (!keyArray.contains(Str.coreNumber)) {
				System.out.print(" Core Number: ");
				this.coreNumber = s.nextLong();
			}

			if (!keyArray.contains(Str.clockRate)) {
				System.out.print(" Clock Rate (GHz): ");
				this.clockRate = s.nextDouble();
			}

			if (!keyArray.contains(Str.fabrication)) {
				System.out.print(" Fabrication (nm): ");
				this.fabrication = s.nextLong();
			}

			if (!keyArray.contains(Str.tdp)) {
				System.out.print(" TDP (W): ");
				this.tdp = s.nextLong();
				s.nextLine();
			}
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