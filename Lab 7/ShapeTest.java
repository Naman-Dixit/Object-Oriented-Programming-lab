import java.util.Scanner;

abstract class Shape {
    abstract void calculateArea();
}

class Rectangle extends Shape {
    double length, breadth;

    Rectangle(double l, double b) {
        length = l;
        breadth = b;
    }

    void calculateArea() {
        System.out.println("Rectangle Area: " + (length * breadth));
    }
}

class Circle extends Shape {
    double radius;

    Circle(double r) {
        radius = r;
    }

    void calculateArea() {
        System.out.println("Circle Area: " + (3.14159 * radius * radius));
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length and breadth of rectangle: ");
        double l = sc.nextDouble();
        double b = sc.nextDouble();

        System.out.print("Enter radius of circle: ");
        double r = sc.nextDouble();

        Shape rect = new Rectangle(l, b);
        Shape circ = new Circle(r);

        rect.calculateArea();
        circ.calculateArea();
    }
}
