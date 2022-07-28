package V4_Access;

import V4_Access.classes.*;

public class Main {
  public static void main(String[] args) {
    /*
     * [classess/interfaces/enums access modifiers]
     * 1. Public - class is accessible in its package and can be imported when used
     * outside its package.
     * 2. Package-private - can be accessed only in its package. Class is
     * package-private if no "public" access modifier was added.
     * 3. Private - illegal modifier, class cannot be accessed anywhere.
     */

    PublicClass.hello();
    PublicClass.packagePrivateHello();

    // PackagePrivateClass.hello();

    /*
     * [members access modifiers]
     * Works same as in classes.
     */

    PublicClass x = new PublicClass();

    x.publicMethod();
    // x.protectedMethod():
    // x.privateMethod();
    // x.packagePrivateMethod():
  }
}
