package Q;
import p.A;

public class B {
    public static void main(String[] args) {
        A obj = new A();

        obj.publicMethod();         // accessible
        // obj.protectedMethod();   // not accessible without inheritance
        // obj.defaultMethod();     // not accessible from different package
        // obj.privateMethod();     // not accessible at all
        obj.callPrivate();          // accessible if public method calls private
    }
}
