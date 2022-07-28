package V7_InitBlock;

public class Initializer {
  public static int version;
  public String name;

  /*
   * Static initializer blocks run only once, after class was loaded into
   * program (resolved).
   */

  static {
    System.out.println("Static initializer.");
    version = 2;
  }

  /*
   * Instance initializer blocks run before constructor.
   */

  {
    name = "pre";
  }

  public Initializer(String name) {
    this.name += name;
  }

  {
    name += "fix-";
  }

  public String getName() {
    return name;
  }
}
