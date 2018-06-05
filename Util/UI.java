import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    static final int width = 61;
    static void print(int level, String msg) {

    }

    static int printMain() {
        System.out.printf("\n\n\n");
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║            Computer Hardware Management System            ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
        System.out.println("╔════════════════════════ MAIN MENU ════════════════════════╗");
        System.out.println("║ - Functions                                               ║");
        System.out.println("║   1. Insert         2. Modify         3. Delete           ║");
        System.out.println("║   4. Search         5. Sort           6. List             ║");
        System.out.println("║   7. Cost Estimation                  8. Exit             ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
        return inputRange(1, 8);
    }

    static void printDelete() {
        System.out.println("╔══════════════════════════ Delete ═════════════════════════╗");
        System.out.println("║ - Enter product name to delete                            ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
    }

    static void printModify() {
        System.out.println("╔══════════════════════════ Modify ═════════════════════════╗");
        System.out.println("║ - Enter product name to modify                            ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
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