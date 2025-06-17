package p;

public class A {
    public void publicMethod() {
        System.out.println("Public Method Called");
    }

    protected void protectedMethod() {
        System.out.println("Protected Method Called");
    }

    void defaultMethod() {
        System.out.println("Default Method Called");
    }

    private void privateMethod() {
        System.out.println("Private Method Called");
    }

    public void callPrivate() {
        privateMethod(); // Accessible inside the same class
    }
}
