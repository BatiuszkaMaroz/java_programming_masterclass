package V6_Final;

public class Main {

  public static void main(String[] args) {
    /*
     * Final classess cannot be extended.
     */

    // Final extendedFinal = new Final() {};

    // ============================================================

    int pwd = 123456;
    Password password = new Password(pwd);

    /*
     * Value of final variables cannot be changed.
     */

    // password.algorithm = "sha";

    password.validate(0);
    password.validate(-123456);
    password.validate(654321);
    password.validate(pwd);

    // ============================================================

    Password extendedPassword = new Password(pwd) {
      /*
       * When overridding methods we can add final modifier.
       */

      @Override
      public final String getAlgorithm() {
        return "";
      }

      /*
       * Final method cannot be overridden.
       */

      // @Override
      // public final boolean validate(int password) {
      // return true;
      // }
    };
  }
}
