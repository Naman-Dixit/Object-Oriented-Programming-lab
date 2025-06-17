import Balance.Account;
import java.util.Scanner;

public class TestBalance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial account balance: ");
        double initialBalance = sc.nextDouble();

        Account account = new Account(initialBalance);
        account.Display_Balance();
    }
}
