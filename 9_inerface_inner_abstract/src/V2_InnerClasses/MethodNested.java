package V2_InnerClasses;

class OuterB {
  private String name;

  public OuterB(String name) {
    this.name = name;
  }

  public void outerMethod(int value) {
    System.out.println("Hello from outer class!");

    /*
     * just like class-nested class method-nested class has access to enclosing
     * class as well
     */

    class Inner {
      public void innerMethod() {
        System.out.println("Hello from inner class!");
        System.out.println("Outer class name = " + OuterB.this.name + ".");

        /*
         * from > java 8 you can use method local variables in inner class methods
         * in earlier versions only variables declared as final could be used
         */

        System.out.println("Argument value = " + value + ".");
      }
    }

    Inner inner = new Inner();
    inner.innerMethod();
  }
}

public class MethodNested {
  public static void main(String[] args) {
    OuterB outer = new OuterB("Bartosh");
    outer.outerMethod(100);
  }
}
