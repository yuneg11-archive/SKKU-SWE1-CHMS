import java.util.Scanner;

public class UI {
    static final int width = 61;
    static void print(int level, String msg) {

    }

    static int printMain() {
        System.out.println("╔════════════════════════ MAIN MENU ════════════════════════╗");
        System.out.println("║ - Functions                                               ║");
        System.out.println("║   1. Insert      2. Modify      3. Delete                 ║");
        System.out.println("║   4. Search      5. Sort        6. Cost Estimation        ║");
        System.out.println("║   7. Exit                                                 ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
        return inputRange(1, 7);
    }

    static int inputRange(int lowerBound, int upperBound) {
        Scanner input = new Scanner(System.in);
        int select;
        do {
            System.out.print(" Select: ");
            select = input.nextInt();
            if(select >= lowerBound && select <= upperBound) break;
            else System.out.println(" Invalid number");
        } while(true);
        input.close();
        return select;
    }
}