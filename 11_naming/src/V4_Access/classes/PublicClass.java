package V4_Access.classes;

public class PublicClass {
  public static void hello() {
    System.out.println("Hello from public!");
  }

  public static void packagePrivateHello() {
    PackagePrivateClass.hello();
  }

  // ==============================
  // METHODS
  // ==============================

  public void publicMethod() {
    System.out.println("Public method.");
  }

  protected void protectedMethod() {
    System.out.println("Protected method.");
  }

  private void privateMethod() {
    System.out.println("Private method.");
  }

  void packagePrivateMethod() {
    System.out.println("Package-private method.");
  }
}
