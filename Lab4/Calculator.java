import java.util.Scanner;

class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.print("Enter two integers: ");
        int int1 = sc.nextInt();
        int int2 = sc.nextInt();
        System.out.println("Sum of two integers: " + calc.add(int1, int2));

        System.out.print("Enter two decimal numbers: ");
        double double1 = sc.nextDouble();
        double double2 = sc.nextDouble();
        System.out.println("Sum of two doubles: " + calc.add(double1, double2));

        System.out.print("Enter three integers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        System.out.println("Sum of three integers: " + calc.add(num1, num2, num3));

        sc.close();
    }
}
