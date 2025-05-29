
import java.util.Scanner;

public class Student {

    int age;
    String name;

    public Student() {
        String name = ""; 
        int age = 0;
    }
    

    public Student(String n, int Age) {
       this.name= n;
        this.age=Age;

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Student st = new Student();
        System.out.println("Display original value using default constructor");
        System.out.println("Enter name of the student");
        String name = sc.nextLine();
        System.out.println("Name= " + name);
        System.out.println("Enter age of the student");
        int age = sc.nextInt();
        System.out.println("Age= " + age);
        System.out.println("Display new value using parametrized constructor");
        Student obj = new Student(name, age);
        sc.close();
    }

}
