import JSON.JSONObject;

import java.util.InputMismatchException;
import java.util.Scanner;


public class UI {
    static final int width = 73;
    static final String openBox    = "╔═════════════════════════════════════════════════════════════════════════╗";
    static final String closeBox   = "╚═════════════════════════════════════════════════════════════════════════╝";
    static final String seperatingLine = "╟─────────────────────────────────────────────────────────────────────────╢";
    static void print(int level, String msg) {

    }

    static String title(String msg) {
        String title = "";
        int msgLen = msg.length()+2;
        title += "╔";
        for(int i = 0; i < (width-msgLen)/2; i++) {
            title += "═";
        }
        title += (" " + msg + " ");
        for(int i = 0; i < (width-msgLen)-((width-msgLen)/2); i++) {
            title += "═";
        }
        title += "╗";
        return title;
    }
    static String subtitle(String msg) {
        String subtitle = "";
        int msgLen = msg.length()+3;
        subtitle += "║";
        subtitle += (" - " + msg);
        for(int i = 0; i < width-msgLen; i++) {
            subtitle += " ";
        }
        subtitle += "║";
        return subtitle;
    }
    static String subcontent(String msg) {
        String content = "";
        int msgLen = msg.length()+3;
        content += "║";
        content += ("   " + msg);
        for(int i = 0; i < width-msgLen; i++) {
            content += " ";
        }
        content += "║";
        return content;
    }
    static String content(String msg) {
        String content = "";
        int msgLen = msg.length()+1;
        content += "║";
        content += (" " + msg);
        for(int i = 0; i < width-msgLen; i++) {
            content += " ";
        }
        content += "║";
        return content;
    }

    static String prompt(String msg) {
        return " "+msg;
    }

    static int printMain() {
        System.out.printf("\n\n\n");
        System.out.println(openBox);
        System.out.println("║                   Computer Hardware Management System                   ║");
        System.out.println(closeBox);
        System.out.println(title("MAIN MENU"));
        System.out.println(subtitle("Functions"));
        System.out.println(subcontent("1. Insert         2. Modify         3. Delete        4. Search"));
        System.out.println(subcontent("5. Sort           6. List           7. Cost Estimation"));
        System.out.println(subcontent("8. Exit"));
        System.out.println(closeBox);
        return inputRange(1, 8);
    }

    static int printInsert() {
        System.out.println(title("Insert"));
        System.out.println(subtitle("Type"));
        System.out.println(subcontent("1. CPU              2. Mainboard     3. Memory     4. Graphic Card"));
        System.out.println(subcontent("5. Power Supply     6. SSD           7. HDD        8. Case"));
        System.out.println(subcontent("9. Expansion Card"));
        System.out.println(closeBox);
        return inputRange(1, 9);
    }

    static void printDelete() {
        System.out.println(title("Delete"));
        System.out.println(subtitle("Enter product name to delete"));
        System.out.println(closeBox);
    }

    static void printModify() {
        System.out.println(title("Modify"));
        System.out.println(subtitle("Enter product name to modify"));
        System.out.println(closeBox);
    }
    static int printSearch() {
        System.out.println(title("Search"));
        System.out.println(subtitle("Select attribute to search"));
        System.out.println(subcontent(" 1. Capacity      2. Certification  3. Chipset         4. ClockRate"));
        System.out.println(subcontent(" 5. Core Number   6. CPU Socket     7. DiskSize        8. Fabrication"));
        System.out.println(subcontent(" 9. Form Factor  10. Manufacturer  11. Memory Type    12. Name"));
        System.out.println(subcontent("13. Price        14. Product Type  15. Quantity       16. Rated Output"));
        System.out.println(subcontent("17. Read Speed   18. RPM           19. Memory Standard   20. TBW"));
        System.out.println(subcontent("21. TDP          22. Write Speed"));
        System.out.println(closeBox);
        return inputRange(1, 22);
    }
    static int printSort() {
        System.out.println(title("Sort"));
        System.out.println(subtitle("Select attribute to sort"));
        System.out.println(subcontent(" 1. Capacity      2. Certification  3. Chipset         4. ClockRate"));
        System.out.println(subcontent(" 5. Core Number   6. CPU Socket     7. DiskSize        8. Fabrication"));
        System.out.println(subcontent(" 9. Form Factor  10. Manufacturer  11. Memory Type    12. Name"));
        System.out.println(subcontent("13. Price        14. Product Type  15. Quantity       16. Rated Output"));
        System.out.println(subcontent("17. Read Speed   18. RPM           19. Memory Standard   20. TBW"));
        System.out.println(subcontent("21. TDP          22. Write Speed"));
        System.out.println(closeBox);
        return inputRange(1, 22);
    }

    static int inputRange(int lowerBound, int upperBound) {
        return inputRange("Select", lowerBound, upperBound);
    }
    static int inputRange(String msg, int lowerBound, int upperBound) {
        Scanner input = new Scanner(System.in);
        int select;
        do {
            try {
                System.out.print(prompt(msg+": "));
                select = input.nextInt();
                if(select >= lowerBound && select <= upperBound) break;
                else System.out.println(prompt("Invalid number"));
            } catch(InputMismatchException ex) {
                System.out.println(prompt("Invalid input"));
                input.nextLine();
            }
        } while(true);
        return select;
    }

    static boolean inputYesNo(String msg) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print(prompt(msg+": "));
            String answer = input.nextLine();
            if (answer.compareTo("Y") == 0 || answer.compareTo("y") == 0) {
                return true;
            } else if (answer.compareTo("N") == 0 || answer.compareTo("n") == 0) {
                return false;
            } else {
                System.out.println(prompt("Invalid input"));
            }
        }
    }

    static Long inputLong(String msg) {
        Scanner input = new Scanner(System.in);
        Long value;
        do {
            try {
                System.out.print(prompt(msg+": "));
                value = input.nextLong();
                if(value >= 0) break;
                else System.out.println(prompt("Invalid number"));
            } catch(InputMismatchException ex) {
                System.out.println(prompt("Invalid input"));
                input.nextLine();
            }
        } while(true);
        return value;
    }

    static Double inputDouble(String msg) {
        Scanner input = new Scanner(System.in);
        Double value;
        do {
            try {
                System.out.print(prompt(msg+": "));
                value = input.nextDouble();
                if(value >= 0) break;
                else System.out.println(prompt("Invalid number"));
            } catch(InputMismatchException ex) {
                System.out.println(prompt("Invalid input"));
                input.nextLine();
            }
        } while(true);
        return value;
    }

    static String inputLine(String msg) {
        Scanner input = new Scanner(System.in);
        String value;
        System.out.print(prompt(msg+": "));
        value = input.nextLine();
        return value;
    }
}