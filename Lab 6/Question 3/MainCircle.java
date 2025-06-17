import java.util.Scanner;

public class MainCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle c = new Circle();

        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();

        c.displayPI();
        c.calculateArea(radius);

        // c.PI = 3.0; // ❌ Compile-time error: cannot assign a value to final variable
    }
}
