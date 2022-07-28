package V6_Final;

public class Password {
  private static final int key = 777777;

  /*
   * Value of final variable cannot be changed after instantiation.
   */

  private final int hash;
  private final String algorithm = "bcrypt";

  /*
   * Value of final variable can be set in class field OR in the constructor.
   *
   * Technically speaking both approach are equivalent. Setting value in class
   * field is just a shorthand for setting in the constructor.
   */

  public Password(int password) {
    hash = encryptDecrypt(password);
  }

  public String getAlgorithm() {
    return algorithm;
  }

  private int encryptDecrypt(int password) {
    return password ^ key;
  }

  /*
   * Final method cannot be overridden.
   */

  public final boolean validate(int password) {
    if (encryptDecrypt(password) == hash) {
      System.out.println("Valid password.");
      return true;
    } else {
      System.out.println("Invalid password.");
      return false;
    }
  }
}
