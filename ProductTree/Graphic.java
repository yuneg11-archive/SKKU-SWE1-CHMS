import java.util.Scanner;
import JSON.JSONObject;
import JSON.JSONArray;
import JSON.parser.JSONParser;

abstract class Graphic extends Processor {
	protected String chipset;
	protected Memory memory;

	
	public void insert(String excludeKeys) {
		super.insert(excludeKeys);

		try {
			JSONObject required = (JSONObject) (new JSONParser().parse(excludeKeys));
			JSONArray keyArray = (JSONArray) required.get("ExcludeKeys");
			Scanner s = new Scanner(System.in);

			if (!keyArray.contains(Str.chipset)) {
				System.out.print(" Chipset: ");
				this.chipset = s.nextLine();
			}

			if (!keyArray.contains(Str.memory)) {
				System.out.println("===============Graphic Memory===============");
				Memory mem = new Memory();
				mem.insert("{\"ExcludeKeys\":[]}");
				this.memory = mem;
			}
		} catch (Exception exc) {
			System.out.println("Unexpected error occurred");
		}
	}
}