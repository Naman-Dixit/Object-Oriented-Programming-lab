
import java.util.Scanner;

public class SimpleInterest {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rate:");
        double rate = sc.nextDouble();
        System.out.println("Enter principal amount:");
        double Prin = sc.nextDouble();
        System.out.println("Enter Time:");
        int T = sc.nextInt();
        double SI = (Prin * rate * T) / 100;
        System.out.println("Simple interest= " + SI);

    }

}
