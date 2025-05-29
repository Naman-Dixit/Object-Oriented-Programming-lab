import java.util.Scanner;

class Student {
    static String universityName = "UPES";  // Shared among all instances
    String studentName; // Unique for each object

    Student(String studentName) {
        this.studentName = studentName;
    }

    static void displayUniversityName() {
        System.out.println("University Name:"  + universityName);
    }

    void displayStudentDetails() {
        System.out.println("Student Name:"  + studentName);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        displayUniversityName();

        System.out.print("Enter student 1 name:" );
        String student1Name = sc.nextLine();
        System.out.print("Enter student 2 name:" );
        String student2Name = sc.nextLine();

        Student s1 = new Student(student1Name);
        Student s2 = new Student(student2Name);

        s1.displayStudentDetails();
        s2.displayStudentDetails();

        sc.close();
    }
}
