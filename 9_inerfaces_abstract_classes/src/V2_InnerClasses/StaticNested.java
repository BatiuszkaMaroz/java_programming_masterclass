package V2_InnerClasses;

class OuterC {
  private static void outerStaticMethod() {
    System.out.println("Hello from static outer method!");
  }

  private void outerMethod() {
    System.out.println("Hello from outer method!");
  }

  /*
   * static inner classes are technically not inner classes
   * treat them more like static member of outer class
   *
   * they can access all static members of enclosing class
   * and ONLY static ones
   */
  static class Inner {
    public static void innerStaticMethod() {
      System.out.println("Hello from static inner method!");
      outerStaticMethod();

      // outerMethod(); // error
    }

    public void innerMethod() {
      System.out.println("Hello from inner method!");
      outerStaticMethod();

      // outerMethod(); // error
    }
  }

  public void test() {
    /*
     * static inner classes can be used directly in enclosing class
     */

    Inner inner = new Inner();
  }
}

public class StaticNested {
  public static void main(String[] args) {
    /*
     * syntax that was incorrect in class-nested classes
     * is absolutely correct in static-nested classes
     */
    OuterC.Inner inner = new OuterC.Inner();

    /*
     * accessing non-static method
     */
    inner.innerMethod();

    /*
     * accessing static method should take place directly on inner class
     */
    OuterC.Inner.innerStaticMethod();
    // inner.innerStaticMethod(); // warning
  }
}
