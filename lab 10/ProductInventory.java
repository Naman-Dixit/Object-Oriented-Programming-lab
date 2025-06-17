import java.util.*;

public class ProductInventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> inventory = new HashMap<>();

        System.out.println("Enter details for 3 products:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Product ID: ");
            int pid = sc.nextInt();
            System.out.print("Quantity: ");
            int qty = sc.nextInt();
            inventory.put(pid, qty);
        }

        System.out.print("Enter Product ID to update quantity: ");
        int updateId = sc.nextInt();
        System.out.print("New quantity: ");
        int newQty = sc.nextInt();
        inventory.put(updateId, newQty);

        System.out.print("Enter Product ID to remove: ");
        int removeId = sc.nextInt();
        inventory.remove(removeId);

        System.out.println("Final Inventory:");
        for (Map.Entry<Integer, Integer> entry : inventory.entrySet()) {
            System.out.println("Product ID: " + entry.getKey() + " -> Quantity: " + entry.getValue());
        }
    }
}
