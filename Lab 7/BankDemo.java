import java.util.Scanner;

interface Bank {
    void deposit(double amount);
    void withdraw(double amount);
}

class Account implements Bank {
    double balance = 0;

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

public class BankDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = new Account();

        System.out.print("Enter deposit amount: ");
        double dep = sc.nextDouble();
        acc.deposit(dep);

        System.out.print("Enter withdrawal amount: ");
        double wd = sc.nextDouble();
        acc.withdraw(wd);
    }
}
