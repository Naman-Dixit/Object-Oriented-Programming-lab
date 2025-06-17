import java.util.*;

class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Salary: " + salary;
    }
}

public class EmployeeManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        System.out.println("Enter details for 3 employees:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("ID: ");
            int id = sc.nextInt();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            employees.add(new Employee(name, id, salary));
        }

        System.out.print("\nEnter ID to update salary: ");
        int updateId = sc.nextInt();
        System.out.print("Enter new salary: ");
        double newSalary = sc.nextDouble();
        for (Employee emp : employees) {
            if (emp.id == updateId) {
                emp.salary = newSalary;
            }
        }

        System.out.print("Enter ID to remove: ");
        int removeId = sc.nextInt();
        employees.removeIf(emp -> emp.id == removeId);

        System.out.println("Remaining Employees:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
