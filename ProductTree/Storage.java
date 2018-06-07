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
			JSONArray keyArray = (JSONArray) required.get("ExcludeKey");

			if (!keyArray.contains(Str.capacity))
				this.capacity = UI.inputLong("Capacity (GB)");

			if (!keyArray.contains(Str.readSpeed))
				this.readSpeed = UI.inputLong("Read Speed (Mb/s)");

			if (!keyArray.contains(Str.writeSpeed))
				this.writeSpeed = UI.inputLong("Write Speed (Mb/s)");;

			if (!keyArray.contains(Str.slot))
				this.slot = UI.inputLine("Slot");
		} catch (Exception exc) {
			System.out.println("Unexpected error occurred");
		}
	}

	public void print(String excludeKeys) {
		super.print(excludeKeys);

		try {
			JSONObject required = (JSONObject) (new JSONParser().parse(excludeKeys));
			JSONArray keyArray = (JSONArray) required.get("ExcludeKey");

			if (!keyArray.contains(Str.capacity))
				System.out.println(UI.content("Capacity: "+this.capacity+"GB"));


			if (!keyArray.contains(Str.readSpeed))
				System.out.println(UI.content("Read Speed: "+this.readSpeed+"Mb/s"));


			if (!keyArray.contains(Str.writeSpeed))
				System.out.println(UI.content("Write Speed: "+this.writeSpeed+"Mb/s"));

			if (!keyArray.contains(Str.slot))
				System.out.println(UI.content("Slot: "+this.slot));

		} catch (Exception exc) {
			System.out.println("Unexpected error occurred");
		}
	}
}