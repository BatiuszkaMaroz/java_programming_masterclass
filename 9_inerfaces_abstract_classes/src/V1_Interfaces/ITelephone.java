package V1_Interfaces;

interface IDevice {
  void powerOn();
}

public interface ITelephone extends IDevice {
  /*
   * interface can extend other interfaces
   *
   * access modifiers are obsolete in interfaces because
   * methods of class that implements an interface are always public
   * (in other way interface does not make sense)
   */

  boolean isRinging();

  void call(int phoneNumber);

  void answer();

  void ring();

  /*
   * default and static methods available since java 8
   */

  default void mute() {
    System.out.println("Muted.");
  }

  static boolean isValidNumber(int number) {
    if (number < 0)
      return false;
    else
      return true;
  }

  /*
   * private methods available since java 9
   * can be used as functionality shared between methods
   */

  private void sharedFunctionality() {
    // something shared
  }
}
