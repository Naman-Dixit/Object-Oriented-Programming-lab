
import java.util.Scanner;

public class TriangleArea1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input base and height
        System.out.print("Enter base: ");
        double base = scanner.nextDouble();

        System.out.print("Enter height: ");
        double height = scanner.nextDouble();

        // Calculate area
        double area = 0.5 * base * height;

        System.out.println("Area of the triangle: " + area);
        scanner.close();
    }
}
