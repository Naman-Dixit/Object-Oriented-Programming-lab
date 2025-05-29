
import java.util.Scanner;

public class PatternPrinting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        for (int i = 1; i <= rows; i++) {
            if (i % 2 == 1) {
                for (int j = 0; j < (2 * i - 1); j++) {
                    System.out.print("? ");
                }
            } else {
                for (int j = 0; j < (2 * i - 1); j++) {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}
