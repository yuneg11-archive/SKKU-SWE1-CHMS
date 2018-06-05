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
			JSONArray keyArray = (JSONArray) required.get("ExcludeKeys");
			Scanner s = new Scanner(System.in);

			if (!keyArray.contains(Str.coreNumber)) {
				System.out.print(" CoreNumber: ");
				this.coreNumber = s.nextLong();
			}

			if (!keyArray.contains(Str.clockRate)) {
				System.out.print(" ClockRate (GHz): ");
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
}