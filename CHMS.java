public class CHMS {
    private static final String databaseFileName = "database.txt";

    public static void main(String[] args) {
        FileManagement fm = new FileManagement(databaseFileName);
        DataManagement dm = new DataManagement(fm.loadDatabase());


        System.out.println(dm.getProducts().get(0).toJSONString());
        /* Do What You Want */

        System.out.println("Program over");
        fm.saveDatabase(dm.getProducts());
    }
}