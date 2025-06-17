import java.util.*;

public class UniqueSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();

        System.out.print("Enter number of integers: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }

        HashSet<Integer> unique = new HashSet<>(nums);
        int sum = 0;
        for (int num : unique) {
            sum += num;
        }

        System.out.println("Unique values: " + unique);
        System.out.println("Sum of unique values: " + sum);
    }
}
