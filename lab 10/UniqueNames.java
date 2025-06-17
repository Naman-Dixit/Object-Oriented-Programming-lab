import java.util.*;

public class UniqueNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        System.out.print("Enter number of names: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Enter " + n + " names:");
        for (int i = 0; i < n; i++) {
            names.add(sc.nextLine());
        }

        HashSet<String> uniqueNames = new HashSet<>(names);

        System.out.print("Enter name to check existence: ");
        String checkName = sc.nextLine();

        System.out.println("Exists? " + uniqueNames.contains(checkName));

        System.out.println("Unique names:");
        for (String name : uniqueNames) {
            System.out.println(name);
        }
    }
}
