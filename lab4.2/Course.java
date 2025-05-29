import java.util.Scanner;

class Course {
    String courseName;
    String courseCode;

    Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Code: " + courseCode);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter course name: ");
        String name = sc.nextLine();
        System.out.print("Enter course code: ");
        String code = sc.nextLine();

        Course course = new Course(name, code);
        course.displayCourseDetails();

        sc.close();
    }
}
