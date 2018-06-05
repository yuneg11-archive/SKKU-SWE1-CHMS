import java.util.Scanner;
import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

abstract class Storage extends Product {
	protected Long capacity; // Unit: GB
	protected Long readSpeed; // Unit: MB/s
	protected Long writeSpeed; // Unit: MB/s
	protected String slot;

	
	public void insert(String excludeKeys) {
		super.insert(excludeKeys);

		try {
			JSONObject required = (JSONObject) (new JSONParser().parse(excludeKeys));
			JSONArray keyArray = (JSONArray) required.get("ExcludeKeys");
			Scanner s = new Scanner(System.in);

			if (!keyArray.contains(Str.capacity)) {
				System.out.print(" Capacity (GB): ");
				this.capacity = s.nextLong();
			}

			if (!keyArray.contains(Str.readSpeed)) {
				System.out.print(" Read Speed (Mb/s): ");
				this.readSpeed = s.nextLong();
			}

			if (!keyArray.contains(Str.writeSpeed)) {
				System.out.print(" Write Speed (Mb/s): ");
				this.writeSpeed = s.nextLong();
				s.nextLine();
			}

			if (!keyArray.contains(Str.slot)) {
				System.out.print(" Slot: ");
				this.slot = s.nextLine();
			}
		} catch (Exception exc) {
			System.out.println("Unexpected error occurred");
		}
	}
}