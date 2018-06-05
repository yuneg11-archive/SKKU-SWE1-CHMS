import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    static final int width = 73;
    static final String openBox  = "╔═════════════════════════════════════════════════════════════════════════╗";
    static final String closeBox = "╚═════════════════════════════════════════════════════════════════════════╝";
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
    static String content(String msg) {
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

    static int printMain() {
        System.out.printf("\n\n\n");
        System.out.println(openBox);
        System.out.println("║                   Computer Hardware Management System                   ║");
        System.out.println(closeBox);
        System.out.println(title("MAIN MENU"));
        System.out.println(subtitle("Functions"));
        System.out.println(content("1. Insert         2. Modify         3. Delete        4. Search"));
        System.out.println(content("5. Sort           6. List           7. Cost Estimation"));
        System.out.println(content("8. Exit"));
        System.out.println(closeBox);
        return inputRange(1, 8);
    }

    static int printInsert() {
        System.out.println("===============INSERT===============");
        System.out.println("-Type");
        System.out.println("1. CPU \t2. Mainboard \t3. Memory");
        System.out.println("4. Graphic Card \t5. Power Supply");
        System.out.println("6. SSD \t7. HDD \t\t8. Case");
        System.out.println("9. Expansion Card");
        return inputRange(1, 9);
    }

    static void printDelete() {
        System.out.println("╔═════════════════════════════════ Delete ════════════════════════════════╗");
        System.out.println("║ - Enter product name to delete                                          ║");
        System.out.println(closeBox);
    }

    static void printModify() {
        System.out.println("╔═════════════════════════════════ Modify ════════════════════════════════╗");
        System.out.println("║ - Enter product name to modify                                          ║");
        System.out.println(closeBox);
    }

    static int inputRange(int lowerBound, int upperBound) {
        Scanner input = new Scanner(System.in);
        int select;
        do {
            try {
                System.out.print(" Select: ");
                select = input.nextInt();
                if(select >= lowerBound && select <= upperBound) break;
                else System.out.println(" Invalid number");
            } catch(InputMismatchException ex) {
                System.out.println(" Invalid input");
                input.nextLine();
            }
        } while(true);
        return select;
    }

    static boolean inputYesNo(String msg) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String answer = input.nextLine();
            if (answer.compareTo("Y") == 0 || answer.compareTo("y") == 0) {
                return true;
            } else if (answer.compareTo("N") == 0 || answer.compareTo("n") == 0) {
                return false;
            } else {
                System.out.println(" Invalid Input");
            }
        }
    }

    static Long inputLong(String msg) {
        Scanner input = new Scanner(System.in);
        Long value;
        do {
            try {
                System.out.print(msg);
                value = input.nextLong();
                break;
            } catch(InputMismatchException ex) {
                System.out.println(" Invalid input");
                input.nextLine();
            }
        } while(true);
        return value;
    }

    static String inputLine(String msg) {
        Scanner input = new Scanner(System.in);
        String value;
        System.out.print(msg);
        value = input.nextLine();
        return value;
    }
}