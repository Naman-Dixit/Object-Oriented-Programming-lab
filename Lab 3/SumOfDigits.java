import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking input from the user
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        
        int sum = 0;
        int temp = Math.abs(number); // Using absolute value to handle negative numbers

        // Using while loop to calculate the sum of digits
        while (temp > 0) {
            sum += temp % 10; // Extract the last digit and add to sum
            temp /= 10; // Remove the last digit
        }

        // Display the result
        System.out.println("Sum of digits: " + sum);

        scanner.close();
    }
}
