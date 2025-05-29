import java.util.Scanner;

class SuperClass {
    private int privateVar;

    SuperClass(int privateVar) {
        this.privateVar = privateVar;
    }

    public int getPrivateVar() {
        return privateVar;
    }
}

class SubClass extends SuperClass {
    SubClass(int privateVar) {
        super(privateVar);
    }

    public void display() {
        System.out.println("Accessing privateVar using getter: " + getPrivateVar());
    }
}

public class PrivateMemberAccess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a value for privateVar: ");
        int value = sc.nextInt();
        SubClass obj = new SubClass(value);
        obj.display();
        sc.close();
    }
}
