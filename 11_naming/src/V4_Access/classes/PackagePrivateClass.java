package V4_Access.classes;

/*
 * When public is not added to class declaration, class become package-private
 * meaning its accessible only within package.
 */

class PackagePrivateClass {
  public static void hello() {
    System.out.println("Hello from package-private class!");
  }
}
